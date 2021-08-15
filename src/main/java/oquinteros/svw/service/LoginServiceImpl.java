package oquinteros.svw.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import oquinteros.svw.dato.LoginDao;
import oquinteros.svw.domain.Users;

@Stateless
public class LoginServiceImpl implements LoginService{
  
    
    EntityManager em;
    @Inject
    private LoginDao loginDao;

    @Override
    public Users encontrarVendedorPorId(String nombreVendedor) {
     return loginDao.findUserLogin(nombreVendedor);
    }
}
