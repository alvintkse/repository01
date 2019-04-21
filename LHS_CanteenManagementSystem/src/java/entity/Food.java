/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author User
 */
@Entity
@Table(name = "FOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findByFoodid", query = "SELECT f FROM Food f WHERE f.foodid = :foodid")
    , @NamedQuery(name = "Food.findByFoodname", query = "SELECT f FROM Food f WHERE f.foodname = :foodname")
    , @NamedQuery(name = "Food.findByFoodcreditpoints", query = "SELECT f FROM Food f WHERE f.foodcreditpoints = :foodcreditpoints")
    , @NamedQuery(name = "Food.findByFoodquantity", query = "SELECT f FROM Food f WHERE f.foodquantity = :foodquantity")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FOODID")
    private String foodid;
    @Size(max = 50)
    @Column(name = "FOODNAME")
    private String foodname;
    @Column(name = "FOODCREDITPOINTS")
    private Integer foodcreditpoints;
    @Column(name = "FOODQUANTITY")
    private Integer foodquantity;
    @OneToMany(mappedBy = "foodname")
    private Collection<Meal> mealCollection;

    public Food() {
    }

    public Food(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getFoodcreditpoints() {
        return foodcreditpoints;
    }

    public void setFoodcreditpoints(Integer foodcreditpoints) {
        this.foodcreditpoints = foodcreditpoints;
    }

    public Integer getFoodquantity() {
        return foodquantity;
    }

    public void setFoodquantity(Integer foodquantity) {
        this.foodquantity = foodquantity;
    }

    @XmlTransient
    public Collection<Meal> getMealCollection() {
        return mealCollection;
    }

    public void setMealCollection(Collection<Meal> mealCollection) {
        this.mealCollection = mealCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Food[ foodid=" + foodid + " ]";
    }
    
}
