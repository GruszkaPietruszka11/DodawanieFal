package addingWaves;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**Panel for changing graph settings for component waves (functions)
 * Most of the functionality not implemented yet
 */

public class SettingsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel amplitude, frequency, phaze;
	private JTextField amplitudeText, frequencyText, phazeText;
	private JComboBox<String> amplitudeBox, frequencyBox, phazeBox;
	private JButton settingsButton, colorButton, applyButton;
	private GraphPanel panel;
	
	public GraphPanel getPanel() {return panel;}
	public SettingsPanel() {
		panel = new GraphPanel();
		this.setLayout(new MigLayout());
		
		amplitude = new JLabel("A");
		this.add(amplitude);
		amplitude.setToolTipText("Amplitude");
		
		amplitudeText = new JTextField(5);
		this.add(amplitudeText);
		
		String[] amplitudeUnits = {"Pa","hPa"};
		amplitudeBox = new JComboBox<String>(amplitudeUnits);
		this.add(amplitudeBox);
		
		settingsButton = new JButton("Settings");
		// panel.doEditChartProperties(); <- pokazuje okienko z ustawieniami(do listenera)
		this.add(settingsButton, "gap 10, wrap 10:30");
		settingsButton.setToolTipText("Advanced graph settings");
		
		frequency = new JLabel("f");
		this.add(frequency);
		frequency.setToolTipText("Frequency");
		
		frequencyText = new JTextField(5);
		this.add(frequencyText);
		
		String[] frequencyUnits = {"Hz","kHz"};
		frequencyBox = new JComboBox<String>(frequencyUnits);
		this.add(frequencyBox);
		
		colorButton = new JButton("Color");
		this.add(colorButton, "gap 10, wrap 10:30");
		colorButton.setToolTipText("Change graph color");
		
		phaze = new JLabel("φ");
		this.add(phaze);
		phaze.setToolTipText("Phaze");
		
		phazeText = new JTextField(5);
		this.add(phazeText);
		
		String[] phazeUnits = {"degree","radians"};
		phazeBox = new JComboBox<String>(phazeUnits);
		this.add(phazeBox);
		
		applyButton = new JButton("Apply");
		this.add(applyButton, "gap 10, wrap");
		applyButton.setToolTipText("Apply changes");
		
	}

}
