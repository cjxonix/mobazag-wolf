/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "wed_posttag")
public class PostTag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagid;
    private String tagname;

    @ManyToMany(mappedBy = "posttags")
    private List<WeddingPost> weddingpost;

    public PostTag(Long tagid, String tagname) {
        this.tagid = tagid;
        this.tagname = tagname;
    }

    public PostTag() {
    }

    public PostTag(String tagname) {
        this.tagname = tagname;
    }

    @XmlTransient
    @JsonIgnore
    public List<WeddingPost> getWeddingpost() {
        return weddingpost;
    }

    public void setWeddingpost(List<WeddingPost> weddingpost) {
        this.weddingpost = weddingpost;
    }

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

}
