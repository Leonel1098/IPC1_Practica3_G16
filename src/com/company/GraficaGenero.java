package com.company;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;


public class GraficaGenero extends JFrame implements ActionListener {

    public static JFreeChart chart;

    int f;
    int m;
    public static DefaultPieDataset data;
    public static ChartPanel cp;
    public static JTextField txtID;
    public static JButton graficar;
    public static JFrame Grafica;

    public GraficaGenero() {
        f=0;
        m=0;
        Grafica = new JFrame("Grafica Sexos ");
        txtID = new JTextField("Ingrese Id Curso");
        txtID.setBounds(25, 450, 200, 50);
        txtID.setVisible(true);
        txtID.setEnabled(true);
        Grafica.add(txtID);


        graficar = new JButton("GRFICAR GENERO");
        graficar.setName("Graficar");
        graficar.setBounds(250, 450, 150, 75);
        graficar.setVisible(true);
        graficar.addActionListener(this);
        Grafica.add(graficar);
        data = new DefaultPieDataset();
        data.setValue("Masculino", m);
        data.setValue("Femenino ", f);
        chart = ChartFactory.createPieChart(
                "Género de Alumnos ",
                data,
                true,
                false,
                true);
        //Meter La grafica en un Panel
        cp = new ChartPanel(chart);
        cp.setLayout(new java.awt.BorderLayout(6500, 6500));
        cp.setBounds(850, 180, 600, 500);
        cp.setVisible(true);
        cp.validate();
        Grafica.add(cp);
        Grafica.pack();
        Grafica.setLocationRelativeTo(null);
        Grafica.setVisible(true);
        Grafica.setLayout(null);
        Grafica.setSize(1000, 1000);
        Grafica.setLocationRelativeTo(null);
        Grafica.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == graficar) {
            try{
                int idCurso=Integer.parseInt(txtID.getText());
                Graficando g = new Graficando(idCurso);
                g.start();
            }catch (Exception p){
                JOptionPane.showMessageDialog(null,"Error al Ingresar Codigo de " +
                        "Curso");
            }


        }
    }
}
