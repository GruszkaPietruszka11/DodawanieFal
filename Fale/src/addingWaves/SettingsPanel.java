package addingWaves;

import java.awt.Color;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**Panel for changing graph settings for component waves (functions)
 * 
 */

public class SettingsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel amplitude, frequency, phase;
	private JTextField amplitudeText, frequencyText, phaseText;
	private JComboBox<String> amplitudeBox, frequencyBox, phaseBox;
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
		amplitudeText.setText(""+panel.getAmplitude());
		this.add(amplitudeText);
		
		String[] amplitudeUnits = {"Pa","hPa"};
		amplitudeBox = new JComboBox<String>(amplitudeUnits);
		this.add(amplitudeBox);
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(e->panel.doEditChartProperties());
		this.add(settingsButton, "gap 10, wrap 10:30");
		settingsButton.setToolTipText("Advanced graph settings");
		
		frequency = new JLabel("f");
		this.add(frequency);
		frequency.setToolTipText("Frequency");
		
		frequencyText = new JTextField(5);
		frequencyText.setText(""+panel.getFrequency());
		this.add(frequencyText);
		
		String[] frequencyUnits = {"Hz","kHz"};
		frequencyBox = new JComboBox<String>(frequencyUnits);
		this.add(frequencyBox);
		
		colorButton = new JButton();
		colorButton.setBackground(panel.getStroke());
		colorButton.addActionListener(e->setColor());
		this.add(colorButton, "gap 10, h 30, wrap 10:30");
		colorButton.setToolTipText("Change graph color");
		
		phase = new JLabel("φ");
		this.add(phase);
		phase.setToolTipText("phase");
		
		phaseText = new JTextField(5);
		phaseText.setText(""+panel.getPhase());
		this.add(phaseText);
		
		String[] phaseUnits = {"degree","radians"};
		phaseBox = new JComboBox<String>(phaseUnits);
		this.add(phaseBox);
		
		applyButton = new JButton("Apply");
		applyButton.addActionListener(e->apply());
		this.add(applyButton, "gap 10, wrap");
		applyButton.setToolTipText("Apply changes");
		
	}
	private void apply() {
		try {
			if (amplitudeBox.getSelectedIndex()==0)
				panel.setAmplitude(Double.parseDouble(amplitudeText.getText()));
			if (amplitudeBox.getSelectedIndex()==1)
				panel.setAmplitude(100*Double.parseDouble(amplitudeText.getText()));
		} catch (NumberFormatException e) {
			amplitudeText.setText(panel.getAmplitude()+"");
		}
		try {
			if (frequencyBox.getSelectedIndex()==0)
				panel.setFrequency(Double.parseDouble(frequencyText.getText()));
			if (frequencyBox.getSelectedIndex()==1)
				panel.setFrequency(1000*Double.parseDouble(frequencyText.getText()));
		} catch (NumberFormatException e) {
			frequencyText.setText(panel.getFrequency()+"");
		}
		try {
			if (phaseBox.getSelectedIndex()==0)
				panel.setPhase(Math.PI/180*Double.parseDouble(phaseText.getText()));
			if (phaseBox.getSelectedIndex()==1)
				panel.setPhase(Double.parseDouble(phaseText.getText()));
		} catch (NumberFormatException e) {
			phaseText.setText(panel.getPhase()+"");
		}
		panel.setChart(panel.makeChart(panel.calculateSeries()));
	}
	
	public void updateBoxes() {
		amplitudeText.setText(panel.getAmplitude()+"");
		frequencyText.setText(panel.getFrequency()+"");
		phaseText.setText(panel.getPhase()+"");
	}
	
	public void setColor() {
		Color color = JColorChooser.showDialog(this, "Choose a color", panel.getStroke());
		panel.setStroke(color);
		colorButton.setBackground(color);
	}
	public String getData() {
		return panel.getAmplitude()+"\t"+panel.getFrequency()+"\t"+panel.getPhase();
	}

}
