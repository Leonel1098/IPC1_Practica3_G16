package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuGraficas extends JFrame{
    ImageIcon IBarrasN, IBarrasE, IPieG;
    JLabel lblBarrasN, lblBarrasE, lblPie, lblTN, lblTE, lblPG;

    public MenuGraficas(){
        IPieG = new ImageIcon("./src/logos/PieG.png");
        IBarrasE = new ImageIcon("./src/logos/BarraE.png");
        IBarrasN = new ImageIcon("./src/logos/BarraN.png");

        lblPie = new JLabel(IPieG);
        lblPie.setBounds(50, 50, 200, 200);
        lblPie.setVisible(true);
        this.add(lblPie);
        lblPie.addMouseListener(new MouseAdapter() {

            //Funcion del JLabel
            @Override
            public void mouseClicked(MouseEvent e) {
                GraficaGenero nuevo = new GraficaGenero();
                MenuGraficas.this.dispose();
            }
        });

        lblBarrasE = new JLabel(IBarrasE);
        lblBarrasE.setBounds(300, 50, 200, 200);
        lblBarrasE.setVisible(true);
        this.add(lblBarrasE);
        lblBarrasE.addMouseListener(new MouseAdapter() {

            //Funcion del JLabel
            @Override
            public void mouseClicked(MouseEvent e) {
                GraficaEdad nuevo = new GraficaEdad();
                MenuGraficas.this.dispose();
            }
        });

        lblBarrasN = new JLabel(IBarrasN);
        lblBarrasN.setBounds(550, 50, 200, 200);
        lblBarrasN.setVisible(true);
        this.add(lblBarrasN);
        lblBarrasN.addMouseListener(new MouseAdapter() {

            //Funcion del Label
            @Override
            public void mouseClicked(MouseEvent e) {
//                AdminAlumnos nuevo = new AdminAlumnos();
//                MenuAdmin.this.dispose();
            }
        });

        //JLabel Titulos
        lblPG = new JLabel("Gráfica Genero");
        lblPG.setBounds(75, 240, 145, 75);
        lblPG.setForeground(Color.white);
        lblPG.setFont(new Font("arial", Font.BOLD, 20));
        lblPG.setVisible(true);
        this.add(lblPG);

        lblTE = new JLabel("Gráfica Edad");
        lblTE.setBounds(338, 240, 145, 75);
        lblTE.setForeground(Color.white);
        lblTE.setFont(new Font("arial", Font.BOLD, 20));
        lblTE.setVisible(true);
        this.add(lblTE);

        lblTN = new JLabel("Gráfica Notas");
        lblTN.setBounds(585, 240, 140, 75);
        lblTN.setForeground(Color.white);
        lblTN.setFont(new Font("arial", Font.BOLD, 20));
        lblTN.setVisible(true);
        this.add(lblTN);

        //JFrame
        this.setTitle("Graficas");
        this.setSize(825, 390);
        this.getContentPane().setBackground(Color.orange);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
