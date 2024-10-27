package com.citizen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citizen {
	
	@Id
	private String citizenId
	private String citizenName;
	private String vaccinationCenterId;
	private String vaccinationCenterAddress;
	private String vaccineName;
	public Citizen() {
		super();
	}
	public Citizen(String citizenId, String citizenName, String vaccinationCenterId, String vaccinationCenterAddress,
			String vaccineName) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.vaccinationCenterId = vaccinationCenterId;
		this.vaccinationCenterAddress = vaccinationCenterAddress;
		this.vaccineName = vaccineName;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getVaccinationCenterId() {
		return vaccinationCenterId;
	}
	public void setVaccinationCenterId(String vaccinationCenterId) {
		this.vaccinationCenterId = vaccinationCenterId;
	}
	public String getVaccinationCenterAddress() {
		return vaccinationCenterAddress;
	}
	public void setVaccinationCenterAddress(String vaccinationCenterAddress) {
		this.vaccinationCenterAddress = vaccinationCenterAddress;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", citizenName=" + citizenName + ", vaccinationCenterId="
				+ vaccinationCenterId + ", vaccinationCenterAddress=" + vaccinationCenterAddress + ", vaccineName="
				+ vaccineName + ", getCitizenId()=" + getCitizenId() + ", getCitizenName()=" + getCitizenName()
				+ ", getVaccinationCenterId()=" + getVaccinationCenterId() + ", getVaccinationCenterAddress()="
				+ getVaccinationCenterAddress() + ", getVaccineName()=" + getVaccineName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
