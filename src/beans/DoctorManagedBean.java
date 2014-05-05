package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.DB1SessionBeanLocal;
import ejb.ExperimentalSessionBean;
import ejb.OtherSessionBeanLocal;
import model.Doctor;
import model.Doctordata;
import model.Speciality;

@Named("doctorMB")
@SessionScoped
public class DoctorManagedBean implements Serializable {
	
	@EJB
	private OtherSessionBeanLocal localbean;

    @EJB
    private DB1SessionBeanLocal db1bean;

    @EJB
    private ExperimentalSessionBean exp;
	
	private int specialityId;
	
	private String surname;
	
	private String name;
	
	private String patronymic;
	
	private Speciality speciality;
	
	private String schedule;
	
	private String address;
	
	private String phoneNumber;
	
	private Date dateOfBirth;
	
	@Inject
	private SpecialityManagedBean specialityMB;
	
	private List<Doctor> listOfDoctors;
	
	private Speciality selectedSpeciality;
	
	private Doctor selectedDoctor;
	
	public String showDoctorsBySpeciality(Speciality speciality){
		listOfDoctors = specialityMB.getDao().getListOfDoctorsBySpeciality(speciality);
		selectedSpeciality = speciality;
		return "doctorsOfSpecialities";
	}

	public String showInfo(Doctor doctor){
		selectedDoctor = doctor;
		return "infoAboutDoctor";
	}

	public String deleteDoctor(Doctor doctor){
		db1bean.deleteDoctor(doctor);
		return showDoctorsBySpeciality(selectedSpeciality);
	}

	public String goToAddDoctor(){
		specialityMB.setListOfSpecialities(specialityMB.getDao().getListOfSpecialities());
		return "addDoctor";
	}

    public void resetFields(){
        surname = "";
        name = "";
        patronymic = "";
        speciality = null;
        schedule = "";
        dateOfBirth = null;
        address = "";
        phoneNumber = "";
    }

	public String addDoctorEx1(){
		Doctor doctor = new Doctor(surname, name, patronymic, schedule, dateOfBirth);
		Doctordata data = new Doctordata(address, phoneNumber, 0);
		exp.experimentN1(doctor, data, specialityId);
        resetFields();
		return showDoctorsBySpeciality(selectedSpeciality);
	}

	public String addDoctorEx2(){
		Doctor doctor = new Doctor(surname, name, patronymic, schedule, dateOfBirth);
		Doctordata data = new Doctordata(address, phoneNumber, 0);
		exp.experimentN2(doctor, data, specialityId);
        resetFields();
		return showDoctorsBySpeciality(selectedSpeciality);
	}

    public String addDoctorEx3(){
        Doctor doctor = new Doctor(surname, name, patronymic, schedule, dateOfBirth);
        Doctordata data = new Doctordata(address, phoneNumber, 0);
        exp.experimentN3(doctor, data, specialityId);
        resetFields();
        return showDoctorsBySpeciality(selectedSpeciality);
    }

    public String addDoctorEx4(){
        Doctor doctor = new Doctor(surname, name, patronymic, schedule, dateOfBirth);
        Doctordata data = new Doctordata(address, phoneNumber, 0);
        exp.experimentN4(doctor, data, specialityId);
        resetFields();
        return showDoctorsBySpeciality(selectedSpeciality);
    }

    public String addDoctorEx5(){
        Doctor doctor = new Doctor(surname, name, patronymic, schedule, dateOfBirth);
        Doctordata data = new Doctordata(address, phoneNumber, 0);
        exp.experimentN5(doctor, data, specialityId);
        resetFields();
        return showDoctorsBySpeciality(selectedSpeciality);
    }

	public List<Doctor> getListOfDoctors() {
		return listOfDoctors;
	}

	public void setListOfDoctors(List<Doctor> listOfDoctors) {
		this.listOfDoctors = listOfDoctors;
	}

	public Speciality getSelectedSpeciality() {
		return selectedSpeciality;
	}

	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(int specialityId) {
		this.specialityId = specialityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
