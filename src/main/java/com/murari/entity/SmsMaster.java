package com.murari.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="SMS_MASTER")
public class SmsMaster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	
	@Column(name="MOB_NUM")
	private String mobileNumber;
	@Column(name="IN_STONE")
	@Type(type="yes_no")
	private boolean inStone;
	@Column(name="CNSMED_STONE")
	@Type(type="yes_no")
	private boolean consumedStone;
	@Column(name="POWDER")
	@Type(type="yes_no")
	private boolean powder;
	@Column(name="VALID_IND")
	@Type(type="yes_no")
	private boolean validIndicator;
	@Column(name="USER_ID")
	private String userId;
	@Column(name="UPDAT_DT")
	private Date updatedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isInStone() {
		return inStone;
	}
	public void setInStone(boolean inStone) {
		this.inStone = inStone;
	}
	public boolean isConsumedStone() {
		return consumedStone;
	}
	public void setConsumedStone(boolean consumedStone) {
		this.consumedStone = consumedStone;
	}
	public boolean isPowder() {
		return powder;
	}
	public void setPowder(boolean powder) {
		this.powder = powder;
	}
	public boolean isValidIndicator() {
		return validIndicator;
	}
	public void setValidIndicator(boolean validIndicator) {
		this.validIndicator = validIndicator;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
