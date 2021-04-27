/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "identification_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdentificationType.findAll", query = "SELECT i FROM IdentificationType i")
    , @NamedQuery(name = "IdentificationType.findByIdType", query = "SELECT i FROM IdentificationType i WHERE i.idType = :idType")
    , @NamedQuery(name = "IdentificationType.findByTypeIdName", query = "SELECT i FROM IdentificationType i WHERE i.typeIdName = :typeIdName")})
public class IdentificationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id_type")
    private String idType;
    @Size(max = 40)
    @Column(name = "type_id_name")
    private String typeIdName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationType")
    private List<Userue> userueList;

    public IdentificationType() {
    }

    public IdentificationType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getTypeIdName() {
        return typeIdName;
    }

    public void setTypeIdName(String typeIdName) {
        this.typeIdName = typeIdName;
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
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationType)) {
            return false;
        }
        IdentificationType other = (IdentificationType) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.IdentificationType[ idType=" + idType + " ]";
    }
    
}
