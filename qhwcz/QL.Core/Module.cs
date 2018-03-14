﻿using Infrastructure;
using QL.Api.Infrastructure;
using QL.Core.Infrastructure;

namespace QL.Core
{
    public static class Module
    {
        public static Pipeline<ParsingTask> ParsingPipeline { get; } = CreateParsingPipeline();
        public static Pipeline<InterpretingTask> InterpretingPipeline { get; } = CreateInterpretingPipeline();

        private static Pipeline<ParsingTask> CreateParsingPipeline()
        {
            var parsingPipeline = new Pipeline<ParsingTask>();
            parsingPipeline.ConnectElement(new ParsingPipelineElement());
            parsingPipeline.ConnectElement(new SymbolExtractionPipelineElement());
            parsingPipeline.ConnectElement(new DuplicateSymbolDetectionPipelineElement());
            parsingPipeline.ConnectElement(new ReferenceCheckingPipelineElement());
            parsingPipeline.ConnectElement(new TypeCheckingPipelineElement());
            return parsingPipeline;
        }

        private static Pipeline<InterpretingTask> CreateInterpretingPipeline()
        {
            var interpretingPipeline = new Pipeline<InterpretingTask>();
            interpretingPipeline.ConnectElement(new InterpretingPipelineElement());
            return interpretingPipeline;
        }
    }
}
