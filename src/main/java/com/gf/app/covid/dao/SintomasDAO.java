/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.dao;

import com.gf.app.covid.models.Sintomas;
import com.gf.app.covid.utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author ruth
 */
public class SintomasDAO {

    public static int insert(Sintomas s) throws SQLException {

        String sql = "INSERT INTO sintomas VALUES (?,?,?,?,?,?)";
        try ( Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setInt(2, s.getFiebre());
            ps.setInt(3, s.getTos());
            ps.setInt(4, s.getDiarrea());
            ps.setInt(5, s.getDolor());
            ps.setInt(6, s.getOlfato());
            return ps.executeUpdate();

        }
    }

    public static int update(Sintomas s) throws SQLException {

        String sql = "UPDATE sintomas SET fiebre=?, tos=?, diarrea=?, dolor=?, olfato=? WHERE id=?";
        try ( Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, s.getFiebre());
            ps.setInt(2, s.getTos());
            ps.setInt(3, s.getDiarrea());
            ps.setInt(4, s.getDolor());
            ps.setInt(5, s.getOlfato());
            ps.setInt(6, s.getId());
            return ps.executeUpdate();

        }
    }

    public static boolean selectId(Sintomas s) throws SQLException {
        String sql = "SELECT * FROM sintomas WHERE id=?";
        boolean exist = false;
        try ( Connection conn = ConexionBD.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }

        }
        return exist;

    }

    public static Set<Sintomas> select(Sintomas s) throws SQLException {
        String sql = "SELECT * FROM sintomas";
        Set<Sintomas> list;
        try ( Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            list = (Set<Sintomas>) ps.executeQuery();
        }
        return list;

    }

    public static int delete(Sintomas s) throws SQLException {
        String sql = "DELETE FROM sintomas WHERE id=?";
        try ( Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            return ps.executeUpdate();

        }

    }

}
