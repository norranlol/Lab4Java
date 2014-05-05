package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctordata database table.
 * 
 */
@Entity
@NamedQuery(name="Doctordata.findAll", query="SELECT d FROM Doctordata d")
public class Doctordata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String phoneNumber;
	
	private int doctorId;

	public Doctordata() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public Doctordata(String address, String phoneNumber, int doctorId){
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.doctorId = doctorId;
	}
}