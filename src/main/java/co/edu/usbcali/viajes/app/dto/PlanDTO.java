package co.edu.usbcali.viajes.app.dto;

import java.io.Serializable;
import java.util.Date;



public class PlanDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6351766502398418617L;


	private Integer idPlan;
	

	private String codigo;
	
	private String descripcionSolicitud;
	
	private String nombre;
	
	private Integer cantidadPersonas;
	
	private Date fechaSolicitud;
	
	private Date fechaInicioViaje;
	
	private Date fechaFinViaje;
	
	private double valorTotal;
	
	private Date fechaCreacion;
	
	private Date fechaModificacion;
	
	private String usuCreador;
	
	private String usuModificador;
	
	private String estado;
	
	private String numeroIdClie;
	
	private Integer idUsua;

	public PlanDTO() {
		super();
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaInicioViaje() {
		return fechaInicioViaje;
	}

	public void setFechaInicioViaje(Date fechaInicioViaje) {
		this.fechaInicioViaje = fechaInicioViaje;
	}

	public Date getFechaFinViaje() {
		return fechaFinViaje;
	}

	public void setFechaFinViaje(Date fechaFinViaje) {
		this.fechaFinViaje = fechaFinViaje;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuCreador() {
		return usuCreador;
	}

	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}

	public String getUsuModificador() {
		return usuModificador;
	}

	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroIdClie() {
		return numeroIdClie;
	}

	public void setNumeroIdClie(String numeroIdClie) {
		this.numeroIdClie = numeroIdClie;
	}

	public Integer getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}
	
	
	
	

}
