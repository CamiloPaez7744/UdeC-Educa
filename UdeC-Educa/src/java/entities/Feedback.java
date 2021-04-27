/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kmilo
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByIdFeedback", query = "SELECT f FROM Feedback f WHERE f.idFeedback = :idFeedback")
    , @NamedQuery(name = "Feedback.findByDescriptionfeed", query = "SELECT f FROM Feedback f WHERE f.descriptionfeed = :descriptionfeed")
    , @NamedQuery(name = "Feedback.findByCalification", query = "SELECT f FROM Feedback f WHERE f.calification = :calification")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feedback")
    private Integer idFeedback;
    @Size(max = 300)
    @Column(name = "descriptionfeed")
    private String descriptionfeed;
    @Column(name = "calification")
    private Integer calification;
    @JoinColumn(name = "id_suscription", referencedColumnName = "id_suscription")
    @ManyToOne
    private Suscription idSuscription;

    public Feedback() {
    }

    public Feedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getDescriptionfeed() {
        return descriptionfeed;
    }

    public void setDescriptionfeed(String descriptionfeed) {
        this.descriptionfeed = descriptionfeed;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public Suscription getIdSuscription() {
        return idSuscription;
    }

    public void setIdSuscription(Suscription idSuscription) {
        this.idSuscription = idSuscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeedback != null ? idFeedback.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.idFeedback == null && other.idFeedback != null) || (this.idFeedback != null && !this.idFeedback.equals(other.idFeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feedback[ idFeedback=" + idFeedback + " ]";
    }
    
}
