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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kmilo
 */
@Entity
@Table(name = "competitor")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Competitor.findAll", query = "SELECT c FROM Competitor c")
    , @NamedQuery(name = "Competitor.findByIdCompetitor", query = "SELECT c FROM Competitor c WHERE c.idCompetitor = :idCompetitor")
    , @NamedQuery(name = "Competitor.findByNameCompetitorType", query = "SELECT c FROM Competitor c WHERE c.nameCompetitorType = :nameCompetitorType")})
public class Competitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_competitor")
    private String idCompetitor;
    @Size(max = 15)
    @Column(name = "name_competitor_type")
    private String nameCompetitorType;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competitorType")
    private List<Userue> userueList;

    public Competitor() {
    }

    public Competitor(String idCompetitor) {
        this.idCompetitor = idCompetitor;
    }

    public String getIdCompetitor() {
        return idCompetitor;
    }

    public void setIdCompetitor(String idCompetitor) {
        this.idCompetitor = idCompetitor;
    }

    public String getNameCompetitorType() {
        return nameCompetitorType;
    }

    public void setNameCompetitorType(String nameCompetitorType) {
        this.nameCompetitorType = nameCompetitorType;
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
        hash += (idCompetitor != null ? idCompetitor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competitor)) {
            return false;
        }
        Competitor other = (Competitor) object;
        if ((this.idCompetitor == null && other.idCompetitor != null) || (this.idCompetitor != null && !this.idCompetitor.equals(other.idCompetitor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Competitor[ idCompetitor=" + idCompetitor + " ]";
    }
    
}
