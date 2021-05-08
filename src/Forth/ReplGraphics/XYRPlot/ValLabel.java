package Forth.ReplGraphics.XYRPlot;

import Forth.ReplGraphics.DataHandler;
import Forth.ReplGraphics.GraphicsCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ValLabel implements DataHandler {
	JFrame frame;
	JLabel label;

	GraphicsCore core;

	@Override
	public void accept(String[] params) {
		StringBuilder text = new StringBuilder();
		for (String s : params)
			text.append(s);
		label.setText(text.toString());
	}

	public ValLabel(GraphicsCore core){
		this.core = core;

		frame = new JFrame("Label");
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 100);
		label = new JLabel();
		frame.add(label);
		frame.setVisible(true);

		ValLabel me = this; // Augh!
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				core.remove_object(me);
			}
		});
	}
}
