/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kmilo
 */
@Entity
@Table(name = "userue")
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
    @NamedQuery(name = "Userue.findAll", query = "SELECT u FROM Userue u")
    , @NamedQuery(name = "Userue.findByNumberIdentification", query = "SELECT u FROM Userue u WHERE u.numberIdentification = :numberIdentification")
    , @NamedQuery(name = "Userue.findByFirstName", query = "SELECT u FROM Userue u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "Userue.findBySecondName", query = "SELECT u FROM Userue u WHERE u.secondName = :secondName")
    , @NamedQuery(name = "Userue.findByFirstLastname", query = "SELECT u FROM Userue u WHERE u.firstLastname = :firstLastname")
    , @NamedQuery(name = "Userue.findBySecondLastname", query = "SELECT u FROM Userue u WHERE u.secondLastname = :secondLastname")
    , @NamedQuery(name = "Userue.findByPhone", query = "SELECT u FROM Userue u WHERE u.phone = :phone")
    , @NamedQuery(name = "Userue.findByEmail", query = "SELECT u FROM Userue u WHERE u.email = :email")
    , @NamedQuery(name = "Userue.findByBirthDate", query = "SELECT u FROM Userue u WHERE u.birthDate = :birthDate")
    , @NamedQuery(name = "Userue.findByUserRoler", query = "SELECT u FROM Userue u WHERE u.userRoler = :userRoler")
    , @NamedQuery(name = "Userue.findByUsername", query = "SELECT u FROM Userue u WHERE u.username = :username")
    , @NamedQuery(name = "Userue.findByAccessKey", query = "SELECT u FROM Userue u WHERE u.accessKey = :accessKey")})
public class Userue implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "enc_pass")
    private byte[] encPass;
    @OneToMany(mappedBy = "numberIdentification")
    private List<Auditoria> auditoriaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "number_identification")
    private String numberIdentification;
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
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_roler")
    private boolean userRoler;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "access_key")
    private String accessKey;
    @JoinColumn(name = "identification_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private IdentificationType identificationType;
    @JoinColumn(name = "competitor_type", referencedColumnName = "id_competitor")
    @ManyToOne(optional = false)
    private Competitor competitorType;
    @JoinColumn(name = "id_intitution", referencedColumnName = "id_institution")
    @ManyToOne
    private Institution idIntitution;
    @OneToMany(mappedBy = "numberIdentification")
    private List<Suscription> suscriptionList;

    public Userue() {
    }

    public Userue(String numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    public Userue(String numberIdentification, String firstName, String firstLastname, String phone, String email, Date birthDate, boolean userRoler, String username, String accessKey, byte[] encPass) {
        this.numberIdentification = numberIdentification;
        this.firstName = firstName;
        this.firstLastname = firstLastname;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.userRoler = userRoler;
        this.username = username;
        this.accessKey = accessKey;
        this.encPass = encPass;
    }

    public String getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(String numberIdentification) {
        this.numberIdentification = numberIdentification;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getUserRoler() {
        return userRoler;
    }

    public void setUserRoler(boolean userRoler) {
        this.userRoler = userRoler;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public byte[] getEncPass() {
        return encPass;
    }

    public void setEncPass(byte[] encPass) {
        this.encPass = encPass;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Competitor getCompetitorType() {
        return competitorType;
    }

    public void setCompetitorType(Competitor competitorType) {
        this.competitorType = competitorType;
    }

    public Institution getIdIntitution() {
        return idIntitution;
    }

    public void setIdIntitution(Institution idIntitution) {
        this.idIntitution = idIntitution;
    }

    @XmlTransient
    public List<Suscription> getSuscriptionList() {
        return suscriptionList;
    }

    public void setSuscriptionList(List<Suscription> suscriptionList) {
        this.suscriptionList = suscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberIdentification != null ? numberIdentification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userue)) {
            return false;
        }
        Userue other = (Userue) object;
        if ((this.numberIdentification == null && other.numberIdentification != null) || (this.numberIdentification != null && !this.numberIdentification.equals(other.numberIdentification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userue[ numberIdentification=" + numberIdentification + " ]";
    }

    @XmlTransient
    public List<Auditoria> getAuditoriaList() {
        return auditoriaList;
    }

    public void setAuditoriaList(List<Auditoria> auditoriaList) {
        this.auditoriaList = auditoriaList;
    }
    
}
