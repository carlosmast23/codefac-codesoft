/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.codesoft.modelo.servicios;

import ec.com.codesoft.modelo.Usuario;
import ec.com.codesoft.modelo.facade.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Clase que contiene los servicios de seguridad
 *
 * @author carlos
 */
@Stateless
@LocalBean
public class SeguridadServicio {

    @EJB
    private UsuarioFacade usuarioFacade;

    public Usuario loguear(String nick, String clave)
    {
        return usuarioFacade.login(nick, clave);

    }

}
