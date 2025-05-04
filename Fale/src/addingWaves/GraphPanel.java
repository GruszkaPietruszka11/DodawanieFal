package addingWaves;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**Panel drawing a graph
 * Most of the functionality not implemented yet
 */

public class GraphPanel extends ChartPanel {

	private static final long serialVersionUID = 1L;
	int numberOfPoints=100;
	double freq=10, amp=10, phase=0;
	
	JFreeChart chart;
	public GraphPanel() {
		super(ChartFactory.createXYLineChart("", "", "", null));
		this.setBackground(Color.WHITE);
		calculateGraph();
		setChart(chart);
	}
	
	public void calculateGraph() {
		XYSeries series = new XYSeries("");
		for (double ii=0; ii<3/freq;ii+=3/freq/numberOfPoints) {
			series.add(ii, amp*Math.sin(2*3.14*freq*ii+phase));
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		chart = ChartFactory.createXYLineChart("","t[s]","x[Pa]",dataset, PlotOrientation.VERTICAL, false,false,false);
	}
}
