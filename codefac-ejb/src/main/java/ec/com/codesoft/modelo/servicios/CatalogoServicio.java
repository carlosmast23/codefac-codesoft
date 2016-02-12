/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.codesoft.modelo.servicios;

import ec.com.codesoft.model.CatalagoProducto;
import ec.com.codesoft.model.ProductoGeneralCompra;
import ec.com.codesoft.model.ProductoGeneralVenta;
import ec.com.codesoft.modelo.facade.CatalagoProductoFacade;
import ec.com.codesoft.modelo.facade.ProductoGeneralVentaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Suco
 */
@LocalBean
@Stateless
public class CatalogoServicio {

    @EJB
    private CatalagoProductoFacade catalogoFacade;

    @EJB
    private ProductoGeneralVentaFacade productoGeneralFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertar(CatalagoProducto catalogo) {
        //verifica si el producto es general o inididual
        this.catalogoFacade.create(catalogo);
        
        if (catalogo.getTipoProducto().toString().toUpperCase().equals("G")) {
            ProductoGeneralVenta productoGeneral = new ProductoGeneralVenta();
            productoGeneral.setCantidadBaja(0);
            productoGeneral.setCantidadCaducada(0);
            productoGeneral.setCantidadDisponible(0);
            productoGeneral.setCantidadRobado(0);
            productoGeneral.setCantidadVendida(0);
            productoGeneral.setCatalagoProducto(catalogo);    
           // productoGeneral.setCodigoProducto(catalogo.getCodigoProducto());
            //productoGeneral.setCodigo(Integer.SIZE);
           // System.out.println("CODIGO: "+productoGeneral.getCodigoProducto()); 
           this.productoGeneralFacade.create(productoGeneral);
           
           catalogo.setProductoGeneralVenta(productoGeneral);
        }
        
       // this.catalogoFacade.refresh(catalogo);
        
    }
    
    public void agregarCantidadProductoGeneral(ProductoGeneralVenta producto,int cantidad)
    {
        producto.agregarProductos(cantidad);
        productoGeneralFacade.edit(producto);
    }

    public void actualizar(CatalagoProducto catalogo) {
        catalogoFacade.edit(catalogo);
    }

    public void eliminar(CatalagoProducto catalogo) {
        catalogoFacade.remove(catalogo);
    }

    public List<CatalagoProducto> obtenerTodos() {

        return catalogoFacade.findAll();
    }

    public CatalagoProducto buscarCatalogo(String codigoP) {
        return catalogoFacade.findCatalogo(codigoP);

    }

}
