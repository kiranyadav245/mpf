package com.murari.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAILY_STONE_IN")
public class StoneIn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
    private StoneInKey id;

//    @ManyToOne
//    @MapsId("qualityRangeId")
//    private QualityRange quality;
	@Column(name="STONE_IN_DATE")
	private Date inDate;
	@Column(name="STONE_IN_QTY")
	private double inQuantity;
	@Column(name="COMMENTS")
	private String comments;
	@Column(name="USER_ID")
	private int userId;
	
	public StoneInKey getId() {
		return id;
	}
	public void setId(StoneInKey id) {
		this.id = id;
	}
	/*public QualityRange getQuality() {
		return quality;
	}
	public void setQuality(QualityRange qualityRange) {
		this.quality = qualityRange;
	}*/
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public double getInQuantity() {
		return inQuantity;
	}
	public void setInQuantity(double inQuantity) {
		this.inQuantity = inQuantity;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
