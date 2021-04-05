/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DTO;

/**
 *
 *
 * @author UdeC-Educa Dev's Team
 */
public class UserDTO {

    private String identification;
    private String first_name;
    private String second_name;
    private String first_lastname;
    private String second_lastname;
    private String email;
    private String username;

    public UserDTO(String identification, String first_name, String second_name, String first_lastname, String second_lastname, String email, String username) {
        this.identification = identification;
        this.first_name = first_name;
        this.second_name = second_name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.email = email;
        this.username = username;
    }

    public String getIdentification() {
        return identification;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
