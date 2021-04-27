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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kmilo
 */
@Entity
@Table(name = "suscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscription.findAll", query = "SELECT s FROM Suscription s")
    , @NamedQuery(name = "Suscription.findByIdSuscription", query = "SELECT s FROM Suscription s WHERE s.idSuscription = :idSuscription")})
public class Suscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_suscription")
    private Integer idSuscription;
    @OneToMany(mappedBy = "idSuscription")
    private List<Feedback> feedbackList;
    @JoinColumn(name = "number_identification", referencedColumnName = "number_identification")
    @ManyToOne
    private Userue numberIdentification;
    @JoinColumn(name = "event_name", referencedColumnName = "event_name")
    @ManyToOne
    private Eventue eventName;

    public Suscription() {
    }

    public Suscription(Integer idSuscription) {
        this.idSuscription = idSuscription;
    }

    public Integer getIdSuscription() {
        return idSuscription;
    }

    public void setIdSuscription(Integer idSuscription) {
        this.idSuscription = idSuscription;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Userue getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(Userue numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    public Eventue getEventName() {
        return eventName;
    }

    public void setEventName(Eventue eventName) {
        this.eventName = eventName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuscription != null ? idSuscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscription)) {
            return false;
        }
        Suscription other = (Suscription) object;
        if ((this.idSuscription == null && other.idSuscription != null) || (this.idSuscription != null && !this.idSuscription.equals(other.idSuscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Suscription[ idSuscription=" + idSuscription + " ]";
    }
    
}
