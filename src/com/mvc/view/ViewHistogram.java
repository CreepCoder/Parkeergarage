package com.mvc.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import com.mvc.model.Model;


public class ViewHistogram extends AbstractView {
    public ViewHistogram(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
    }
    public void Histogram() {
		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
       
        xAxis.setLabel("voertuig");       
        yAxis.setLabel("Hoeveelheid");
 
        XYChart.Series series1 = new XYChart.Series();
     
        series1.getData().add(new XYChart.Data("aids ding", 111));
        series1.getData().add(new XYChart.Data("rip", 112));
      
       
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
    }

	final static String caradhoc = "CARADHOC";
    final static String carparkingpass = "CARPARKINGPASS";

}