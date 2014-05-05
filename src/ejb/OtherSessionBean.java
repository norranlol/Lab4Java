package ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;

import model.Doctor;
import model.Speciality;

@Stateless
public class OtherSessionBean extends AbstractFacade<Speciality> implements OtherSessionBeanLocal {
	
    @PersistenceContext(unitName = "Hospitalx1")
    private EntityManager em;
    
	public OtherSessionBean(Class<Speciality> entityClass) {
		super(entityClass);
	}

	public OtherSessionBean(){}
	
	@Override
	public List<Speciality> getListOfSpecialities(){
        CriteriaQuery<Speciality> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Speciality.class);
        criteriaQuery.select(criteriaQuery.from(Speciality.class));
        List<Speciality> listOfSpecs = getEntityManager().createQuery(criteriaQuery).getResultList();
        return listOfSpecs;
	}

    @Override
    public List<Doctor> getListOfDoctorsBySpeciality(Speciality speciality){
        Speciality spec = em.find(Speciality.class, speciality.getId());
        return spec.getDoctors();
    }

    @Override
    public void addSpeciality(Speciality speciality){
        create(speciality);
    }

    @Override
    public void deleteSpeciality(Speciality speciality){
        remove(speciality);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
