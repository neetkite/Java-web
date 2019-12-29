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
import racoon.dto.UserDTO;

/**
 *
 * @author Administrator
 */
public class UserDAO implements Serializable {

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

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String role = "failed";

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Role From tbl_User Where Username = ? and Password = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }

        } finally {
            closeConnection();
        }

        return role;
    }

    public UserDTO findByUser(String search) throws SQLException, ClassNotFoundException {
        UserDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Username, Role, Age, Address, Fullname From tbl_User Where Username = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String role = rs.getString("Role");
                int age = rs.getInt("Age");
                String address = rs.getString("Address");
                String fullname = rs.getString("Fullname");
                dto = new UserDTO(username, role, address, fullname, age);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public List<UserDTO> findByRoleUser() throws SQLException, ClassNotFoundException {
        List<UserDTO> listDto = null;
        UserDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Username,Role,Age,Address,Fullname From tbl_User Where Role = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "user");
            rs = ptm.executeQuery();
            listDto = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("Username");
                String role = rs.getString("Role");
                int age = rs.getInt("Age");
                String add = rs.getString("Address");
                String fullname = rs.getString("Fullname");
                dto = new UserDTO(id, role, add, fullname, age);
                listDto.add(dto);
            }
        } finally {
            closeConnection();
        }
        return listDto;
    }

    public List<UserDTO> findByLikePK(String search) throws SQLException, ClassNotFoundException {
        List<UserDTO> list = null;
        UserDTO dto = null;
        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Username, Role,Age,Address,Fullname From tbl_User Where Username LIKE ? and role = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "%" + search + "%");
            ptm.setString(2, "user");
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Username");
                String role = rs.getString("Role");
                int age = rs.getInt("Age");
                String add = rs.getString("Address");
                String fulln = rs.getString("Fullname");
                dto = new UserDTO(id, role, add, fulln, age);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean delete(String user) throws SQLException, ClassNotFoundException {
        boolean result = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Delete From tbl_User Where Username = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, user);
            result = ptm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }

        return result;
    }

    public UserDTO findByPK(String search) throws SQLException, ClassNotFoundException {
        UserDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Username, Role, Age, Address, Fullname From tbl_User Where Username = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("Username");
                String role = rs.getString("Role");
                int age = rs.getInt("Age");
                String add = rs.getString("Address");
                String fullname = rs.getString("Fullname");
                dto = new UserDTO(id, role, add, fullname, age);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public boolean update(UserDTO dto) throws SQLException, ClassNotFoundException {
        boolean result = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Update tbl_User set Age = ? , Address = ?, Fullname = ? Where Username = ?";
            ptm = conn.prepareStatement(sql);
            
            ptm.setInt(1, dto.getAge());
            ptm.setString(2, dto.getAddress());
            ptm.setString(3, dto.getFullname());
            ptm.setString(4, dto.getUsername());
            result = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    
    public int getLv(String search) throws SQLException, ClassNotFoundException{
        int i = 0;
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Select LvL From tbl_User where Fullname = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            rs = ptm.executeQuery();
            if(rs.next()){
                i = rs.getInt("LvL");
            }
        } finally {
            closeConnection();
        }
        
        return i;
    }
    
    
    public UserDTO findByFullname(String search) throws SQLException, ClassNotFoundException {
        UserDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select Username, Role, Age, Address, Fullname From tbl_User Where Fullname = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, search);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String role = rs.getString("Role");
                int age = rs.getInt("Age");
                String address = rs.getString("Address");
                String fullname = rs.getString("Fullname");
                dto = new UserDTO(username, role, address, fullname, age);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }
    
    
    public boolean insertUser(UserDTO dto) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into tbl_User values (?,?,?,?,?,?,?)";
            ptm = conn.prepareCall(sql);
            ptm.setString(1, dto.getUsername());
            ptm.setString(2, dto.getPassword());
            ptm.setString(3, "user");
            ptm.setInt(4, dto.getAge());
            ptm.setString(5, dto.getAddress());
            ptm.setString(6, dto.getFullname());
            ptm.setInt(7, 0);
            
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        
        return check;
    }
}
