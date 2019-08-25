package mainProjekt;

import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

/**
 * A DAO implementation for the {@link Company} class
 *
 * @author saifasif
 */
public class CompanyG extends GenericHibernate<Company, Serializable> {

    //private Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class);

    public  Company getACompanyByID(String id) {
        List<Company> resultList = findByCriteria(Restrictions.eq("Companyname", id));
        if (!resultList.isEmpty()) {
            return findByCriteria(Restrictions.eq("Companyname", id)).get(0);
        }
        return null;
    }

    public  List<Company> getAllCompanies() {
        return findAll();
    }

    public  List<Company> findByExample(Company exampleInstance) {
        return null;
    }


}