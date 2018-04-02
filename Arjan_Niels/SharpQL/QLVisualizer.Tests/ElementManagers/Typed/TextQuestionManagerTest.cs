﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using QLVisualizer.Elements.Managers.LeafTypes;

namespace QLVisualizer.Tests.Elements.Managers.Typed
{
    [TestClass]
    public class TextQuestionManagerTest : ElementQuestionManagerTest<StringQuestionManager, string>
    {
        [TestInitialize]
        public void Initialize()
        {
            Widget = new StringQuestionManager("id", "question", null, null);
        }

        [TestMethod]
        public override void AssignTest()
        {
            Widget.SetAnswer("unittest");
            Assert.AreEqual("unittest", Widget.Answer.Value);
        }

        [TestMethod]
        public override void ValueTest()
        {
            Assert.AreEqual(null, Widget.Answer.Value);
        }
    }
}
