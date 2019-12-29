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
public class UserErrorObject implements Serializable{
    private String fullnameError, addressError;
    private String ageError;

    public UserErrorObject() {
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getAgeError() {
        return ageError;
    }

    public void setAgeError(String ageError) {
        this.ageError = ageError;
    }

    
    
}
