package com.company;

import javax.swing.*;
import java.awt.*;

public class Datos extends JFrame {
    JLabel Metodo, Velocidad, Pasos, Orden, Cronometro;

   public Datos(String Met, String Vel, String Pa, String Ord) {

       Metodo = new JLabel(Met);
       Metodo.setBounds(30, 30,200,30);
       Metodo.setFont(new Font("arial", Font.BOLD, 15));
       Metodo.setVisible(true);
       this.add(Metodo);

       Orden = new JLabel(Ord);
       Orden.setBounds(30, 60,200,30);
       Orden.setFont(new Font("arial", Font.BOLD, 15));
       Orden.setVisible(true);
       this.add(Orden);

       Velocidad = new JLabel(Vel);
       Velocidad.setBounds(30, 90,200,30);
       Velocidad.setFont(new Font("arial", Font.BOLD, 15));
       Velocidad.setVisible(true);
       this.add(Velocidad);

       Pasos = new JLabel(Pa);
       Pasos.setBounds(30, 120,200,30);
       Pasos.setFont(new Font("arial", Font.BOLD, 15));
       Pasos.setVisible(true);
       this.add(Pasos);

       this.setTitle("Datos de Gráfica");
       this.getContentPane().setBackground(Color.orange);
       this.setLayout(null);
       this.setSize(200, 210);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
       //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
