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
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_FACTURA")
    private Integer codigoFactura;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Size(max = 16)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 16)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Size(max = 16)
    @Column(name = "TIPO_PAGO")
    private String tipoPago;
    @Size(max = 16)
    @Column(name = "TIPO_VENTA")
    private String tipoVenta;
    @Column(name = "DESCUENTO")
    private Integer descuento;
    @Column(name = "INCREMENTO")
    private Integer incremento;
    @OneToMany(mappedBy = "codigoFactura")
    private List<CreditoFactura> creditoFacturaList;
    @OneToMany(mappedBy = "codigoFactura")
    private List<DetalleProductoIndividual> detalleProductoIndividualList;
    @JoinColumn(name = "NICK", referencedColumnName = "NICK")
    @ManyToOne
    private Usuario nick;
    @JoinColumn(name = "CODIGO_PERIDO", referencedColumnName = "CODIGO_PERIDO")
    @ManyToOne
    private PeriodoContable codigoPerido;
    @JoinColumn(name = "CEDULA_RUC", referencedColumnName = "CEDULA_RUC")
    @ManyToOne
    private Cliente cedulaRuc;
    @OneToMany(mappedBy = "codigoFactura")
    private List<DetalleProductoGeneral> detalleProductoGeneralList;
    @OneToMany(mappedBy = "codigoFactura")
    private List<NotaCreditoDebito> notaCreditoDebitoList;
    @OneToMany(mappedBy = "codigoFactura")
    private List<DetallesServicio> detallesServicioList;

    public Venta() {
    }

    public Venta(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Integer getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Integer getIncremento() {
        return incremento;
    }

    public void setIncremento(Integer incremento) {
        this.incremento = incremento;
    }

    public List<CreditoFactura> getCreditoFacturaList() {
        return creditoFacturaList;
    }

    public void setCreditoFacturaList(List<CreditoFactura> creditoFacturaList) {
        this.creditoFacturaList = creditoFacturaList;
    }

    public List<DetalleProductoIndividual> getDetalleProductoIndividualList() {
        return detalleProductoIndividualList;
    }

    public void setDetalleProductoIndividualList(List<DetalleProductoIndividual> detalleProductoIndividualList) {
        this.detalleProductoIndividualList = detalleProductoIndividualList;
    }

    public Usuario getNick() {
        return nick;
    }

    public void setNick(Usuario nick) {
        this.nick = nick;
    }

    public PeriodoContable getCodigoPerido() {
        return codigoPerido;
    }

    public void setCodigoPerido(PeriodoContable codigoPerido) {
        this.codigoPerido = codigoPerido;
    }

    public Cliente getCedulaRuc() {
        return cedulaRuc;
    }

    public void setCedulaRuc(Cliente cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }

    public List<DetalleProductoGeneral> getDetalleProductoGeneralList() {
        return detalleProductoGeneralList;
    }

    public void setDetalleProductoGeneralList(List<DetalleProductoGeneral> detalleProductoGeneralList) {
        this.detalleProductoGeneralList = detalleProductoGeneralList;
    }

    public List<NotaCreditoDebito> getNotaCreditoDebitoList() {
        return notaCreditoDebitoList;
    }

    public void setNotaCreditoDebitoList(List<NotaCreditoDebito> notaCreditoDebitoList) {
        this.notaCreditoDebitoList = notaCreditoDebitoList;
    }

    public List<DetallesServicio> getDetallesServicioList() {
        return detallesServicioList;
    }

    public void setDetallesServicioList(List<DetallesServicio> detallesServicioList) {
        this.detallesServicioList = detallesServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFactura != null ? codigoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codigoFactura == null && other.codigoFactura != null) || (this.codigoFactura != null && !this.codigoFactura.equals(other.codigoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.codesoft.model.Venta[ codigoFactura=" + codigoFactura + " ]";
    }
    
}