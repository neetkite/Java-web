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
import racoon.dto.ServiceDTO;
import java.util.List;
import racoon.database.myConnection;

/**
 *
 * @author Administrator
 */
public class ServiceDAO implements Serializable {

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

    public List<ServiceDTO> loadService() throws SQLException, ClassNotFoundException {
        List<ServiceDTO> list = null;
        ServiceDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select ServiceID,Name,Price,Description,Image From Service";
            ptm = conn.prepareStatement(sql);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ServiceID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String des = rs.getString("Description");
                String img = rs.getString("Image");
                dto = new ServiceDTO(id, name, price, des, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<ServiceDTO> findByName(String search) throws SQLException, ClassNotFoundException {

        List<ServiceDTO> list = null;
        ServiceDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select ServiceID,Name,Price,Description,Image From Service Where Name LIKE ? OR ServiceID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "%" + search + "%");
            ptm.setString(2, search);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ServiceID");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String des = rs.getString("Description");
                String img = rs.getString("Image");
                dto = new ServiceDTO(id, name, price, des, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean insert(ServiceDTO dto) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into Service values(?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setString(2, dto.getName());
            ptm.setFloat(3, dto.getPrice());
            ptm.setString(4, dto.getDes());
            ptm.setString(5, dto.getImg());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
    
    
     public boolean update(ServiceDTO dto) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Update Service set Name = ?, Price = ?, Description = ?, Image = ? Where ServiceID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getName());
            ptm.setFloat(2, dto.getPrice());
            ptm.setString(3, dto.getDes());
            ptm.setString(4, dto.getImg());
            ptm.setString(5, dto.getId());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
     
     
     public boolean delete(String id) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Delete From Service Where ServiceID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, id);
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
     
     public ServiceDTO findByPK(String id) throws SQLException, ClassNotFoundException{
         ServiceDTO dto = null;
         
         try{
             conn = myConnection.getMyConnection();
             String sql = "Select ServiceID, Name, Price, Description, Image From Service Where ServiceID = ?";
             ptm = conn.prepareStatement(sql);
             ptm.setString(1, id);
             rs = ptm.executeQuery();
             if(rs.next()){
                 String sid = id;
                 String name = rs.getString("Name");
                 float price = rs.getFloat("Price");
                 String des = rs.getString("Description");
                 String img = rs.getString("Image");
                 dto = new ServiceDTO(sid, name, price, des, img);
             }
         }finally{
             closeConnection();
         }
         
         return dto;
     }
}
