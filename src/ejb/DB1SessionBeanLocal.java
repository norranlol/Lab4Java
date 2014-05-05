package ejb;

import model.Doctor;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface DB1SessionBeanLocal {
    public void deleteDoctor(Doctor doctor);
    public void createDoctorExp1(Doctor doctor);
    public EntityManager getEntityManager();
    public void createDoctorExp2(Doctor doctor);
    public void createDoctorExp5(Doctor doctor);
}
