/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.codesoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Suco
 */
@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_COMPRA")
    private Integer codigoCompra;
   // @Size(max = 64)
    @Column(name = "CODIGO_DOCUMENTO")
    private String codigoDocumento;
    //@Size(max = 64)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;
    @JoinColumn(name = "RUC", referencedColumnName = "RUC")
    @ManyToOne
    private Distribuidor ruc;
    @JoinColumn(name = "CODIGO_PERIDO", referencedColumnName = "CODIGO_PERIDO")
    @ManyToOne
    private PeriodoContable codigoPerido;
    @JoinColumn(name = "NICK", referencedColumnName = "NICK")
    @ManyToOne
    private Usuario nick;
    @OneToMany(mappedBy = "codigoCompra")
    private List<ProductoIndividualCompra> productoIndividualCompraList;
    @OneToMany(mappedBy = "codigoCompra")
    private List<ProductoGeneralCompra> productoGeneralCompraList;

    public Compra() {
      
    }
    public void llenarCampos() {
        this.codigoCompra=0;
        this.codigoDocumento="";
        this.codigoPerido=null;
        this.descuento=new BigDecimal("0.0f");
        this.fecha=new Date();
        this.nick=null;
        this.ruc=null;
        this.tipoDocumento="";
        this.total=new BigDecimal("0.0f");
    }

    public Compra(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Integer getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(Integer codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Distribuidor getRuc() {
        return ruc;
    }

    public void setRuc(Distribuidor ruc) {
        this.ruc = ruc;
    }

    public PeriodoContable getCodigoPerido() {
        return codigoPerido;
    }

    public void setCodigoPerido(PeriodoContable codigoPerido) {
        this.codigoPerido = codigoPerido;
    }

    public Usuario getNick() {
        return nick;
    }

    public void setNick(Usuario nick) {
        this.nick = nick;
    }

    public List<ProductoIndividualCompra> getProductoIndividualCompraList() {
        return productoIndividualCompraList;
    }

    public void setProductoIndividualCompraList(List<ProductoIndividualCompra> productoIndividualCompraList) {
        this.productoIndividualCompraList = productoIndividualCompraList;
    }

    public List<ProductoGeneralCompra> getProductoGeneralCompraList() {
        return productoGeneralCompraList;
    }

    public void setProductoGeneralCompraList(List<ProductoGeneralCompra> productoGeneralCompraList) {
        this.productoGeneralCompraList = productoGeneralCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCompra != null ? codigoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.codigoCompra == null && other.codigoCompra != null) || (this.codigoCompra != null && !this.codigoCompra.equals(other.codigoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.codesoft.model.Compra[ codigoCompra=" + codigoCompra + " ]";
    }
    
}
