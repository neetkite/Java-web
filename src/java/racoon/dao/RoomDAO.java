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
import java.util.ArrayList;
import java.util.List;
import racoon.database.myConnection;
import racoon.dto.RoomDTO;

/**
 *
 * @author Administrator
 */
public class RoomDAO implements Serializable {

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

    public List<RoomDTO> loadRoom() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room";
            ptm = conn.prepareStatement(sql);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> loadRoomAvailable() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where Status = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, true);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> loadRoomInUse() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where Status = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, false);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> loadRoomSingle() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where Type = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, false);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> loadRoomDuo() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where Type = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, true);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> findByNumber(int id) throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            if (rs.next()) {

                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public RoomDTO findByNumberObject(int id) throws SQLException, ClassNotFoundException {

        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber,Type,Status,Description,Price,Image From tbl_Room Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);

            rs = ptm.executeQuery();
            if (rs.next()) {

                boolean type = rs.getBoolean("Type");
                boolean stat = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(id, type, stat, des, price, img);

            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public boolean update(RoomDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Update tbl_Room set Type = ?, Status = ?, Description = ?, Price = ?, Image = ? Where RoonNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, dto.isType());
            ptm.setBoolean(2, dto.isStatus());
            ptm.setString(3, dto.getDes());
            ptm.setFloat(4, dto.getPrice());
            ptm.setString(5, dto.getImg());
            ptm.setInt(6, dto.getId());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Delete From tbl_Room Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean updateStatus(RoomDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Update tbl_Room set Status = ? Where RoonNumber = ?";
            ptm = conn.prepareStatement(sql);

            ptm.setBoolean(1, dto.isStatus());
            ptm.setInt(2, dto.getId());

            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public RoomDTO findByAvailable(int id) throws SQLException, ClassNotFoundException {

        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomNumber, Type, Status, Description, Price, Image From tbl_Room Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);

            rs = ptm.executeQuery();
            if (rs.next()) {
                int number = id;
                boolean type = rs.getBoolean("Type");
                boolean status = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(number, type, status, des, price, img);
            }

        } finally {
            closeConnection();
        }

        return dto;
    }
    
    public boolean insert(boolean type, boolean status, String des, float price, String img) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into tbl_Room values (?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            
            ptm.setBoolean(1, type);
            ptm.setBoolean(2, status);
            ptm.setString(3, des);
            ptm.setFloat(4, price);
            ptm.setString(5, img);
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
    
}
