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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "eventue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventue.findAll", query = "SELECT e FROM Eventue e")
    , @NamedQuery(name = "Eventue.findByEventName", query = "SELECT e FROM Eventue e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Eventue.findByEventStartDate", query = "SELECT e FROM Eventue e WHERE e.eventStartDate = :eventStartDate")
    , @NamedQuery(name = "Eventue.findByEventEndDate", query = "SELECT e FROM Eventue e WHERE e.eventEndDate = :eventEndDate")
    , @NamedQuery(name = "Eventue.findByFacultad", query = "SELECT e FROM Eventue e WHERE e.facultad = :facultad")
    , @NamedQuery(name = "Eventue.findByPrograma", query = "SELECT e FROM Eventue e WHERE e.programa = :programa")
    , @NamedQuery(name = "Eventue.findBySeccional", query = "SELECT e FROM Eventue e WHERE e.seccional = :seccional")})
public class Eventue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventStartDate;
    @Column(name = "event_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "facultad")
    private String facultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "programa")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "seccional")
    private String seccional;
    @OneToMany(mappedBy = "eventName")
    private List<Suscription> suscriptionList;
    @JoinColumn(name = "event_category", referencedColumnName = "id_category")
    @ManyToOne
    private Category eventCategory;
    @JoinColumn(name = "event_status", referencedColumnName = "id_status")
    @ManyToOne
    private Statusue eventStatus;

    public Eventue() {
    }

    public Eventue(String eventName) {
        this.eventName = eventName;
    }

    public Eventue(String eventName, String facultad, String programa, String seccional) {
        this.eventName = eventName;
        this.facultad = facultad;
        this.programa = programa;
        this.seccional = seccional;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSeccional() {
        return seccional;
    }

    public void setSeccional(String seccional) {
        this.seccional = seccional;
    }

    @XmlTransient
    public List<Suscription> getSuscriptionList() {
        return suscriptionList;
    }

    public void setSuscriptionList(List<Suscription> suscriptionList) {
        this.suscriptionList = suscriptionList;
    }

    public Category getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(Category eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Statusue getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Statusue eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventName != null ? eventName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventue)) {
            return false;
        }
        Eventue other = (Eventue) object;
        if ((this.eventName == null && other.eventName != null) || (this.eventName != null && !this.eventName.equals(other.eventName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Eventue[ eventName=" + eventName + " ]";
    }
    
}
