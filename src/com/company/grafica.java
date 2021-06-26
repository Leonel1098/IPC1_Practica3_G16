package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;


public class grafica extends JFrame {
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    public grafica()
{
    setSize(700,700);
    //setLocation(500,100);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(3);
    setTitle("ORDENAMIENTOS");

    JPanel panel = new JPanel();
    this.getContentPane().add(panel);
    JFreeChart GB = ChartFactory.createBarChart3D("CALIICACIONES", "ESTUDIANTES","CALIFICACION",
            datos, PlotOrientation.VERTICAL,true,true,false);
    ChartPanel pa = new ChartPanel(GB);
    pa.setMouseWheelEnabled(true);
    pa.setPreferredSize(new Dimension(400,400));
    panel.setLayout(new BorderLayout());
    panel.add(pa,BorderLayout.NORTH);
   // pack();
  //  repaint();



}


 /*   @Override
    public void run() {


    }*/
}

 