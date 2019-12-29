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
import racoon.dto.CartDTO;

/**
 *
 * @author Administrator
 */
public class CartDAO implements Serializable {

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
    
   public boolean insertCart(CartDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into Cart values(?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setString(2, dto.getFoodID());
            ptm.setString(3, dto.getServiceID());
            ptm.setFloat(4, dto.getTotal());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
   
   public CartDTO FindByPK(String id) throws SQLException, ClassNotFoundException{
       CartDTO dto = null;
       
       try {
           conn = myConnection.getMyConnection();
           String sql = "Select CartID, CartFoodingID, CartServiceID,Total From Cart Where CartID = ?";
           ptm = conn.prepareStatement(sql);
           ptm.setString(1, id);
           rs = ptm.executeQuery();
           if(rs.next()){
               
               String fd = rs.getString("CartFoodingID");
               String sd = rs.getString("CartServiceID");
               float total = rs.getFloat("Total");
               dto = new CartDTO(id, fd, sd, total);
           }
       } finally {
           closeConnection();
       }
       return dto;
   }
   
  
   

}
