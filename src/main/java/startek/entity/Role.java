/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "wed_roles")
public class Role implements Serializable {

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> appusers;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleid;
    @Column(name = "role_name")
    private String roleName;

    public List<AppUser> getAppusers() {
        return appusers;
    }

    public void setAppusers(List<AppUser> appusers) {
        this.appusers = appusers;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
