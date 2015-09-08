/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "wed_notifications")
public class Notifications implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationid;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", length = 50)
    private NotificationType notificationType;
    @Column(length = 1000)
    private String link;
    @Column(length = 1000)
    private String imageurl;
    @Column(length = 1000)
    private String message;
    @Column(length = 1000)
    private String title;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdon;
    @OneToOne
    private AppUser appuser;
    private boolean enabled;
    
    public Notifications() {
    }

    public Notifications(NotificationType notificationType, String link, String imageurl, String message, String title, Date createdon) {
        this.notificationType = notificationType;
        this.link = link;
        this.imageurl = imageurl;
        this.message = message;
        this.createdon = createdon;
        this.title = title;
    }

    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Long notificationid) {
        this.notificationid = notificationid;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public AppUser getAppuser() {
        return appuser;
    }

    public void setAppuser(AppUser appuser) {
        this.appuser = appuser;
    }

}
