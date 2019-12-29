/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.dto;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CustomerDTO implements Serializable{
    private String id;
    private String fullname;
    private String address;
    private int orderID;
    private String username;
    private int lvl;

    public CustomerDTO(String id, String fullname, String address, int orderID, String username, int lvl) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.orderID = orderID;
        this.username = username;
        this.lvl = lvl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    
    
}
