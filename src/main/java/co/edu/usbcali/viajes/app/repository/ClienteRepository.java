package co.edu.usbcali.viajes.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
	//buscar por el numero de identificacion
	public Cliente findByNumeroIdentificacion(String numeroIdentificacion);
	
	//buscar por el correo
	public Cliente findByCorreo(String correo);
	
	//buscar por estado 
	public List <Cliente> findByEstado(String estado);
	
	//buscar por el nombre con like
	public List <Cliente> findByNombreLike(String nombre);
	
	
	
    //buscar y ordenar por identif
	public  Page <Cliente> findByEstadoOrderByNumeroIdentificacionAsc(Pageable pg,String estado); 
	
	//buscar cliente por fechaNacimiento ORM
	@Query(nativeQuery = true) 
	//los atributos que entran se lo paso como parametro al query con la anotacion @Param para enlazarlos al orm
	public List <ClienteDTO> consultaOrm(@Param("pFechaNacimiento")Date fechaNacimiento
			,@Param("pFechaNacimientoC")Date fechaNacimientoC ,@Param("pNumeroIdentificacion")String numeroIdentificacion
			,@Param("pCodigo")String codigoIden);
}
