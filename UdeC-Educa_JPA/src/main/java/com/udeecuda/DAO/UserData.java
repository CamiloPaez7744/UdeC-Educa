/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udeecuda.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author UdeC-Educa Dev's Team
 */
@Entity
@Table(name = "user_data")
@NamedQueries({
    @NamedQuery(name = "UserData.findAll", query = "SELECT u FROM UserData u"),
    @NamedQuery(name = "UserData.findByIdUser", query = "SELECT u FROM UserData u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "UserData.findByIdentification", query = "SELECT u FROM UserData u WHERE u.identification = :identification"),
    @NamedQuery(name = "UserData.findByFirstName", query = "SELECT u FROM UserData u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserData.findBySecondName", query = "SELECT u FROM UserData u WHERE u.secondName = :secondName"),
    @NamedQuery(name = "UserData.findByFirstLastname", query = "SELECT u FROM UserData u WHERE u.firstLastname = :firstLastname"),
    @NamedQuery(name = "UserData.findBySecondLastname", query = "SELECT u FROM UserData u WHERE u.secondLastname = :secondLastname"),
    @NamedQuery(name = "UserData.findByEmail", query = "SELECT u FROM UserData u WHERE u.email = :email"),
    @NamedQuery(name = "UserData.findByUsername", query = "SELECT u FROM UserData u WHERE u.username = :username"),
    @NamedQuery(name = "UserData.findByHashPass", query = "SELECT u FROM UserData u WHERE u.hashPass = :hashPass")})
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Long idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "identification")
    private String identification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 30)
    @Column(name = "second_name")
    private String secondName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_lastname")
    private String firstLastname;
    @Size(max = 30)
    @Column(name = "second_lastname")
    private String secondLastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 80)
    @Column(name = "username")
    private String username;
    @Lob
    @Column(name = "compress_pass")
    private byte[] compressPass;
    @Size(max = 128)
    @Column(name = "hash_pass")
    private String hashPass;
    @Lob
    @Column(name = "enc_pass")
    private byte[] encPass;

    public UserData() {
    }

    public UserData(Long idUser) {
        this.idUser = idUser;
    }

    public UserData(Long idUser, String identification, String firstName, String firstLastname, String email) {
        this.idUser = idUser;
        this.identification = identification;
        this.firstName = firstName;
        this.firstLastname = firstLastname;
        this.email = email;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getCompressPass() {
        return compressPass;
    }

    public void setCompressPass(byte[] compressPass) {
        this.compressPass = compressPass;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public byte[] getEncPass() {
        return encPass;
    }

    public void setEncPass(byte[] encPass) {
        this.encPass = encPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserData)) {
            return false;
        }
        UserData other = (UserData) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udeecuda.DAO.UserData[ idUser=" + idUser + " ]";
    }

}
