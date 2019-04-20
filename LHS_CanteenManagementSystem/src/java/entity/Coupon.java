/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "COUPON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c")
    , @NamedQuery(name = "Coupon.findByCouponid", query = "SELECT c FROM Coupon c WHERE c.couponid = :couponid")
    , @NamedQuery(name = "Coupon.findByTotalcreditpoints", query = "SELECT c FROM Coupon c WHERE c.totalcreditpoints = :totalcreditpoints")})
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COUPONID")
    private String couponid;
    @Column(name = "TOTALCREDITPOINTS")
    private Integer totalcreditpoints;
    @JoinColumn(name = "MEALORDERID", referencedColumnName = "MEALORDERID")
    @ManyToOne
    private Mealorder mealorderid;

    public Coupon() {
    }

    public Coupon(String couponid) {
        this.couponid = couponid;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    public Integer getTotalcreditpoints() {
        return totalcreditpoints;
    }

    public void setTotalcreditpoints(Integer totalcreditpoints) {
        this.totalcreditpoints = totalcreditpoints;
    }

    public Mealorder getMealorderid() {
        return mealorderid;
    }

    public void setMealorderid(Mealorder mealorderid) {
        this.mealorderid = mealorderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponid != null ? couponid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coupon)) {
            return false;
        }
        Coupon other = (Coupon) object;
        if ((this.couponid == null && other.couponid != null) || (this.couponid != null && !this.couponid.equals(other.couponid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Coupon[ couponid=" + couponid + " ]";
    }
    
}
