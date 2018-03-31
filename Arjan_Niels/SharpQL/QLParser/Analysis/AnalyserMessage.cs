﻿namespace QLParser.Analysis
{
    public enum MessageType
    {
        ERROR,
        WARNING
    }

    public class AnalyserMessage
    {
        public MessageType Type { get; private set; }
        public string Message { get; private set; }

        public AnalyserMessage(string message, MessageType type)
        {
            this.Message = message;
            this.Type = type;
        }

        public override string ToString()
        {
            return string.Format("{0} {1}", this.Type, this.Message);
        }
    }
}