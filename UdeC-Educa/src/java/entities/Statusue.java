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
@Table(name = "statusue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statusue.findAll", query = "SELECT s FROM Statusue s")
    , @NamedQuery(name = "Statusue.findByIdStatus", query = "SELECT s FROM Statusue s WHERE s.idStatus = :idStatus")
    , @NamedQuery(name = "Statusue.findByStatusName", query = "SELECT s FROM Statusue s WHERE s.statusName = :statusName")})
public class Statusue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id_status")
    private String idStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status_name")
    private String statusName;
    @OneToMany(mappedBy = "eventStatus")
    private List<Eventue> eventueList;

    public Statusue() {
    }

    public Statusue(String idStatus) {
        this.idStatus = idStatus;
    }

    public Statusue(String idStatus, String statusName) {
        this.idStatus = idStatus;
        this.statusName = statusName;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @XmlTransient
    public List<Eventue> getEventueList() {
        return eventueList;
    }

    public void setEventueList(List<Eventue> eventueList) {
        this.eventueList = eventueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusue)) {
            return false;
        }
        Statusue other = (Statusue) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statusue[ idStatus=" + idStatus + " ]";
    }
    
}
