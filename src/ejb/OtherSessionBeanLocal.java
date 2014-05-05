package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Doctor;
import model.Speciality;

@Local
public interface OtherSessionBeanLocal {
	public List<Speciality> getListOfSpecialities();
    public void addSpeciality(Speciality speciality);
    public void deleteSpeciality(Speciality speciality);
    public List<Doctor> getListOfDoctorsBySpeciality(Speciality speciality);
}
