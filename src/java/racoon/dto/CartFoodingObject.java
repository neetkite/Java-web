/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racoon.dao.FoodingDAO;

/**
 *
 * @author Administrator
 */
public class CartFoodingObject {

    private String customerName;
    private HashMap<String, Integer> cart;
    private float total;

    public float getTotal() {
        return total;
    }

    public CartFoodingObject() {
        this.customerName = "Guest";
        cart = new HashMap<>();
    }

    public CartFoodingObject(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<FoodingDTO> getCartDetail() throws SQLException, ClassNotFoundException {
        this.total = 0;
        List<FoodingDTO> dtoList = new ArrayList<>();
        FoodingDAO dao = new FoodingDAO();
        for (String key : this.cart.keySet()) {//lấy toàn bộ id trong cart để tìm
            FoodingDTO dto = dao.FindByPK(key);
            dto.setQuantityCart(this.cart.get(key));
            dtoList.add(dto);
            this.total += dto.getQuantityCart() * dto.getPrice();
        }
        
        return dtoList;

    }

    public void addToCart(String id) {
        int quantityCart = 1;
       
        if (this.cart.containsKey(id)) {
            quantityCart = this.cart.get(id) + 1; 
        }
        this.cart.put(id, quantityCart);
       
    }

    public void removeCart(String id) {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void updateCart(String id, int quantityCart) {

        if (this.cart.containsKey(id)) {
            this.cart.put(id, quantityCart);
        }
    }
}
