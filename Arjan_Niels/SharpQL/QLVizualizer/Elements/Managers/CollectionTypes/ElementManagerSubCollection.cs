﻿using QLVisualizer.Controllers;
using QLVisualizer.Expression.Types;

namespace QLVisualizer.Elements.Managers.CollectionTypes
{
    public abstract class ElementManagerSubCollection : ElementManagerCollection
    {
        public ElementManagerSubCollection(string identifier, string text, string xmlName, ElementManagerCollection parent, ElementManagerController controller, ExpressionBool activationExpression = null) :
            base(identifier, text, xmlName, controller, activationExpression)
        {
            Parent = parent;
        }
    }
}
