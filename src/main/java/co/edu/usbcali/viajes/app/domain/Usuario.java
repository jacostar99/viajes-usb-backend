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

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4196332922842893937L;
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id_usua" , nullable = false , unique = true)
	private Integer idUsua;
	
	@Column(name = "login" , nullable = false , unique = true)
	private String login;
	
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Column(name = "nombre" , nullable = false)
	private String nombre;
	
	@Column(name = "identificacion" , nullable = false)
	private String identificacion;
	
	@Column(name = "fecha_creacion" , nullable = false	)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "usu_creador" , nullable = false , unique = true)
	private String usuCreador;
	
	@Column(name = "usu_modificador")
	private String usuModificador;
	
	@Column(name = "estado" , nullable = false)
	private String estado;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "idUsua")
	private List<Plan> plan = new ArrayList<>();
	
	
	//Constructor
	public Usuario() {
		super();
	}
    
	//Constructor sobrecargado
	public Usuario(Integer idUsua, String login, String password, String nombre, String identificacion,
			Date fechaCreacion, Date fechaModificacion, String usuCreador, String usuModificador, String estado) {
		super();
		this.idUsua = idUsua;
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
	}
    
	
	//Getters and setters
	public Integer getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
