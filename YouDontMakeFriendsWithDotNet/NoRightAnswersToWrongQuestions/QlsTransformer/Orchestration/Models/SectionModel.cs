﻿using System;
using System.Collections.Generic;

namespace QlsTransformer.Orchestration.Models
{
    public class SectionModel
    {
        public SectionModel(
            Guid segmentId,
            string segmentDisplayName)
        {
            SegmentId = segmentId;
            SegmentDisplayName = segmentDisplayName;
        }

        public Guid SegmentId { get; }
        public string SegmentDisplayName { get; }

        public IList<StyledQuestionModel> Questions { get; }
            = new List<StyledQuestionModel>();
    }
}