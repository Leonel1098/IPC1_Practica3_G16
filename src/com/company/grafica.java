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
    static public JLabel time;
    public grafica()
{
    setSize(900,900);
    //setLocation(500,100);
    setLocationRelativeTo(null);
    //setDefaultCloseOperation(3);
    setTitle("ORDENAMIENTOS");

    time = new JLabel();
    time.setBounds(5, 5, 100,30);
    time.setVisible(true);
    this.add(time);

    JPanel panel = new JPanel();
    this.getContentPane().add(panel);
    JFreeChart GB = ChartFactory.createBarChart("CALIFICACIONES", "ESTUDIANTES","CALIFICACION", datos, PlotOrientation.VERTICAL,true,true,false);
    ChartPanel pa = new ChartPanel(GB);
    pa.setMouseWheelEnabled(true);
    pa.setPreferredSize(new Dimension(500,500));
    panel.setLayout(new BorderLayout());
    panel.add(pa,BorderLayout.NORTH);
   // pack();
  //  repaint();



}


 /*   @Override
    public void run() {


    }*/
}

 