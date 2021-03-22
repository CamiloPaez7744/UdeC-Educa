/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DTO;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserDTO {

    private String identification;
    private String first_name;
    private String second_name;
    private String first_lastname;
    private String second_lastname;
    private String email;
    private String username;
    private String password;

    public UserDTO(String identification, String first_name, String second_name, String first_lastname, String second_lastname, String email, String username, String password) {
        this.identification = identification;
        this.first_name = first_name;
        this.second_name = second_name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    
    

}
