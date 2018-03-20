﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Assignment1
{
    public partial class Form1 : Form, IMainView
    {
        public Form1()
        {
            InitializeComponent();
            var presenter = new MainPresenter(this);
            openFileButton.Click += SelectQLFile;
        }

        public event EventHandler SelectQLFile;

        public void SetFormControl(Control control)
        {
            _questionFormPanel.Controls.Clear();
            _questionFormPanel.Controls.Add(control);
        }

        public void SetErrors(List<string> errors)
        {
            if (errors == null || errors.Count == 0)
                return;
            var header = new Label
            {
                Text = "Provided form is invalid!",
                Width = 1000,
                Height = 30,
                TextAlign = ContentAlignment.MiddleCenter,
                Font = new Font("Arial", 12, FontStyle.Bold)
            };
            _messagePanel.Controls.Add(header);
            foreach (string error in errors)
            {
                var label = new Label
                {
                    Text = error,
                    Width = 1000,
                    Font = new Font("Arial", 10),
                    ForeColor = Color.Red
                };
                _messagePanel.Controls.Add(label);
            }
        }

        // TODO: similar to SetErrors, extract
        public void SetWarnings(List<string> warnings)
        {
            if (warnings == null || warnings.Count == 0)
                return;
            var header = new Label
            {
                Text = "Warning:",
                AutoSize = true,
                Font = new Font("Arial", 9, FontStyle.Bold)
            };
            _messagePanel.Controls.Add(header);
            foreach (var warning in warnings)
            {
                var label = new Label
                {
                    Text = warning,
                    AutoSize = true,
                    Font = new Font("Arial", 8),
                    ForeColor = Color.DarkOrange
                };
                _messagePanel.Controls.Add(label);
            }
        }
    }
}
