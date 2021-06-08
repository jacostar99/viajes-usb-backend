package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Anotacion para decirle a java que esta entidad va a ser mapeada a una base de datos
@Table(name = "tipo_destino") // Anotacion para indicar exactamente el nombre de la tabla en la base de datos
						      // a la que va a ser mapeada esta entidad 

public class TipoDestino implements Serializable {

	private static final long serialVersionUID = -1606333543344966939L;

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tide" , unique = true , nullable = false) // Anotacion column para indicar que un atributo va a ser mapeado a un atributo de la tabla de la bd
	                          //el atributo idTide va a ser mapeado a este atributo de la tabla de la bd, tambien se puede indicar si el
	                          //atributo es nulo, si existe un limite de caracteres, si es un valor unico, etc otras restrcciones
	private Integer idTide;

	// El column name no es necesario ponerlo en estos casos en los que el nombre
	// del atributo de la clase es el mismo nombre
	// del atributo de la bd, pero por estandar y seguridad es mejor ponerlo
	@Column(name = "nombre", nullable = false, length = 100, unique = true)
	private String nombre;

	@Column(name = "codigo", nullable = false, length = 5, unique = true) //por defecto el nullable es true, y el unique es true 
	private String codigo;

	@Column(name = "descripcion", nullable = false, length = 300)
	private String descripcion;

	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;

	@Column(name = "usu_modificador", length = 10)
	private String usuModificador;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "tipoDestino")  //de uno a muchos,mapped ---> a que va a hacer referencia a tipoDestino
	//como es de uno a muchos va a ser una lista de java util
	private List<Destino> destino = new ArrayList<>(); //lista de destinos
	 

	// Constructor vacio
	public TipoDestino() {
		super();
	}

	// Constructor sobrecargado
	public TipoDestino(Integer idTide, String codigo, String descripcion, Date fechaCreacion, Date fechaModificacion,
			String usuCreador, String usuModificador, String estado, String nombre) {
		super();
		this.idTide = idTide;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.nombre = nombre;
	}

	public Integer getIdTide() {
		return idTide;
	}

	public void setIdTide(Integer idTide) {
		this.idTide = idTide;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	

}
