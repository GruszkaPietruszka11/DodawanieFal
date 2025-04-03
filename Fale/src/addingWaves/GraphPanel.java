package addingWaves;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**Panel drawing a graph
 * Most of the functionality not implemented yet
 */

public class GraphPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public GraphPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(new JLabel("*formula*"), BorderLayout.SOUTH);
	}

}
