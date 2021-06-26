package com.company;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
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
    public JLabel Texto;

    public GraficaGenero() {
        f=0;
        m=0;
        Grafica = new JFrame("Grafica Sexos ");
        txtID = new JTextField();
        txtID.setBounds(400, 800, 150, 50);
        txtID.setVisible(true);
        txtID.setEnabled(true);
        Grafica.add(txtID);

        Texto = new JLabel("Ingrese el ID del curso: ");
        Texto.setBounds(250, 800, 150, 50);
        Texto.setVisible(true);
        Grafica.add(Texto);


        graficar = new JButton("GRAFICAR GENERO");
        graficar.setName("Graficar");
        graficar.setBounds(580, 800, 150, 50);
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
                true,
                false);
        //Meter La grafica en un Panel
        cp = new ChartPanel(chart);
        cp.setLayout(new java.awt.BorderLayout(6500, 6500));
        cp.setBounds(850, 180, 600, 500);
        cp.setVisible(true);
        cp.validate();


        Grafica.add(cp);
        Grafica.pack();
        Grafica.getContentPane().setBackground(Color.orange);
        Grafica.setLocationRelativeTo(null);
        Grafica.setVisible(true);
        Grafica.setLayout(null);
        Grafica.setSize(1042, 930);
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
