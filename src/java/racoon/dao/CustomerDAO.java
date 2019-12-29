/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import racoon.database.myConnection;
import racoon.dto.CustomerDTO;

/**
 *
 * @author Administrator
 */
public class CustomerDAO {

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
    
    public int getLV(String customerID) throws ClassNotFoundException, SQLException{
        int i = 0;
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Select LvL From CustomerAc Where CustomerID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, customerID);
            rs = ptm.executeQuery();
            if(rs.next()){
                i = rs.getInt("LvL");
            }
        } finally {
            closeConnection();
        }
        
        return i;
    }
    
    public boolean insert(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert Into CustomerAc values(?,?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setString(2, dto.getFullname());
            ptm.setString(3, dto.getAddress());
            ptm.setInt(4, dto.getOrderID());
            ptm.setString(5, dto.getUsername());
            ptm.setInt(6, dto.getLvl());
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
            String sql = "Delete From CustomerAc Where CustomerID = ?";
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
            String sql = "Select CustomerID From CustomerAc Where RoomID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            if (rs.next()) {
                dto = rs.getString("CustomerID");
            }
        } finally {
            closeConnection();
        }

        return dto;
    }
}
