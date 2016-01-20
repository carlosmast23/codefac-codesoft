/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.codesoft.web.seguridad;

import ec.com.codesoft.modelo.Usuario;
import ec.com.codesoft.modelo.servicios.SeguridadServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.websocket.Session;

/**
 *
 * @author carlo
 */
@ManagedBean
@SessionScoped
public class SessionMB implements Serializable {

    /**
     * Nick del usuario que intenta loguearse
     */
    private String nick;
    /**
     * Clave del usuario que intenta loguearse
     */
    private String clave;
    /**
     * Referencia al objeto que se encuentra logueado en el sistema
     */
    private Usuario usuarioLogin;

    private Session session;
    private Transaction transaccion;

    @EJB
    private SeguridadServicio seguridadServicio;

    public SessionMB() {
        HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(7200);
    }

    @PostConstruct
    private void postConstruct() {
        usuarioLogin = new Usuario();
    }

    public String iniciarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usuarioAux = seguridadServicio.loguear(nick, clave);
        //System.out.println("Entro");
        if (usuarioAux != null) {
            //System.out.println("Usuario encontrado");
            //System.out.println(usuarioAux.getNick());
            context.addMessage(null, new FacesMessage("Bienvenido al Sistema Codefac", "!Buen dia!"));
            this.usuarioLogin = usuarioAux;

            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("usuario", this.usuarioLogin);
            
            switch(usuarioLogin.getTipo())
            {
                case "admin":
                    return "/admin/cliente.xhtml";
                    
                
                case "operador":
                    return "/operador/index.xhtml";
            }
            
        }
        this.nick=null;
        this.clave=null;
        context.addMessage(null, new FacesMessage("Los datos ingresados son incorrectos", "!Vuelva a intentar!"));
        return "login";

    }

    public String cerrarSesion() 
    {
        System.out.println("cerrar sesion");
        this.nick = null;
        this.clave = null;

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();

        return "/login.xhtml";
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public SeguridadServicio getSeguridadServicio() {
        return seguridadServicio;
    }

    public void setSeguridadServicio(SeguridadServicio seguridadServicio) {
        this.seguridadServicio = seguridadServicio;
    }

}