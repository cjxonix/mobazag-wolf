/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_weddingarticlepost")
public class WeddingArticlePost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long weddingpostid;
    private String posttitle;
    @Column(columnDefinition = "LONGTEXT")
    private String subtitle;
    @Column(columnDefinition = "LONGTEXT")
    private String postdescription;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PostImage> imageinfo = new ArrayList<>();//atleast one image.

    @OneToOne
    private ArticleCategory postcategory;//[Must be in the Single Post Mappings]
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateposted;
    private Long postviews;
    private Long postlikes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ArticleTag> posttags = new ArrayList<>();
    @OneToOne
    private AppUser postedby;

    //Has video for tv article{Good to use a playlist of youtube since it is }
    private boolean active;
    private boolean hasvideo;
    private boolean coverpage;
    private boolean hot;
    private boolean hasplaylist;
    private String videoid;
    private String playlistid;
    //Main Page Front view [Count of these should determine.]
    private boolean frontviewed;
    private boolean ourfavourite;

    public WeddingArticlePost() {
    }

    public WeddingArticlePost(String posttitle, String postdescription, Date dateposted) {
        this.posttitle = posttitle;
        this.postdescription = postdescription;
        this.dateposted = dateposted;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isCoverpage() {
        return coverpage;
    }

    public void setCoverpage(boolean coverpage) {
        this.coverpage = coverpage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getWeddingpostid() {
        return weddingpostid;
    }

    public void setWeddingpostid(Long weddingpostid) {
        this.weddingpostid = weddingpostid;
    }

    public boolean isFrontviewed() {
        return frontviewed;
    }

    public void setFrontviewed(boolean frontviewed) {
        this.frontviewed = frontviewed;
    }

    public boolean isOurfavourite() {
        return ourfavourite;
    }

    public void setOurfavourite(boolean ourfavourite) {
        this.ourfavourite = ourfavourite;
    }

    public boolean isHasvideo() {
        return hasvideo;
    }

    public void setHasvideo(boolean hasvideo) {
        this.hasvideo = hasvideo;
    }

    public boolean isHasplaylist() {
        return hasplaylist;
    }

    public void setHasplaylist(boolean hasplaylist) {
        this.hasplaylist = hasplaylist;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostdescription() {
        return postdescription;
    }

    public void setPostdescription(String postdescription) {
        this.postdescription = postdescription;
    }

    public List<PostImage> getImageinfo() {
        return imageinfo;
    }

    public void setImageinfo(List<PostImage> imageinfo) {
        this.imageinfo = imageinfo;
    }

    public ArticleCategory getPostcategory() {
        return postcategory;
    }

    public void setPostcategory(ArticleCategory postcategory) {
        this.postcategory = postcategory;
    }

    public Date getDateposted() {
        return dateposted;
    }

    public void setDateposted(Date dateposted) {
        this.dateposted = dateposted;
    }

    public Long getPostviews() {
        return postviews;
    }

    public void setPostviews(Long postviews) {
        this.postviews = postviews;
    }

    public Long getPostlikes() {
        return postlikes;
    }

    public void setPostlikes(Long postlikes) {
        this.postlikes = postlikes;
    }

    public AppUser getPostedby() {
        return postedby;
    }

    public void setPostedby(AppUser postedby) {
        this.postedby = postedby;
    }

    @XmlTransient
    @JsonIgnore
    public List<ArticleTag> getPosttags() {
        return posttags;
    }

    public void setPosttags(List<ArticleTag> posttags) {
        this.posttags = posttags;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
