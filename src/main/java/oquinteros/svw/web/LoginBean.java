package oquinteros.svw.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import oquinteros.svw.domain.Users;
import oquinteros.svw.service.LoginService;


@Named("loginBean")
@RequestScoped
public class LoginBean {
    
    @Inject
    private LoginService loginService;
    private Users vendedor;

    public Users getVendedor() {
        return vendedor;
    }

    public void setVendedor(Users vendedor) {
        this.vendedor = vendedor;
    }
    
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String autenticar(){
        vendedor = loginService.encontrarVendedorPorId(email);
        if (vendedor!=null) {
            if (vendedor.getPassword().equals(this.password)) {
               return "formPrincipal" + "?faces-redirect=true"; 
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario y/o password Incorrecto", ""));
        return null;
    }
}
