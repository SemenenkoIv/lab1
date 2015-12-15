/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_7.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Semenenko
 */
@Entity
@Table(name = "Visited")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visited.findAll", query = "SELECT v FROM Visited v"),
    @NamedQuery(name = "Visited.findByIdP", query = "SELECT v FROM Visited v WHERE v.idP = :idP"),
    @NamedQuery(name = "Visited.findByNameD", query = "SELECT v FROM Visited v WHERE v.nameD = :nameD"),
    @NamedQuery(name = "Visited.findByCabinet", query = "SELECT v FROM Visited v WHERE v.cabinet = :cabinet")})
public class Visited implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_P")
    private Integer idP;
    @Column(name = "Name_D")
    private String nameD;
    @Column(name = "Cabinet")
    private String cabinet;

    public Visited() {
    }

    public Visited(Integer idP) {
        this.idP = idP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visited)) {
            return false;
        }
        Visited other = (Visited) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n[ idP=" + idP +"\t"+nameD+"\t"+cabinet+ " ]";
    }
    
}
