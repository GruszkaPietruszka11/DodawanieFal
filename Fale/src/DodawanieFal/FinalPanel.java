package DodawanieFal;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class FinalPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JCheckBox result, function1, function2;
	private JButton settingsButton, colorButton, applyButton, playButton;
	public FinalPanel() {
		this.setLayout(new MigLayout("flowy, filly"));
		
		result = new JCheckBox("show result function");
		this.add(result);
		
		function1 = new JCheckBox("show function 1");
		this.add(function1);
		
		function2 = new JCheckBox("show function 2");
		this.add(function2);
		
		playButton = new JButton("Play sound");
		this.add(playButton, "wrap");
		
		settingsButton = new JButton("Settings");
		this.add(settingsButton);
		settingsButton.setToolTipText("Advanced graph settings");
		
		colorButton = new JButton("Color");
		this.add(colorButton);
		colorButton.setToolTipText("Change graph color");
		
		applyButton = new JButton("Apply");
		this.add(applyButton);
		applyButton.setToolTipText("Apply changes");
	}
}