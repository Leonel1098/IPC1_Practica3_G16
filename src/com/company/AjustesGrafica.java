package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AjustesGrafica extends JFrame implements ActionListener {
    JComboBox Metodo, Velocidad, ID;
    JButton Graficar;
    JLabel txtCurso, txtOrden, txtVelocidad, lblvolver;
    ImageIcon volver;

    AjustesGrafica(){

        volver = new ImageIcon("./src/logos/volver.png");

        lblvolver = new JLabel(volver);
        lblvolver.setBounds(430, 400, 30, 30);
        lblvolver.setVisible(true);
        this.add(lblvolver);
        lblvolver.addMouseListener(new MouseAdapter() {

            //Funcion del JLabel
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuGraficas nuevo = new MenuGraficas();
                AjustesGrafica.this.dispose();
            }
        });

        txtCurso = new JLabel("Elija el ID del Curso:");
        txtCurso.setBounds(30, 50,180,30);
        txtCurso.setFont(new Font("arial", Font.BOLD, 15));
        txtCurso.setVisible(true);
        this.add(txtCurso);

        ID = new JComboBox();
        ID.setBounds(230, 50, 200, 30);
        ID.setVisible(true);
        for (int i = 0; i < Main.contadorCursos; i++) {
            if (Main.curso[i] != null) {
                ID.addItem(Main.curso[i].getId());
            }
        }
        this.add(ID);

        txtOrden = new JLabel("Metodo de Ordenamiento: ");
        txtOrden.setBounds(30, 120,200,30);
        txtOrden.setFont(new Font("arial", Font.BOLD, 15));
        txtOrden.setVisible(true);
        this.add(txtOrden);

        Metodo = new JComboBox();
        Metodo.setBounds(230, 120, 200, 30);
        Metodo.setVisible(true);
        this.add(Metodo);

        Metodo.addItem("BubbleSort Ascendente");
        Metodo.addItem("BubbleSort Descendente");
        Metodo.addItem("QuickSort Ascendente");
        Metodo.addItem("QuickSort Descendente");


        txtVelocidad = new JLabel("Velocidad: ");
        txtVelocidad.setBounds(170, 200,200,30);
        txtVelocidad.setFont(new Font("arial", Font.BOLD, 25));
        txtVelocidad.setVisible(true);
        this.add(txtVelocidad);

        Velocidad = new JComboBox();
        Velocidad.setBounds(135, 275, 200, 30);
        Velocidad.setVisible(true);
        this.add(Velocidad);

        Velocidad.addItem("Lenta");
        Velocidad.addItem("Media");
        Velocidad.addItem("Rápida");

        Graficar = new JButton("Graficar");
        Graficar.setBounds(163, 350, 140, 40);
        Graficar.setVisible(true);
        this.add(Graficar);
        Graficar.addActionListener(this);

        this.setTitle("Ajustes de Gráfica");
        this.getContentPane().setBackground(Color.orange);
        this.setLayout(null);
        this.setSize(480, 480);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Graficar) {
            if(Metodo.getSelectedItem().equals("BubbleSort Ascendente")){
                BsortAclass BA = new BsortAclass(Main.notas);
                BA.start();
            } else if(Metodo.getSelectedItem().equals("BubbleSort Descendentes")){
                BsortDclass BD = new BsortDclass(Main.notas);
                BD.start();
            }

//            if(Metodo.getSelectedItem().equals("QuickSort Ascendente")){
//
//            }
        }
    }
}
