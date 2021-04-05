/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kmilo
 */
@Entity
@Table(name = "user_data")
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "sp_updateUser",
        procedureName = "sp_updateUser",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "id")
        }
    ),

    @NamedStoredProcedureQuery(
        name = "sp_encryptPassword",
        procedureName = "sp_encryptPassword",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "id"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "user_password")
        }
    ),
        
    @NamedStoredProcedureQuery(
        name = "sp_decryptPassword",
        procedureName = "sp_decryptPassword",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "id"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "user_password"),
            @StoredProcedureParameter(mode = ParameterMode.INOUT, type = boolean.class, name = "res")
        }
    )    
})
@NamedQueries({
    @NamedQuery(name = "UserData.findAll", query = "SELECT u FROM UserData u"),
    @NamedQuery(name = "UserData.findByIdentification", query = "SELECT u FROM UserData u WHERE u.identification = :identification"),
    @NamedQuery(name = "UserData.findByFirstName", query = "SELECT u FROM UserData u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserData.findBySecondName", query = "SELECT u FROM UserData u WHERE u.secondName = :secondName"),
    @NamedQuery(name = "UserData.findByFirstLastname", query = "SELECT u FROM UserData u WHERE u.firstLastname = :firstLastname"),
    @NamedQuery(name = "UserData.findBySecondLastname", query = "SELECT u FROM UserData u WHERE u.secondLastname = :secondLastname"),
    @NamedQuery(name = "UserData.findByEmail", query = "SELECT u FROM UserData u WHERE u.email = :email"),
    @NamedQuery(name = "UserData.findByUsername", query = "SELECT u FROM UserData u WHERE u.username = :username"),
    @NamedQuery(name = "UserData.findByHashPass", query = "SELECT u FROM UserData u WHERE u.hashPass = :hashPass")})
public class UserData implements Serializable {

    @Lob
    @Column(name = "enc_pass")
    private byte[] encPass;
    @OneToMany(mappedBy = "identification")
    private List<Evento> eventoList;

    private static final long serialVersionUID = 1L;
    @Id
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
    @Size(max = 128)
    @Column(name = "hash_pass")
    private String hashPass;

    public UserData() {
    }

    public UserData(String identification) {
        this.identification = identification;
    }

    public UserData(String identification, String firstName, String firstLastname, String email) {
        this.identification = identification;
        this.firstName = firstName;
        this.firstLastname = firstLastname;
        this.email = email;
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
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserData)) {
            return false;
        }
        UserData other = (UserData) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udeceduca.DAO.UserData[ identification=" + identification + " ]";
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }
    
}
