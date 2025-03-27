package DodawanieFal;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public GraphPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(new JLabel("*wzór funkcji*"), BorderLayout.SOUTH);
	}

}
