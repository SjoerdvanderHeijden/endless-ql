﻿using QLParser.AST.QLS;
using QLVisualizer.Elements.Managers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QLVisualizer.Widgets
{
    public interface IWidgetBuilder<T>
    {
        T Create();
        
        void SetParentStyle(List<QLSValue> elements);

        ElementManager GetElementManager();
    }
}