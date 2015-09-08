/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Embeddable
public class WeddingBusiness implements Serializable {

    private String businessname;
    private String businesscatchword;
    @Column(columnDefinition = "LONGTEXT")
    private String businessdescription;
    
    @Column(columnDefinition = "LONGTEXT")
    private String businesssubdescription;
    private String businesslocation;
    private String businesslocationat;
    private String businessphone;
    private String businessemail;
    private String businessbrandicon;

    public String getBusinesssubdescription() {
        return businesssubdescription;
    }

    public void setBusinesssubdescription(String businesssubdescription) {
        this.businesssubdescription = businesssubdescription;
    }

    public String getBusinesscatchword() {
        return businesscatchword;
    }

    public void setBusinesscatchword(String businesscatchword) {
        this.businesscatchword = businesscatchword;
    }

    public String getBusinesslocationat() {
        return businesslocationat;
    }

    public void setBusinesslocationat(String businesslocationat) {
        this.businesslocationat = businesslocationat;
    }

    public String getBusinessbrandicon() {
        return businessbrandicon;
    }

    public void setBusinessbrandicon(String businessbrandicon) {
        this.businessbrandicon = businessbrandicon;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getBusinessdescription() {
        return businessdescription;
    }

    
    public void setBusinessdescription(String businessdescription) {
        this.businessdescription = businessdescription;
    }

    public String getBusinesslocation() {
        return businesslocation;
    }

    public void setBusinesslocation(String businesslocation) {
        this.businesslocation = businesslocation;
    }

    public String getBusinessphone() {
        return businessphone;
    }

    public void setBusinessphone(String businessphone) {
        this.businessphone = businessphone;
    }

    public String getBusinessemail() {
        return businessemail;
    }

    public void setBusinessemail(String businessemail) {
        this.businessemail = businessemail;
    }

}
