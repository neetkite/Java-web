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
import racoon.dto.RoomBillDTO;
import racoon.dto.RoomDTO;

/**
 *
 * @author Administrator
 */
public class RoomBillDAO implements Serializable {

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

    public int dayCal(String date1, String date2) throws ClassNotFoundException, SQLException {
        int day = 0;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select DATEDIFF(day, ?, ?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, date1);
            ptm.setString(2, date2);
            rs = ptm.executeQuery();
            if (rs.next()) {
                day = rs.getInt("");
            }

        } finally {
            closeConnection();
        }
        return day;
    }

    public List<RoomBillDTO> loadAllRoomBill() throws SQLException, ClassNotFoundException {
        List<RoomBillDTO> list = null;
        RoomBillDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomID, RoomNumber,"
                    + " DateIn, DateOut, Price, CartID, TotalPrice From RoomBill";
            ptm = conn.prepareStatement(sql);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoomID");
                float total = rs.getFloat("TotalPrice");
                int number = rs.getInt("RoomNumber");
                String cart = rs.getString("CartID");
                String checkin = rs.getString("DateIn");
                String checkout = rs.getString("DateOut");
                float price = rs.getFloat("Price");

                dto = new RoomBillDTO(number, cart, checkin, checkout, price, total);
                dto.setId(id);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomDTO> loadAllAvailable() throws SQLException, ClassNotFoundException {
        List<RoomDTO> list = null;
        RoomDTO dto = null;

        try {
            conn = myConnection.getMyConnection();
            String sql = "RoomNumber, Type,Status, Description, Price, Image Where Status = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setBoolean(1, true);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("RoomNumber");
                boolean type = rs.getBoolean("Type");
                boolean status = rs.getBoolean("Status");
                String des = rs.getString("Description");
                float price = rs.getFloat("Price");
                String img = rs.getString("Image");
                dto = new RoomDTO(number, type, status, des, price, img);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<RoomBillDTO> findRoombillByRoomNumber(int room) throws SQLException, ClassNotFoundException {
        List<RoomBillDTO> list = null;
        RoomBillDTO dto = null;
        try {
            conn = myConnection.getMyConnection();
            String sql = "Select  RoomNumber,"
                    + " DateIn, DateOut, Price, CartID, Total, Customer From RoomBill Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, room);
            list = new ArrayList<>();
            rs = ptm.executeQuery();
            while (rs.next()) {
                float total = rs.getFloat("Total");
                int number = rs.getInt("RoomNumber");
                String cart = rs.getString("CartID");
                String checkin = rs.getString("DateIn");
                String checkout = rs.getString("DateOut");
                float price = rs.getFloat("Price");

                dto = new RoomBillDTO(number, cart, checkin, checkout, price, total);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkAvailable(String date1, String date2, int id) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select DateIn, DateOut From RoomBill Where ? >= DateIn and ? <= DateOut and RoomNumber = ? OR"
                    + " ? >= DateIn "
                    + "and ? <= DateOut and RoomNumber = ? OR ? <= DateIn and ? >= DateOut and RoomNumber = ? OR"
                    + " ? >= DateIn and ? <= DateOut and RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, date1);
            ptm.setString(2, date1);
            ptm.setInt(3, id);
            ptm.setString(4, date2);
            ptm.setString(5, date2);
            ptm.setInt(6, id);
            ptm.setString(7, date1);
            ptm.setString(8, date2);
            ptm.setInt(9, id);
            ptm.setString(10, date1);
            ptm.setString(11, date2);
            ptm.setInt(12, id);
            rs = ptm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean insertR(RoomBillDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into RoomBill values(?,?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, dto.getRoom());
            ptm.setString(2, dto.getCheckin());
            ptm.setString(3, dto.getCheckout());
            ptm.setFloat(4, dto.getPrice());
            ptm.setString(5, dto.getCart());
            ptm.setFloat(6, dto.getTotal());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public int findPK(int roomnumber) throws ClassNotFoundException, SQLException {
        int check = 0;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Select RoomID From RoomBill Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, roomnumber);
            rs = ptm.executeQuery();
            if(rs.next()){
                check = rs.getInt("RoomID");
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {

            conn = myConnection.getMyConnection();
            String sql = "Delete From RoomBill Where RoomID = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean insertHistory(RoomBillDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;

        try {
            conn = myConnection.getMyConnection();
            String sql = "Insert into RoomBillHistory values(?,?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, dto.getId());
            ptm.setInt(2, dto.getRoom());
            ptm.setString(3, dto.getCheckin());
            ptm.setString(4, dto.getCheckout());
            ptm.setFloat(5, dto.getPrice());
            ptm.setFloat(6, dto.getTotal());
            check = ptm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public RoomBillDTO findBillByRoomNumber(int room) throws SQLException, ClassNotFoundException {

        RoomBillDTO dto = null;
        try {
            conn = myConnection.getMyConnection();
            String sql = "Select  RoomNumber,"
                    + " DateIn, DateOut, Price, CartID, Total From RoomBill Where RoomNumber = ?";
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, room);
            rs = ptm.executeQuery();
            if (rs.next()) {
                float total = rs.getFloat("Total");
                int number = rs.getInt("RoomNumber");
                String cart = rs.getString("CartID");
                String checkin = rs.getString("DateIn");
                String checkout = rs.getString("DateOut");
                float price = rs.getFloat("Price");

                dto = new RoomBillDTO(number, cart, checkin, checkout, price, total);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

}
