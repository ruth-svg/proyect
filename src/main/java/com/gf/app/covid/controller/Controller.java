/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.controller;

import com.gf.app.covid.logic.SintomasLN;
import com.gf.app.covid.models.Sintomas;
import com.gf.app.covid.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ruth
 */
public class Controller implements ActionListener {

    private final Sintomas modelo;
    private final View vista;

    public Controller(Sintomas modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getEnviar().addActionListener(this);
    }

    public void iniciarVista() {

        vista.setTitle("TEST COVID GF");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        modelo.setId(vista.getCurso());
        if (vista.getFiebre().isSelected()) {
            modelo.setFiebre(1);
        }
        if (vista.getTos().isSelected()) {
            modelo.setTos(1);
        }
        if (vista.getDiarrea().isSelected()) {
            modelo.setDiarrea(1);
        }
        if (vista.getDolor().isSelected()) {
            modelo.setDolor(1);
        }
        if (vista.getOlfato().isSelected()) {
            modelo.setOlfato(1);
        }

        if (e.getSource() == vista.getEnviar()) {
            insertarSintoma();

        }

    }

    public void insertarSintoma() {

        try {
            //Llamada a LN
            String mensaje = SintomasLN.insertar(modelo);
            JOptionPane.showMessageDialog(null, mensaje + "\n");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
