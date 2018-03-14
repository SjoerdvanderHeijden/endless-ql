﻿using QL.Api.Ast;
using QL.Api.Entities;
using QL.Api.Infrastructure;
using Presentation.ViewModels;
using QLS.Api.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using Presentation.Visitors;
using Infrastructure;

namespace Presentation.Controllers
{
    internal class MainController
    {        
        private readonly Pipeline<ParsingTask> _parsingPipeline;
        private readonly Pipeline<InterpretingTask> _interpretingPipeline;
        private readonly Pipeline<StylesheetTask> _stylesheetPipeline;

        private readonly MainViewModel _mainViewModel;
        private Node _qlAst;
        private MemorySystem _memory;
        private SymbolTable _symbols;

        public MainController(MainViewModel viewModel,
                              Pipeline<ParsingTask> parsingPipeline,
                              Pipeline<InterpretingTask> interpretingPipeline,
                              Pipeline<StylesheetTask> stylesheetPipeline)
        {
            _mainViewModel = viewModel;
            _parsingPipeline = parsingPipeline;
            _interpretingPipeline = interpretingPipeline;
            _stylesheetPipeline = stylesheetPipeline;

            viewModel.RebuildQuestionnaireCommand = new RelayCommand<string>(RebuildQuestionnaireCommand_Execute);
        }

        private void RebuildQuestionnaireCommand_Execute(string questionnaireInput)
        {            
            var parsingTask = _parsingPipeline.Process(new ParsingTask(questionnaireInput));
            if (parsingTask.Errors.Count > 0)
            {
                _mainViewModel.QuestionnaireValidation = parsingTask.Errors.Aggregate(
                $"Validation failed! There are {parsingTask.Errors.Count} error(s) in your questionnaire.",
                (err, acc) => err + Environment.NewLine + acc);
                return;
            }
            _symbols = parsingTask.SymbolTable;
            _qlAst = parsingTask.Ast;
            _memory = new MemorySystem();
            _mainViewModel.QuestionnaireValidation = "Validation succeeded! Enjoy your questionnaire.";
            
            RebuildQuestionnaire(parsingTask.Ast);
        }

        private void QuestionValueAssignedCommand_Execute(object target)
        {
            var questionViewModel = target as QuestionViewModel;

            Value memoryValue;
            if(!_memory.TryRetrieveValue(questionViewModel.Id, out memoryValue))
            {
                memoryValue = new Value(_symbols[questionViewModel.Id].Type);
            }
            _memory.AssignValue(questionViewModel.Id, new Value(questionViewModel.Value, memoryValue.Type));                        
            RebuildQuestionnaire(_qlAst);
        }

        private void RebuildQuestionnaire(Node evaluatedAst)
        {
            _mainViewModel.Form = CreateFormViewModelFromQL(evaluatedAst);
            _mainViewModel.Form.Pages = CreatePagesFromStylesheet();
        }

        private FormViewModel CreateFormViewModelFromQL(Node ast)
        {
            var interpretingTask = _interpretingPipeline.Process(new InterpretingTask(ast, _memory, _symbols));

            var formBuildingVisitor = new QuestionnaireVisitor();
            interpretingTask.InterpretedAst.Accept(formBuildingVisitor);

            FormViewModel form = formBuildingVisitor.Form;
            form.QuestionValueAssignedCommand = new RelayCommand<QuestionViewModel>(QuestionValueAssignedCommand_Execute);
            return form;
        }

        private PagesViewModel CreatePagesFromStylesheet()
        {
            IReadOnlyList<QuestionViewModel> questionViewModels = _mainViewModel.Form.Questions.ToList();
            var stylesheetTask = new StylesheetTask(_mainViewModel.StylesheetInput, questionViewModels.Select(x => x.Id).ToList());
            var processedStylesheet = _stylesheetPipeline.Process(stylesheetTask);

            var stylesheetVisitor = new StylesheetVisitor(questionViewModels);
            processedStylesheet.Ast.Accept(stylesheetVisitor);
            return stylesheetVisitor.PagesViewModel;
        }
    }
}