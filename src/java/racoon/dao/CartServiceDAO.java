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
import racoon.dto.CartServiceDTO;

/**
 *
 * @author Administrator
 */
public class CartServiceDAO implements Serializable {

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

    public boolean insertCartService(CartServiceDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into CartService values(?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, dto.getId());
            ptm.setFloat(2, dto.getPrice());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
}
