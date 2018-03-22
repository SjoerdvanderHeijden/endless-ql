﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using QLParser.Analysis;
using QLParser.Analysis.Semantic;
using QLParser.AST.QL;
using System.Linq;

namespace QLParser.Tests.AST
{
    [TestClass]
    public class SymbolTableTests : QLTest
    {
        private FormNode SimpleForm;
        private readonly string _simpleFormRaw = "form SimpleForm { }";

        private FormNode OneVarForm;
        private readonly string _oneVarFormRaw = "form OneVar { " +
            "\"Have you bought a house in 2018?\"" +
            "       boughtAHouse: boolean" +
            "}";

        private FormNode MultipleVarForm;
        private readonly string _multipleVarFormRaw = "form MultipleVarForm {" +
            "   \"Have you bought a house in 2018?\"" +
            "       boughtAHouse: boolean" +
            "" +
            "   \"What was the selling price?\"" +
            "       priceHouse: money" +
            "}";

        [TestInitialize]
        public void Initialize()
        {
            OneVarForm = QLParserHelper.Parse(_oneVarFormRaw);
            MultipleVarForm = QLParserHelper.Parse(_multipleVarFormRaw);

            SymbolTable.Reset();
            Analyser.Reset();
        }

        #region No vars
        [TestMethod]
        public void NoVariablesInSymbolTable()
        {
            SimpleForm = QLParserHelper.Parse(_simpleFormRaw);
            Assert.AreEqual(0, SymbolTable.Instance.TypeMap.Count);
        }
        #endregion

        #region One var
        [TestMethod]
        public void OneVariableInSymbolTable()
        {
            var varAnalyser = new DuplicateVariableAnalyser();
            var hasSucceeded = varAnalyser.Analyse(OneVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual(1, SymbolTable.Instance.TypeMap.Count);
        }

        [TestMethod]
        public void CheckNameOneVarInSymbolTable()
        {
            var validator = new DuplicateVariableAnalyser();
            var hasSucceeded = validator.Analyse(OneVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual("boughtAHouse", SymbolTable.Instance.TypeMap.Keys.ToArray()[0]);
        }

        [TestMethod]
        public void CheckTypeInSymbolTable()
        {
            var validator = new DuplicateVariableAnalyser();
            var hasSucceeded = validator.Analyse(OneVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual(QValueType.BOOLEAN, SymbolTable.Get("boughtAHouse"));
        }
        #endregion

        #region Multiple vars
        [TestMethod]
        public void MultipleVarsCountSymbolTable()
        {
            var validator = new DuplicateVariableAnalyser();
            var hasSucceeded = validator.Analyse(MultipleVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual(2, SymbolTable.Instance.TypeMap.Count);
        }

        [TestMethod]
        public void MultipleVarsNameCheck()
        {
            var validator = new DuplicateVariableAnalyser();
            var hasSucceeded = validator.Analyse(MultipleVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual("boughtAHouse", SymbolTable.Instance.TypeMap.Keys.ToArray()[0]);
            Assert.AreEqual("priceHouse", SymbolTable.Instance.TypeMap.Keys.ToArray()[1]);
        }

        [TestMethod]
        public void MultipleVarsTypeCheck()
        {
            var validator = new DuplicateVariableAnalyser();
            var hasSucceeded = validator.Analyse(MultipleVarForm);

            Assert.IsTrue(hasSucceeded);
            Assert.AreEqual(QValueType.BOOLEAN, SymbolTable.Get("boughtAHouse"));
            Assert.AreEqual(QValueType.MONEY, SymbolTable.Get("priceHouse"));
        }
        #endregion
    }
}