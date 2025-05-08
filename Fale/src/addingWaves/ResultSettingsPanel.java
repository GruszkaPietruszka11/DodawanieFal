package addingWaves;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**Panel for changing graph settings for result wave (function)
 * Most of the functionality not implemented yet
 */

public class ResultSettingsPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JCheckBox result, function1, function2;
	private JButton settingsButton, colorButton, playButton;
	private GraphPanel panel;
	
	public GraphPanel getPanel() {return panel;}
	public ResultSettingsPanel() {
		panel = new GraphPanel();
		panel.setStroke(Color.magenta);
		this.setLayout(new MigLayout("flowy"));
		
		result = new JCheckBox("show result function");
		result.setActionCommand("0");
		result.setSelected(true);
		result.addActionListener(this);
			
		this.add(result, "gapbottom 5:20");
		
		function1 = new JCheckBox("show function 1");
		function1.setActionCommand("1");
		function1.addActionListener(this);
		this.add(function1, "gapbottom 5:20");
		
		function2 = new JCheckBox("show function 2");
		function2.setActionCommand("2");
		function2.addActionListener(this);
		this.add(function2, "gapbottom 5:20");
		
		playButton = new JButton("Play sound");
		this.add(playButton, "wrap");
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(e->panel.doEditChartProperties());
		this.add(settingsButton);
		settingsButton.setToolTipText("Advanced graph settings");
		
		colorButton = new JButton();
		colorButton.setBackground(panel.getStroke());
		colorButton.addActionListener(e->setColor());
		this.add(colorButton, "h 30, wrap 10:30");
		colorButton.setToolTipText("Change graph color");
	}
	
	void setColor() {
		Color color = JColorChooser.showDialog(this, "Choose a color", panel.getStroke());
		panel.setStroke(color);
		colorButton.setBackground(color);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (((JCheckBox)e.getSource()).isSelected())
			panel.getChart().getXYPlot().getRenderer().setSeriesVisible(Integer.parseUnsignedInt(e.getActionCommand()), true);
		else
			panel.getChart().getXYPlot().getRenderer().setSeriesVisible(Integer.parseUnsignedInt(e.getActionCommand()),false);
	}
}