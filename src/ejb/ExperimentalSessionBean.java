package ejb;

import model.Doctor;
import model.Doctordata;
import model.Speciality;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ExperimentalSessionBean {

    @EJB
    private DB1SessionBeanLocal db1;

    @EJB
    private DB2SessionBeanLocal db2;

    public void experimentN1(Doctor doctor, Doctordata doctordata, int specialityId){
        Speciality spec = db1.getEntityManager().find(Speciality.class,specialityId);
        doctor.setSpeciality(spec);
        db1.createDoctorExp1(doctor);
        doctordata.setDoctorId(5);
        db2.createDoctorDataExp1(doctordata);
    }

    public void experimentN2(Doctor doctor, Doctordata doctordata, int specialityId){
        Speciality spec = db1.getEntityManager().find(Speciality.class,specialityId);
        doctor.setSpeciality(spec);
        doctordata.setDoctorId(5);
        db2.createDoctorDataExp1(doctordata);
        db1.createDoctorExp2(doctor);
    }

    public void experimentN3(Doctor doctor, Doctordata doctordata, int specialityId){
        Speciality spec = db1.getEntityManager().find(Speciality.class,specialityId);
        doctor.setSpeciality(spec);
        doctordata.setDoctorId(5);
        db1.createDoctorExp1(doctor);
        db2.createDoctorDataExp3(doctordata);
    }

    public void experimentN4(Doctor doctor, Doctordata doctordata, int specialityId){
        Speciality spec = db1.getEntityManager().find(Speciality.class,specialityId);
        doctor.setSpeciality(spec);
        doctordata.setDoctorId(5);
        db2.createDoctorDataExp4(doctordata);
        db1.createDoctorExp2(doctor);
    }

    public void experimentN5(Doctor doctor, Doctordata doctordata, int specialityId){
        Speciality spec = db1.getEntityManager().find(Speciality.class,specialityId);
        doctor.setSpeciality(spec);
        doctordata.setDoctorId(5);
        db1.createDoctorExp5(doctor);
        db2.createDoctorDataExp3(doctordata);
    }
}
