/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "institution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i")
    , @NamedQuery(name = "Institution.findByIdInstitution", query = "SELECT i FROM Institution i WHERE i.idInstitution = :idInstitution")
    , @NamedQuery(name = "Institution.findByNameIntitution", query = "SELECT i FROM Institution i WHERE i.nameIntitution = :nameIntitution")})
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "id_institution")
    private String idInstitution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name_intitution")
    private String nameIntitution;
    @OneToMany(mappedBy = "idIntitution")
    private List<Userue> userueList;

    public Institution() {
    }

    public Institution(String idInstitution) {
        this.idInstitution = idInstitution;
    }

    public Institution(String idInstitution, String nameIntitution) {
        this.idInstitution = idInstitution;
        this.nameIntitution = nameIntitution;
    }

    public String getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(String idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getNameIntitution() {
        return nameIntitution;
    }

    public void setNameIntitution(String nameIntitution) {
        this.nameIntitution = nameIntitution;
    }

    @XmlTransient
    public List<Userue> getUserueList() {
        return userueList;
    }

    public void setUserueList(List<Userue> userueList) {
        this.userueList = userueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitution != null ? idInstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.idInstitution == null && other.idInstitution != null) || (this.idInstitution != null && !this.idInstitution.equals(other.idInstitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Institution[ idInstitution=" + idInstitution + " ]";
    }
    
}
