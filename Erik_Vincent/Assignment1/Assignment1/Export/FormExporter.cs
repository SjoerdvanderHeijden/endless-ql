﻿using Assignment1.Model.QL;
using System;
using System.Windows.Forms;
using Assignment1.Model.QL.RenderTree;

namespace Assignment1.Export
{
    class FormExporter
    {
        private readonly QuestionForm _form;

        public FormExporter(QuestionForm form)
        {
            _form = form;
        }

        public Panel Render()
        {
            FlowLayoutPanel formExportPanel = new FlowLayoutPanel
            {
                AutoSizeMode = AutoSizeMode.GrowOnly,
                FlowDirection = FlowDirection.LeftToRight,
                //Anchor = AnchorStyles.Bottom
            };
            Button formExportButton = new Button
            {
                Text = "Submit",
                Height = 40,
                //Anchor = AnchorStyles.Right
            };
            formExportButton.Click += ExportToXML;
            formExportPanel.Controls.Add(formExportButton);
            return formExportPanel;
        }

        public void ExportToXML(object sender, EventArgs e)
        {

        }
    }
}
