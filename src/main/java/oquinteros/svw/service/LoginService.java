package oquinteros.svw.service;

import javax.ejb.Local;
import oquinteros.svw.domain.Users;

@Local
public interface LoginService {
   
    
    public Users encontrarVendedorPorId(String nombreVendedor);
}
