package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.usbcali.viajes.app.dto.ClienteDTO;

import javax.persistence.ColumnResult;


//Plural porque se van a agrupar todos nnq,arreglo

@NamedNativeQueries({           
	                      //el mismo nombre del name que puse en el orm, query vacio porque ya esta en el orm
		@NamedNativeQuery(name="Cliente.consultaOrm" ,query="" ,resultSetMapping="consultaOrm")
})

//Donde se pone el resultado,arreglo
@SqlResultSetMappings({    //el mismo nombre del resultsetmapping para enlazarlo, se mapea en un DTO = objeto de trasferencia de datos --> donde se tienen los atributos de una clase para mapear
	@SqlResultSetMapping( name="consultaOrm",
			
		/*para que tome el constructor del DTO le indico target = clase a donde se va a mapear, los pongo en el mismo orden del constructor
		de ClienteDTO porque si no tira error*/
			classes = {@ConstructorResult(targetClass=ClienteDTO.class, 
			
			   columns = { //mismo nombre los alias
					   @ColumnResult(name="numeroIdentificacion" , type=String.class),
					   @ColumnResult(name="nombre" , type= String.class),
					   @ColumnResult(name="primerApellido" , type= String.class),
					   @ColumnResult(name="fechaNacimiento" , type= Date.class),
					   @ColumnResult(name="tiId" , type= Integer.class)
					   
			   })
			
			})
			
})

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clie" , nullable = false , unique = true)
	private Integer idClie;
	
	@Column(name = "numero_identificacion" , length = 15 , nullable = false , unique = true)
	private String numeroIdentificacion;
	
	@Column(name = "primer_apellido" , length = 100 , nullable = false)
	private String primerApellido;
	
	@Column(name = "segundo_apellido" , length = 100)
	private String segundoApellido;
	
	@Column(name = "nombre" , length = 100 , nullable = false)
	private String nombre;
	
	@Column(name = "telefono1" , length = 15)
	private String telefono1;
	
	@Column(name = "telefono2" , length = 15)
	private String telefono2;
	
	@Column(name = "correo" , length = 100)
	private String correo;
	
	@Column(name = "sexo" , length = 1 , nullable = false)
	private String sexo;
	
	@Column(name = "fecha_nacimiento" , nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "fecha_creacion" , nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "usu_creador" , length = 10 , nullable = false)
	private String usuCreador;
	
	@Column(name = "usu_modificador" , length = 10)
	private String usuModificador;
	
	@Column(name = "estado" , length = 1 , nullable = false)
	private String estado;
	
	@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tiid" , nullable = false)
	private TipoIdentificacion tiId;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "idClie" , cascade = CascadeType.ALL)
	private List<Plan> plan = new ArrayList<>();
	
	//Constructor 
	public Cliente() {
		super();
	}
	
	
    //Constructor sobrecargado
	public Cliente(Integer idClie, String numeroIdentificacion, String primerApellido, String segundoApellido,
			String nombre, String telefono1, String telefono2, String correo, String sexo, Date fechaNacimiento,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado, TipoIdentificacion tiId) {
		super();
		this.idClie = idClie;
		this.numeroIdentificacion = numeroIdentificacion;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.nombre = nombre;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo = correo;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.tiId = tiId;
	}
    
	
	//Getters and setters
	public Integer getIdClie() {
		return idClie;
	}

	public void setIdClie(Integer idClie) {
		this.idClie = idClie;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
    
	

	public TipoIdentificacion getTiId() {
		return tiId;
	}


	public void setTiId(TipoIdentificacion tiId) {
		this.tiId = tiId;
	}
    
	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
    
	







	/**
	 * 
	 */
	private static final long serialVersionUID = 6923403067888599359L;
	
	

}
