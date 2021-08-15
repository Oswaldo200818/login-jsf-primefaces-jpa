package oquinteros.svw.dato;
import oquinteros.svw.domain.Users;


public interface LoginDao {
    
    public Users findUserLogin(String nombreVendedor);
}
