/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diana
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByAuthKey", query = "SELECT a FROM Auditoria a WHERE a.authKey = :authKey")
    , @NamedQuery(name = "Auditoria.findByFecha", query = "SELECT a FROM Auditoria a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Auditoria.findByAccion", query = "SELECT a FROM Auditoria a WHERE a.accion = :accion")
    , @NamedQuery(name = "Auditoria.findByContenido", query = "SELECT a FROM Auditoria a WHERE a.contenido = :contenido")
    , @NamedQuery(name = "Auditoria.findLast", query = " SELECT max(a.fecha) FROM Auditoria a WHERE a.numberIdentification = :id_usuario")    
})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auth_key")
    private Integer authKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accion")
    private String accion;
    @Size(max = 100)
    @Column(name = "contenido")
    private String contenido;
    @JoinColumn(name = "number_identification", referencedColumnName = "number_identification")
    @ManyToOne
    private Userue numberIdentification;

    public Auditoria() {
    }

    public Auditoria(Integer authKey) {
        this.authKey = authKey;
    }

    public Auditoria(Integer authKey, Date fecha, String accion) {
        this.authKey = authKey;
        this.fecha = fecha;
        this.accion = accion;
    }

    public Integer getAuthKey() {
        return authKey;
    }

    public void setAuthKey(Integer authKey) {
        this.authKey = authKey;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Userue getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(Userue numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authKey != null ? authKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.authKey == null && other.authKey != null) || (this.authKey != null && !this.authKey.equals(other.authKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auditoria[ authKey=" + authKey + " ]";
    }
    
}
