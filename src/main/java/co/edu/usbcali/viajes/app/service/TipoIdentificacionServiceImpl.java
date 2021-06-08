package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {
    
	@Autowired
	TipoIdentificacionRepository tipoIdentificacionRepository;
	
	
	@Override
	public void eliminarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception {		
		if(tipoIdentificacion == null || tipoIdentificacion.getIdTiid()== null) {
			throw new Exception("Se debe ingresar un tipo de identificacion a eliminar");
		}
		
		Optional <TipoIdentificacion> tipoIdentificacionDB = tipoIdentificacionRepository.findById(tipoIdentificacion.getIdTiid());
		
		if(tipoIdentificacionDB.isPresent()) {
			tipoIdentificacionRepository.delete(tipoIdentificacionDB.get());
		} else {  
		throw new Exception("No existe un tipo de identificacion con ese id.");
		}

	}

	@Override
	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception {
		

		if(tipoIdentificacion == null) {
			throw new Exception("Ingrese un tipo de identificacion valido");
		}
		
		if(tipoIdentificacion.getFechaModificacion() == null) {
			throw new Exception("Ingrese una fecha de modificacion valida.");
		}
		
		if (tipoIdentificacion.getIdTiid() == null) {
			throw new Exception("Debe ingesar un id de tipo identificacion valido para actualizar");
		}
		
		Optional <TipoIdentificacion> tipoIdentificacionBD = tipoIdentificacionRepository.findById(tipoIdentificacion.getIdTiid());
		if(tipoIdentificacionBD.isEmpty()) {
			throw new Exception("No existe un tipo de identificacion con este id");
		}
		
		if(tipoIdentificacion.getCodigo() == null || tipoIdentificacion.getCodigo().trim().equals("")) {
			throw new Exception("Ingrese un codigo valido.");
			
		}
		if(tipoIdentificacion.getNombre() == null || tipoIdentificacion.getNombre().trim().equals("")) {
			throw new Exception("Ingrese un nombre valido.");
			
		}
		if(tipoIdentificacion.getFechaCreacion() == null) {
			throw new Exception("Ingrese una fecha de creacion valida.");
			
		}
		if(tipoIdentificacion.getUsuCreador() == null || tipoIdentificacion.getUsuCreador().trim().equals("")) {
			throw new Exception("Ingrese un usuario creador valido.");
			
		}
		if(tipoIdentificacion.getEstado() == null || tipoIdentificacion.getEstado().trim().equals("")) {
			throw new Exception("Ingrese un estado valido.");
			
		}
				
		if (tipoIdentificacion.getUsuModificador() == null || tipoIdentificacion.getUsuModificador().equals("") || tipoIdentificacion.getUsuModificador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario modificador valido.");
		}

		tipoIdentificacionRepository.save(tipoIdentificacion);
		
	}

	@Override
	public List<TipoIdentificacion> consultarTipoIdentificacion() throws Exception {
		List<TipoIdentificacion> listTipoIdentificacion = tipoIdentificacionRepository.findAll();

		if (listTipoIdentificacion.isEmpty()) {
			throw new Exception("No se encontraron tipos de identificacion en el sistema.");

		}
		return listTipoIdentificacion;
		
	}

	@Override
	public Optional<TipoIdentificacion> consultarTipoIdentificacionPorCodigo(Integer id) throws Exception {
		return tipoIdentificacionRepository.findById(id);
	}

	@Override
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception {
		
		if(tipoIdentificacion == null) {
			throw new Exception("Ingrese un tipo de identificacion valido");
		}
		
		TipoIdentificacion tipoIdentificacionDB = tipoIdentificacionRepository.findByCodigo(tipoIdentificacion.getCodigo().trim());
		if (tipoIdentificacionDB != null) {
			throw new Exception("Ya existe un tipo de identificacion con este codigo");
		}
		
		if(tipoIdentificacion.getCodigo() == null || tipoIdentificacion.getCodigo().trim().equals("")) {
			throw new Exception("Ingrese un codigo valido.");
			
		}
		if(tipoIdentificacion.getNombre() == null || tipoIdentificacion.getNombre().trim().equals("")) {
			throw new Exception("Ingrese un nombre valido.");
			
		}
		if(tipoIdentificacion.getFechaCreacion() == null) {
			throw new Exception("Ingrese una fecha de creacion valida.");
			
		}
		if(tipoIdentificacion.getUsuCreador() == null || tipoIdentificacion.getUsuCreador().trim().equals("")) {
			throw new Exception("Ingrese un usuario creador valido.");
			
		}
		if(tipoIdentificacion.getEstado() == null || tipoIdentificacion.getEstado().trim().equals("")) {
			throw new Exception("Ingrese un estado valido.");
			
		}
		
		tipoIdentificacionRepository.save(tipoIdentificacion);
	
	}

	@Override
	public TipoIdentificacion consultarTipoIdentificacionPorCod(String codigo) throws Exception {
		TipoIdentificacion ti = tipoIdentificacionRepository.findByCodigo(codigo);
		if(ti == null) {
			throw new Exception ("No existe ningun tipo de identificacion con este codigo.");
		}
		return ti;
		
	}
	
	@Override
	public Optional<TipoIdentificacion> consultarTipoIdentificacionPorId(Integer idTi) throws Exception {
		Optional <TipoIdentificacion> tis= tipoIdentificacionRepository.findById(idTi);
		if(tis == null) {
			throw new Exception ("No existe ningun tipo de identificacion con esta identificacion.");
		}
		return tis;
		
	}
	
	

}
