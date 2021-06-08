package co.edu.usbcali.viajes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion , Integer> {
	    
	    //buscar por estado y ordenar por el codigo 
        public List<TipoIdentificacion> findByEstadoOrderByCodigoAsc(String estado);
        
        public TipoIdentificacion findByCodigo(String codigo);
        
        
}
