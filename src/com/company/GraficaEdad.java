package com.company;

import javafx.scene.chart.Chart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;

public class GraficaEdad extends JFrame implements ActionListener{

    JFreeChart chart;
    public static int R1,R2,R3,R4,R5,R6,R7,R8,R9,R10;
    public static DefaultCategoryDataset data;
    ChartPanel cp;
    JTextField txtID;
    JButton graficar;
    JLabel Texto;

    public GraficaEdad(){
        R1 = 0;
        R2 = 0;
        R3 = 0;
        R4 = 0;
        R5 = 0;
        R6 = 0;
        R7 = 0;
        R8 = 0;
        R9 = 0;
        R10 = 0;

        txtID = new JTextField();
        txtID.setBounds(400, 800, 150, 50);
        txtID.setVisible(true);
        txtID.setEnabled(true);
        this.add(txtID);

        Texto = new JLabel("Ingrese el ID del curso: ");
        Texto.setBounds(250, 800, 150, 50);
        Texto.setVisible(true);
        this.add(Texto);

        graficar = new JButton("GRAFICAR EDAD");
        graficar.setBounds(580, 800, 150, 50);
        graficar.setVisible(true);
        graficar.addActionListener(this);

        this.add(graficar);
        data = new DefaultCategoryDataset();
        data.setValue(R1,"0-10","");
        data.setValue(R2,"10-20","");
        data.setValue(R3,"20-30","");
        data.setValue(R4,"30-40","");
        data.setValue(R5,"40-50","");
        data.setValue(R6,"50-60","");
        data.setValue(R7,"60-70","");
        data.setValue(R8,"70-80","");
        data.setValue(R9,"80-90","");
        data.setValue(R10,"90-100","");
        chart = ChartFactory.createBarChart(
                "Edad de Alumnos ",
                "",
                "Edad",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        //Meter La grafica en un Panel
        cp = new ChartPanel(chart);
        cp.setLayout(new java.awt.BorderLayout(6500, 6500));
        cp.setBounds(850, 180, 600, 500);
        cp.setVisible(true);
        cp.validate();
        this.add(cp);
        this.pack();

        this.setTitle("Grafica de Edades");
        this.getContentPane().setBackground(Color.orange);
        this.setLayout(null);
        this.setSize(1042, 930);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == graficar) {
            try{
                int idCurso=Integer.parseInt(txtID.getText());
                GraficandoEdad ge = new GraficandoEdad(idCurso);
                ge.start();
            }catch (Exception p){
                JOptionPane.showMessageDialog(null,"Error al Ingresar Codigo de " + "Curso");
            }


        }
    }
}
