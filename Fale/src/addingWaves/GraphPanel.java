package addingWaves;

import java.awt.Color;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**Panel for calculating and displaying a graph using JFreeChart library
 * Allows to change graph colors, data and points density (number of points) 
 */

public class GraphPanel extends ChartPanel {

	private static final long serialVersionUID = 1L;
	private static int numberOfPoints=100;
	private double freq=3, amp=10, phase=0;
	
	public void setNOP(int nop) {numberOfPoints=nop;}
	public void setFrequency(double f) {freq=f;}
	public void setAmplitude(double A) {amp=A;}
	public void setPhase(double ph) {phase=ph;}
	public static int getNOP() {return numberOfPoints;}
	public double getFrequency() {return freq;}
	public double getAmplitude() {return amp;}
	public double getPhase() {return phase;}
	
	private JFreeChart chart=ChartFactory.createXYLineChart("", "", "", null);
	private Color backColor=Color.white, plotColor=Color.white, gridColor=Color.gray, strokeColor=Color.blue;
	
	public void setBack(Color c) {backColor=c;}
	public void setPlot(Color c) {plotColor=c;}
	public void setGrid(Color c) {gridColor=c;}
	public void setStroke(Color c) {strokeColor=c;}
	
	private XYSeriesCollection dataset = new XYSeriesCollection();
	public XYSeriesCollection getDataset() {return dataset;};
	
	public GraphPanel() {
		super(ChartFactory.createXYLineChart("", "", "", null));
		chart.setBackgroundPaint(backColor);
		setChart(chart);
		setColors();
	}
	
	public JFreeChart makeChart(XYSeries[] series) {
		for(XYSeries s : series)	dataset.addSeries(s);
		chart = ChartFactory.createXYLineChart("","t[s]","x[Pa]",dataset, PlotOrientation.VERTICAL, false,false,false);
		setColors();
		return chart;
	}
	
	public JFreeChart makeChart(XYSeriesCollection dataset) {
		chart = ChartFactory.createXYLineChart("","t[s]","x[Pa]",dataset, PlotOrientation.VERTICAL, false,false,false);
		setColors();
		return chart;
	}
	
	public XYSeriesCollection calculateSeries() {
		XYSeries series = new XYSeries(""+Math.random());
		for (int ii=0; ii<numberOfPoints+1; ii++) {
			double t=ii*3/freq/numberOfPoints;
			series.add(t, amp*Math.sin(2*3.14*freq*t+phase));
		}
		dataset.addSeries(series);
		return dataset;
	}
	
	private void setColors() {
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(plotColor);
		plot.setDomainGridlinePaint(gridColor);
		plot.setRangeGridlinePaint(gridColor);
		plot.getRenderer().setSeriesPaint(0,strokeColor);
	}
}
