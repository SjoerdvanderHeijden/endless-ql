﻿using System.Collections.Generic;
using QuestionnaireDomain.Entities.Ast.Nodes.Common.Interfaces;
using QuestionnaireDomain.Entities.Domain;

namespace QlsTransformer.Domain.Ast.Nodes
{
    public interface ISectionNode : IStyleSheetCompartment, IAstNode
    {
        string Name { get; }

        IEnumerable<DomainId<IQlsQuestionNode>> Questions { get; }
    }
}