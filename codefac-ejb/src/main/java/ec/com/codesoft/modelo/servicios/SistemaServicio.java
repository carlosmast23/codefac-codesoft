/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.codesoft.modelo.servicios;

import ec.com.codesoft.model.Configuracion;
import ec.com.codesoft.modelo.facade.ConfiguracionFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@Stateless
@LocalBean
public class SistemaServicio implements Serializable
{
    @EJB
    private ConfiguracionFacade configuracionFacade;
    
    /**
     * Devolver la configuracion actual
     * 
     * @return 
     */
    public Configuracion getConfiguracion()
    {
        return configuracionFacade.findAll().get(0);
    }
}