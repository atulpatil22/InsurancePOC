package com.example.insurance_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "insurancedata")
public class PersonInsuranceDetails {
 
    @Id
    @GeneratedValue
    private int id;

	private String memberid;
	private String planid;
 
    private String holdername;
   // private double claimamount;
    private String plan;
   // private boolean planselected;
 
    // Constructors
    public PersonInsuranceDetails() {
    	
    }

	/*public PersonInsuranceDetails(int id, String holdername, double claimamount, String plan, boolean planselected) {
	super();
		this.id = id;
		this.holdername = holdername;
		this.claimamount = claimamount;
		this.plan = plan;
		this.planselected = planselected;
	}*/


	public PersonInsuranceDetails(int id, String memberid, String planid, String holdername, String plan) {
		this.id = id;
		this.memberid = memberid;
		this.planid = planid;
		this.holdername = holdername;
		this.plan = plan;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	/*public double getClaimamount() {
		return claimamount;
	}*/

	/*public void setClaimamount(double claimamount) {
		this.claimamount = claimamount;
	}*/

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	/*public boolean isPlanselected() {
		return planselected;
	}*/
/*
	public void setPlanselected(boolean planselected) {
		this.planselected = planselected;
	}*/



	/*@Override
	public String toString() {
		return "PersonInsuranceDetails [id=" + id + ", holdername=" + holdername + ", claimamount=" + claimamount
				+ ", plan=" + plan + ", planselected=" + planselected + "]";
	}*/

	@Override
	public String toString() {
		return "PersonInsuranceDetails{" +
				"id=" + id +
				", memberid='" + memberid + '\'' +
				", planid='" + planid + '\'' +
				", holdername='" + holdername + '\'' +
				", plan='" + plan + '\'' +
				'}';
	}
}