package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Carga extends JFrame implements ActionListener {
    JLabel lbl1;
    JTextField txtcarga;
    JButton btncarga;

    public Carga(){
        txtcarga = new JTextField();
        txtcarga.setBounds(20, 100, 400, 30);
        txtcarga.setVisible(true);
        this.add(txtcarga);

        lbl1 = new JLabel("Ingrese la ruta de la carpeta:");
        lbl1.setFont(new Font("arial", Font.BOLD, 20));
        lbl1.setBounds(85, 20, 300, 50);
        lbl1.setVisible(true);
        this.add(lbl1);

        btncarga = new JButton("Cargar Archivos");
        btncarga.setBounds(140, 170, 160, 30);
        btncarga.setVisible(true);
        this.add(btncarga);
        //Acción del Boton
        btncarga.addActionListener(this);

        this.setTitle("Menú");
        this.getContentPane().setBackground(Color.orange);
        this.setLayout(null);
        this.setSize(455, 290);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btncarga){
            String ruta = txtcarga.getText();
            try {
                Main.CargarCursos(ruta);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                Main.CargarAlumnos(ruta);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            Main.mostrarCursos();
            Main.mostrarAlumno();

        }
    }
}
