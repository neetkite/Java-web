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
import racoon.dto.FoodingDTO;

/**
 *
 * @author Administrator
 */
public class FoodingDAO implements Serializable {

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

    public List<FoodingDTO> loadAllFooding() throws ClassNotFoundException, SQLException {
        List<FoodingDTO> list = null;
        FoodingDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select FoodingID, Name, Price, Quantity, Description, Type, Image  From Fooding";
            ptm = conn.prepareStatement(sql);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("FoodingID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int quanti = rs.getInt("Quantity");
                String des = rs.getString("Description");
                boolean type = rs.getBoolean("Type");
                String img = rs.getString("Image");
                dto = new FoodingDTO(id, name, price, quanti, des, type, img);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }

        return list;
    }

    public List<FoodingDTO> loadDrink() throws SQLException, ClassNotFoundException {
        List<FoodingDTO> list = null;
        FoodingDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select FoodingID, Name, Price, Quantity, Description, Type, Image From Fooding Where Type = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, false);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("FoodingID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int quanti = rs.getInt("Quantity");
                String des = rs.getString("Description");
                boolean type = rs.getBoolean("Type");
                String img = rs.getString("Image");
                dto = new FoodingDTO(id, name, price, quanti, des, type, img);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }

        return list;
    }

    public List<FoodingDTO> loadFood() throws SQLException, ClassNotFoundException {
        List<FoodingDTO> list = null;
        FoodingDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select FoodingID, Name, Price, Quantity, Description, Type, Image From Fooding Where Type = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, true);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("FoodingID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int quanti = rs.getInt("Quantity");
                String des = rs.getString("Description");
                boolean type = rs.getBoolean("Type");
                String img = rs.getString("Image");
                dto = new FoodingDTO(id, name, price, quanti, des, type, img);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }

        return list;
    }

    public List<FoodingDTO> searchFooding(String search) throws SQLException, ClassNotFoundException {

        List<FoodingDTO> list = null;
        FoodingDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select FoodingID, Name, Price, Quantity, Description, Type, Image From Fooding Where FoodingID = ? OR Name LIKE ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            ptm.setString(2, "%" + search + "%");
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("FoodingID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                String des = rs.getString("Description");
                boolean type = rs.getBoolean("Type");
                String img = rs.getString("Image");
                dto = new FoodingDTO(id, name, price, quantity, des, type, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        System.out.println(list);
        return list;
    }

    public boolean insertFooding(FoodingDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into Fooding values(?,?,?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setString(2, dto.getName());
            ptm.setFloat(3, dto.getPrice());
            ptm.setInt(4, dto.getQuantity());
            ptm.setString(5, dto.getDes());
            ptm.setBoolean(6, dto.isType());
            ptm.setString(7, dto.getImg());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean updateFooding(FoodingDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Update Fooding set Name = ?, Price = ?, Quantity = ?, Description = ?, Type = ?, Image = ? Where FoodingID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getName());
            ptm.setFloat(2, dto.getPrice());
            ptm.setInt(3, dto.getQuantity());
            ptm.setString(4, dto.getDes());
            ptm.setBoolean(5, dto.isType());
            ptm.setString(6, dto.getImg());
            ptm.setString(7, dto.getId());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Delete From Fooding Where FoodingID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, id);
            check = ptm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }

        return check;
    }

    public FoodingDTO FindByPK(String search) throws SQLException, ClassNotFoundException {
        FoodingDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select FoodingID, Name, Price, Quantity, Description, Type, Image From Fooding Where FoodingID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String id = search;
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                String des = rs.getString("Description");
                boolean type = rs.getBoolean("Type");
                String image = rs.getString("Image");
                dto = new FoodingDTO(id, name, price, quantity, des, type, image);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public boolean checkExisted(String name) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            
            conn = myConnection.getMyConnection();
            String sql = "Select Name,Price,Quantity From Fooding Where Name = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, name);
            rs = ptm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
}
