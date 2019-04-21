/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author User
 */
@Entity
@Table(name = "MEALORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mealorder.findAll", query = "SELECT m FROM Mealorder m")
    , @NamedQuery(name = "Mealorder.findByMealorderid", query = "SELECT m FROM Mealorder m WHERE m.mealorderid = :mealorderid")
    , @NamedQuery(name = "Mealorder.findByMealorderdate", query = "SELECT m FROM Mealorder m WHERE m.mealorderdate = :mealorderdate")
    , @NamedQuery(name = "Mealorder.findByMealorderstatus", query = "SELECT m FROM Mealorder m WHERE m.mealorderstatus = :mealorderstatus")})
public class Mealorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEALORDERID")
    private String mealorderid;
    @Column(name = "MEALORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date mealorderdate;
    @Size(max = 50)
    @Column(name = "MEALORDERSTATUS")
    private String mealorderstatus;
    @JoinColumn(name = "MEALNAME", referencedColumnName = "MEALNAME")
    @ManyToOne
    private Meal mealname;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne
    private Student studentid;
    @OneToMany(mappedBy = "mealorderid")
    private Collection<Coupon> couponCollection;

    public Mealorder() {
    }

    public Mealorder(String mealorderid) {
        this.mealorderid = mealorderid;
    }

    public String getMealorderid() {
        return mealorderid;
    }

    public void setMealorderid(String mealorderid) {
        this.mealorderid = mealorderid;
    }

    public Date getMealorderdate() {
        return mealorderdate;
    }

    public void setMealorderdate(Date mealorderdate) {
        this.mealorderdate = mealorderdate;
    }

    public String getMealorderstatus() {
        return mealorderstatus;
    }

    public void setMealorderstatus(String mealorderstatus) {
        this.mealorderstatus = mealorderstatus;
    }

    public Meal getMealname() {
        return mealname;
    }

    public void setMealname(Meal mealname) {
        this.mealname = mealname;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    @XmlTransient
    public Collection<Coupon> getCouponCollection() {
        return couponCollection;
    }

    public void setCouponCollection(Collection<Coupon> couponCollection) {
        this.couponCollection = couponCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealorderid != null ? mealorderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mealorder)) {
            return false;
        }
        Mealorder other = (Mealorder) object;
        if ((this.mealorderid == null && other.mealorderid != null) || (this.mealorderid != null && !this.mealorderid.equals(other.mealorderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mealorder[ mealorderid=" + mealorderid + " ]";
    }
    
}
