/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_work_request")
public class WorkRequest implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long requestid;
    private String subject;
    private String body;
    private String fullname;
    private String phone;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date weddingday;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdon;
    private String people;
    private String location;
    @OneToOne
    private AppUser serviceprovider;
    private boolean enabled;

    public WorkRequest() {
    }

    public WorkRequest(String subject, String body, String fullname, String phone, String email, Date weddingday, Date createdon, String people, String location) {
        this.subject = subject;
        this.body = body;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.weddingday = weddingday;
        this.createdon = createdon;
        this.people = people;
        this.location = location;
    }

    
    
    
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getRequestid() {
        return requestid;
    }

    public void setRequestid(Long requestid) {
        this.requestid = requestid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getWeddingday() {
        return weddingday;
    }

    public void setWeddingday(Date weddingday) {
        this.weddingday = weddingday;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AppUser getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(AppUser serviceprovider) {
        this.serviceprovider = serviceprovider;
    }
    
    

}
