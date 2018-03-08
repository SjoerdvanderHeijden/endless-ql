using Microsoft.VisualStudio.TestTools.UnitTesting;
using QLVizualizer.ElementManagers;

namespace QLVisualizer.Tests.ElementManagers
{
    [TestClass]
    public abstract class ElementManagerTest<T> where T : ElementManager
    {
        protected T Widget;

        [TestMethod]
        public void ActiveTest()
        {
            Assert.IsTrue(Widget.Active);
        }
    }
}