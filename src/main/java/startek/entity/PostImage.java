/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_postimage")
public class PostImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postimageid;
    private String postimage;
    private String postimagex285;
    private String postimagex490;
    private String postimagex200;
    private String postimagex100;
    private String postimagex80;
    @OneToOne
    private AppUser imageowner;
    private String imagetitle;
    private String imagedescription;
    private String takenby;
    //private image file data
    private Double filesize;
    private String filesizestr;
    private boolean prt;//[if height is bgger than width]

    public PostImage() {
    }

    public PostImage(String postimage, String postimagex285, String postimagex490, String postimagex200, String postimagex100, String postimagex80, AppUser imageowner, String imagetitle, String imagedescription, Double filesize, String filesizestr) {
        this.postimage = postimage;
        this.postimagex285 = postimagex285;
        this.postimagex490 = postimagex490;
        this.postimagex200 = postimagex200;
        this.postimagex100 = postimagex100;
        this.postimagex80 = postimagex80;
        this.imageowner = imageowner;
        this.imagetitle = imagetitle;
        this.imagedescription = imagedescription;
        this.filesize = filesize;
        this.filesizestr = filesizestr;
    }

    public PostImage(String postimage, String postimagex285, String postimagex490, String postimagex200,
            String postimagex100, String postimagex80, String imagetitle, String imagedescription,
            Double filesize, String filesizestr) {
        this.postimage = postimage;
        this.postimagex285 = postimagex285;
        this.postimagex490 = postimagex490;
        this.postimagex200 = postimagex200;
        this.postimagex100 = postimagex100;
        this.postimagex80 = postimagex80;
        this.imagetitle = imagetitle;
        this.imagedescription = imagedescription;
        this.filesize = filesize;
        this.filesizestr = filesizestr;
    }

    public String getTakenby() {
        return takenby;
    }

    public void setTakenby(String takenby) {
        this.takenby = takenby;
    }
    
    

    public boolean isPrt() {
        return prt;
    }

    public void setPrt(boolean prt) {
        this.prt = prt;
    }

    public String getFilesizestr() {
        return filesizestr;
    }

    public void setFilesizestr(String filesizestr) {
        this.filesizestr = filesizestr;
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String imagetitle) {
        this.imagetitle = imagetitle;
    }

    public String getImagedescription() {
        return imagedescription;
    }

    public void setImagedescription(String imagedescription) {
        this.imagedescription = imagedescription;
    }

    public Long getPostimageid() {
        return postimageid;
    }

    public void setPostimageid(Long postimageid) {
        this.postimageid = postimageid;
    }

    public String getPostimage() {
        return postimage;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public String getPostimagex285() {
        return postimagex285;
    }

    public void setPostimagex285(String postimagex285) {
        this.postimagex285 = postimagex285;
    }

    public String getPostimagex490() {
        return postimagex490;
    }

    public void setPostimagex490(String postimagex490) {
        this.postimagex490 = postimagex490;
    }

    public String getPostimagex200() {
        return postimagex200;
    }

    public void setPostimagex200(String postimagex200) {
        this.postimagex200 = postimagex200;
    }

    public String getPostimagex100() {
        return postimagex100;
    }

    public void setPostimagex100(String postimagex100) {
        this.postimagex100 = postimagex100;
    }

    public String getPostimagex80() {
        return postimagex80;
    }

    public void setPostimagex80(String postimagex80) {
        this.postimagex80 = postimagex80;
    }

    public AppUser getImageowner() {
        return imageowner;
    }

    public void setImageowner(AppUser imageowner) {
        this.imageowner = imageowner;
    }

}
