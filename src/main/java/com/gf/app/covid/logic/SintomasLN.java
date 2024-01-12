/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.logic;

import com.gf.app.covid.dao.SintomasDAO;
import com.gf.app.covid.models.Sintomas;
import java.sql.SQLException;

/**
 *
 * @author ruth
 */
public class SintomasLN {

    public static String insertar(Sintomas s) throws SQLException {

        if (!SintomasDAO.selectId(s)) {
            //if (SintomasDAO.insert(s)>0)
            SintomasDAO.insert(s);
            return "Los resultados del test se han guardado correctamente.";
        } else {
            return "El test ya existe.";
        }

    }

    public static String delete(Sintomas s) throws SQLException {

        if (SintomasDAO.selectId(s)) {
            //if (SintomasDAO.delete(s)>0)
            SintomasDAO.delete(s);
            return "Los resultados del test se han elimnado correctamente.";
        } else {
            return "El test  no ya existe.";
        }

    }

    public static String update(Sintomas s) throws SQLException {

        if (SintomasDAO.selectId(s)) {
            //if (SintomasDAO.update(s)>0)
            SintomasDAO.update(s);
            return "Los resultados del test se han actualizado correctamente.";
        } else {
            return "El test no ya existe.";
        }

    }

}
