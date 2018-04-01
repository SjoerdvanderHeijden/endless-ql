package org.uva.jomi.ui.views.core;

import java.awt.Dimension;
import javax.swing.JFrame;


public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800, 600));
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		this.pack();
	}

}
