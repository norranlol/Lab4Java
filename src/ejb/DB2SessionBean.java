package ejb;

import model.Doctordata;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DB2SessionBean extends AbstractFacade<Doctordata> implements DB2SessionBeanLocal{

    @PersistenceContext(unitName = "Hospitalx2")
    private EntityManager em;

    public DB2SessionBean(){}

    @Resource
    private EJBContext ejbContext;

    public DB2SessionBean(Class<Doctordata> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createDoctorDataExp1(Doctordata data){
        create(data);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createDoctorDataExp3(Doctordata doctordata){
        create(doctordata);
        ejbContext.setRollbackOnly();
        throw new EJBException();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void createDoctorDataExp4(Doctordata doctordata){
        create(doctordata);
    }
}
