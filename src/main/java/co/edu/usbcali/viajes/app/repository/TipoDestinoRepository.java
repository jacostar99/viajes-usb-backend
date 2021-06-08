package co.edu.usbcali.viajes.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.TipoDestino;

public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Integer>{
	
	//Consultar los registros donde la fecha de creacion este en un rango
	public List <TipoDestino> findByFechaCreacionBetween(Date fechaInicio , Date fechaFin); 
	
	
    public TipoDestino findByCodigo(String codigo);
    
    public TipoDestino findByNombre(String nombre);
}
