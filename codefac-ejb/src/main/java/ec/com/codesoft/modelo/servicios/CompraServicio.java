/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.codesoft.modelo.servicios;

import ec.com.codesoft.model.Compra;
import ec.com.codesoft.model.PeriodoContable;
import ec.com.codesoft.model.ProductoGeneralCompra;
import ec.com.codesoft.model.ProductoIndividualCompra;
import ec.com.codesoft.modelo.facade.CompraFacade;
import ec.com.codesoft.modelo.facade.PeriodoContableFacade;
import ec.com.codesoft.modelo.facade.ProductoGeneralCompraFacade;
import ec.com.codesoft.modelo.facade.ProductoIndividualCompraFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Suco
 */
@LocalBean
@Stateless
public class CompraServicio {

    @EJB
    CompraFacade compraFacade;

    @EJB
    PeriodoContableFacade periodoFacade;
    
    @EJB
    ProductoGeneralCompraFacade productoGFacade;
    
    @EJB
    ProductoIndividualCompraFacade productoEspeFacade;

    public void insertar(Compra compra) 
    {
        this.compraFacade.create(compra);
        Integer codigo=compra.getCodigoCompra();
        List<ProductoGeneralCompra> detalle1=compra.getProductoGeneralCompraList();
        List<ProductoIndividualCompra> detalle2=compra.getProductoIndividualCompraList();
        System.out.println(compraFacade);
        //Detalle General Actualizado        
        for (ProductoGeneralCompra detalle : detalle1) 
        {
            detalle.setCodigoCompra(compra);
            productoGFacade.edit(detalle);
        }
        
        //Detalle Especifico Actualizado
        for (ProductoIndividualCompra detalle : detalle2) {
            detalle.setCodigoCompra(compra);
            productoEspeFacade.edit(detalle);
        }
                
        
    }

    public void actualizar(Compra compra) {
        compraFacade.edit(compra);
    }

    public void eliminar(Compra compra) {
        compraFacade.remove(compra);
    }

    public PeriodoContable findPeriodo() {

        return periodoFacade.find("1");
    }

    public PeriodoContable buscar() {
        
        return periodoFacade.find(new Integer(1));
    }
    public void registrarProductoGeneral(ProductoGeneralCompra producto){
        
        productoGFacade.create(producto);
        
    }
    
    public void registrarProductoEspecifico(ProductoIndividualCompra productoEspecifico){
        
        productoEspeFacade.create(productoEspecifico);
    }
    
    
    

}
