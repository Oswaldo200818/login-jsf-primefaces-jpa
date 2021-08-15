package oquinteros.svw.dato;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import oquinteros.svw.domain.Users;

@Stateless
public class LoginDaoImpl implements LoginDao{

    @PersistenceContext(unitName = "usuarioPU")
    EntityManager em;
    
    @Override
    public Users findUserLogin(String nombreVendedor) {
        Query q = em.createNamedQuery("Users.findByEmail", Users.class).setParameter("email", nombreVendedor);
        List<Users> listLogin = q.getResultList();
        
        if (!listLogin.isEmpty()) {
            return listLogin.get(0);
        }
        return null;
    }
    
}
