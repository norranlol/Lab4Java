package ejb;

import model.Doctor;
import model.Speciality;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DB1SessionBean extends AbstractFacade<Doctor> implements DB1SessionBeanLocal {

    @PersistenceContext(unitName = "Hospitalx1")
    private EntityManager em;

    @Resource
    private SessionContext sessionContext;

    public DB1SessionBean(Class<Doctor> entityClass) {
        super(entityClass);
    }

    public DB1SessionBean(){}

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void deleteDoctor(Doctor doctor){
        remove(doctor);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createDoctorExp1(Doctor doctor){
        create(doctor);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createDoctorExp2(Doctor doctor){
        create(doctor);
        sessionContext.setRollbackOnly();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createDoctorExp5(Doctor doctor){
        create(doctor);
    }
}
