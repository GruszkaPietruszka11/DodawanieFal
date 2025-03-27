package DodawanieFal;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class SettingsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel amplitude, frequency, phaze;
	private JTextField amplitudeText, frequencyText, phazeText;
	private JComboBox<String> amplitudeBox, frequencyBox, phazeBox;
	private JButton settingsButton, colorButton, applyButton;
	public SettingsPanel() {
		this.setLayout(new MigLayout());
		
		amplitude = new JLabel("A");
		this.add(amplitude);
		
		amplitudeText = new JTextField(5);
		this.add(amplitudeText);
		
		String[] amplitudeUnits = {"Pa","hPa"};
		amplitudeBox = new JComboBox<String>(amplitudeUnits);
		this.add(amplitudeBox);
		
		settingsButton = new JButton("Settings");
		this.add(settingsButton, "gap 10, wrap");
		
		frequency = new JLabel("f");
		this.add(frequency);
		
		frequencyText = new JTextField(5);
		this.add(frequencyText);
		
		String[] frequencyUnits = {"Hz","kHz"};
		frequencyBox = new JComboBox<String>(frequencyUnits);
		this.add(frequencyBox);
		
		colorButton = new JButton("Color");
		this.add(colorButton, "gap 10, wrap");
		
		phaze = new JLabel("φ");
		this.add(phaze);
		
		phazeText = new JTextField(5);
		this.add(phazeText);
		
		String[] phazeUnits = {"degree","radians"};
		phazeBox = new JComboBox<String>(phazeUnits);
		this.add(phazeBox);
		
		applyButton = new JButton("Apply");
		this.add(applyButton, "gap 10, wrap");
		
	}

}
