﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment1.Model.QL.Value
{
    interface IAnswerComputable<T>
    {
        IAnswerValuable<T> Add<U>(IAnswerValuable<U> right);

        IAnswerValuable<T> Subtract<U>(IAnswerValuable<U> right);

        IAnswerValuable<T> Multiply<U>(IAnswerValuable<U> right);

        IAnswerValuable<T> Divide<U>(IAnswerValuable<U> right);
    }
}
