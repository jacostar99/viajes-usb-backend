package co.edu.usbcali.viajes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.edu.usbcali.viajes.app.domain.Destino;

//para repositorios es interfaz, que extienda de jpa repository, tambien puede extender(heredar)
//de crud repository, el primer parametro es la clase, y lo segundo es el tipo de dato del id de esa clase
//JpaRepository tiene los metodos que me permite grabar,actualizar, buscar etc

//Crud repository tiene las acciones para hacer un crud
//Jpa repository tambien tiene estas acciones y otras adicionales 

//Repositorios los que se van a comunicar con la base de datos para realizar las acciones correspondientes
public interface DestinoRepository extends JpaRepository<Destino , Integer > {
	
	//VALIDANDO CON LLAVE FORANEA
	//Consultar los destinos donde el tipo de destino tenga un codigo, En destino llega una foranea que es el tipo de destino
	//Al decirle le estoy diciendo que en TipoDestino (que es una foranea) me tenga en cuenta el codigo de esa clase TipoDestino
	public List<Destino> findByTipoDestino_Codigo(String codigo);
	
	public Destino findByCodigo(String codigo);

}
