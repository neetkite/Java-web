/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import racoon.database.myConnection;
import racoon.dto.OrderDTO;

/**
 *
 * @author Administrator
 */
public class OderDAO implements Serializable {

    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;

    public void closeConnection() throws SQLException {

        if (conn != null) {
            conn.close();
        }
        if (ptm != null) {
            ptm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public boolean insert(OrderDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert Into tbl_Order values(?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setInt(2, dto.getRoomID());
            ptm.setFloat(3, dto.getDiscount());
            ptm.setFloat(4, dto.getTotal());
            ptm.setString(5, dto.getDate());

            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {

            conn = myConnection.getMyConnection();
            String sql = "Delete From tbl_Order Where OrderID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, id);
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public String findByRoombill(int id) throws SQLException, ClassNotFoundException {
        String dto = "";

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select OrderID  From tbl_Order Where RoomID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            if (rs.next()) {
                dto = rs.getString("OrderID");
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

}
