package hgm.gov.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.pie.PieChartDataSet;

import lombok.Data;

@Named
@ManagedBean
@SessionScoped
@Data
public class ChartBar {
	private BarChartModel barModel;

	public ChartBar() {
		barModel = new BarChartModel();
		ChartData data = new ChartData();
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Servis Yolcu Sayýlarý");

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(12);
		values.add(50);
		values.add(6);
		values.add(1);
		barDataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(54, 162, 235)");
		bgColors.add("rgb(255, 205, 86)");
		bgColors.add("rgb(255, 0, 0)");
		barDataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Eryaman");
		labels.add("Kýzýlay");
		labels.add("Dikmen");
		labels.add("Çinçin");
		data.setLabels(labels);

		data.addChartDataSet(barDataSet);
		barModel.setData(data);

		BarChartOptions options = new BarChartOptions();

		Legend legend = new Legend();
		legend.setDisplay(false);

		options.setLegend(legend);
		barModel.setOptions(options);
	}

}
