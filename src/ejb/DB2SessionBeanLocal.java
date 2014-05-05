package ejb;

import model.Doctordata;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface DB2SessionBeanLocal {
    public void createDoctorDataExp1(Doctordata data);
    public EntityManager getEntityManager();
    public void createDoctorDataExp3(Doctordata doctordata);
    public void createDoctorDataExp4(Doctordata doctordata);
}
