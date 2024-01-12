/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gf.app.covid;

import com.gf.app.covid.controller.Controller;
import com.gf.app.covid.models.Sintomas;
import com.gf.app.covid.view.View;

/**
 *
 * @author ruth
 */
public class AppCovid {

    public static void main(String[] args) {
        
        Sintomas modelo = new Sintomas();
        View vista = new View();
        Controller controlador;
        controlador = new Controller (modelo, vista);
        controlador.iniciarVista();
        
        
        
        
        
        
        
    }
}
