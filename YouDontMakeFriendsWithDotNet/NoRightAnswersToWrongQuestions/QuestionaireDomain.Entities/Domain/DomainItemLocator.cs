﻿using System;
using System.Collections.Generic;
using System.Linq;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain.Interfaces;

namespace QuestionnaireDomain.Entities.Domain
{
    public class DomainItemLocator : IDomainItemLocator
    {
        private readonly IDomainItemRegistry m_registry;

        public DomainItemLocator(IDomainItemRegistry registry)
        {
            m_registry = registry;
        }

        public TDomainItem Get<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            return m_registry.Find<TDomainItem>(id);
        }

        public Reference<TDomainItem> GetRef<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            var domainItem = m_registry.Find<TDomainItem>(id);
            return new Reference<TDomainItem>(domainItem.Id);
        }

        public IEnumerable<TDomainItem> GetAll<TDomainItem>() where TDomainItem : IDomainItem
        {
            return m_registry.GetAll<TDomainItem>();
        }

        public IEnumerable<Reference<TDomainItem>> GetAllRefs<TDomainItem>() where TDomainItem : IDomainItem
        {
            return m_registry
                .GetAll<TDomainItem>()
                .Select(x => new Reference<TDomainItem>(x.Id));
        }

        public bool Exists<TDomainItem>(Guid id) where TDomainItem : IDomainItem
        {
            try
            {
                return m_registry.Find<TDomainItem>(id) != null;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public Reference<IQuestionnaireRootNode> GetRoot(Reference<IQuestionNode> node)
        {
            // ToDo: Hack for now - assuming just one questionnaire, however will have to put parent into astnodes
            // to do this properly
            return GetAllRefs<IQuestionnaireRootNode>().FirstOrDefault();
        }
    }
}