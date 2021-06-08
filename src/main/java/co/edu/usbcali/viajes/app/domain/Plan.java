package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3622441444953382715L;

	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan" , nullable = false , unique = true)
	private Integer idPlan;
	
	@Column(name = "codigo" , nullable = false , unique = true , length = 5)
	private String codigo;
	
	@Column(name = "descripcion_solicitud" , length = 300)
	private String descripcionSolicitud;
	
	@Column(name = "nombre" , nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "cantidad_personas" , nullable = false)
	private Integer cantidadPersonas;
	
	@Column(name = "fecha_solicitud" , nullable = false)
	private Date fechaSolicitud;
	
	@Column(name = "fecha_inicio_viaje"	)
	private Date fechaInicioViaje;
	
	@Column(name = "fecha_fin_viaje")
	private Date fechaFinViaje;
	
	@Column(name = "valor_total" , nullable = false , length = 19)
	private Double valorTotal;
	
	@Column(name = "fecha_creacion" , nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion" )
	private Date fechaModificacion;
	
	@Column(name = "usu_creador" , nullable = false , length = 10)
	private String usuCreador;
	
	@Column(name = "usu_modificador" , length = 10)
	private String usuModificador;
	
	@Column(name = "estado" , nullable = false , length = 1)
	private String estado;
	
	@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "id_clie" , nullable = false)
	private Cliente idClie;
	
	@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usua" , nullable = false)
	private Usuario idUsua;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "idPlan" , cascade = CascadeType.ALL)
	private List<DetallePlan> detallePlan = new ArrayList<>();

	// Constructor
	public Plan() {
		super();
	}

	// Constructor sobrecargado
	

	

	public Plan(Integer idPlan, String codigo, String descripcionSolicitud, String nombre, Integer cantidadPersonas,
			Date fechaSolicitud, Date fechaInicioViaje, Date fechaFinViaje, Double valorTotal, Date fechaCreacion,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado, Cliente idClie,
			Usuario idUsua) {
		super();
		this.idPlan = idPlan;
		this.codigo = codigo;
		this.descripcionSolicitud = descripcionSolicitud;
		this.nombre = nombre;
		this.cantidadPersonas = cantidadPersonas;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioViaje = fechaInicioViaje;
		this.fechaFinViaje = fechaFinViaje;
		this.valorTotal = valorTotal;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.idClie = idClie;
		this.idUsua = idUsua;
	}
	
	public Integer getIdPlan() {
		return idPlan;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
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

	public Cliente getIdClie() {
		return idClie;
	}

	public void setIdClie(Cliente idClie) {
		this.idClie = idClie;
	}

	public Usuario getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Usuario idUsua) {
		this.idUsua = idUsua;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

  

	
	

}
