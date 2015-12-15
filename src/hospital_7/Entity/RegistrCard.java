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
@Table(name = "registr_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrCard.findAll", query = "SELECT r FROM RegistrCard r"),
    @NamedQuery(name = "RegistrCard.findByNamep", query = "SELECT r FROM RegistrCard r WHERE r.namep = :namep"),
    @NamedQuery(name = "RegistrCard.findByDateOfBirthday", query = "SELECT r FROM RegistrCard r WHERE r.dateOfBirthday = :dateOfBirthday"),
    @NamedQuery(name = "RegistrCard.findByAdress", query = "SELECT r FROM RegistrCard r WHERE r.adress = :adress"),
    @NamedQuery(name = "RegistrCard.findByDateOfAdmission", query = "SELECT r FROM RegistrCard r WHERE r.dateOfAdmission = :dateOfAdmission"),
    @NamedQuery(name = "RegistrCard.findByIdP", query = "SELECT r FROM RegistrCard r WHERE r.idP = :idP")})
public class RegistrCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Name_p")
    private String namep;
    @Column(name = "DateOfBirthday")
    private String dateOfBirthday;
    @Column(name = "Adress")
    private String adress;
    @Column(name = "dateOfAdmission")
    private String dateOfAdmission;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_P")
    private Integer idP;

    public RegistrCard() {
    }

    public RegistrCard(Integer idP) {
        this.idP = idP;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
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
        if (!(object instanceof RegistrCard)) {
            return false;
        }
        RegistrCard other = (RegistrCard) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital_7.RegistrCard[ idP=" + idP + " ]";
    }
    
}
