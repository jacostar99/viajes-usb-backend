package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;

//los services llamen a los repositorys, los repositorys llaman a la bd..

@Service
//es una clase porque se va a implementar codigo del como se hace, a diferencia de la interface que al tener abstract methods no se debe 
//generar codigo
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	TipoDestinoRepository tipoDestinoRepository;

	// -------------------------------- Consultar los tipo de destino
	@Override
	public List<TipoDestino> consultarTipoDestino() throws Exception {

		List<TipoDestino> listTipoDestino = tipoDestinoRepository.findAll();

		if (listTipoDestino.isEmpty()) {
			throw new Exception("No se encontraron tipos de destino en el sistema.	");

		}
		return listTipoDestino;
	}

	// -------------------------------- Eliminar tipo destino
	@Override
	public void eliminarTipoDestino(TipoDestino tipoDestino) throws Exception{
		if(tipoDestino == null || tipoDestino.getIdTide()== null) {
			throw new Exception("Se debe ingresar un destino a eliminar");
		}
		
		Optional <TipoDestino> destinoDB = tipoDestinoRepository.findById(tipoDestino.getIdTide());
		
		if(destinoDB.isPresent()) {
			tipoDestinoRepository.delete(destinoDB.get());
		} else {  
		throw new Exception("No existe un tipo destino con ese id.");
		}


	}

	// -------------------------------- Actualizar los tipo destino
	@Override
	public void actualizarTipoDestino(TipoDestino tipoDestino) throws Exception {
		
		if (tipoDestino == null) {
			throw new Exception("Debe ingresar un tipo de destino.");
		}
		
		if (tipoDestino.getIdTide() == null) {
			throw new Exception("Debe ingresar id de tipo destino valido para actualizar.");
		}
		
		Optional <TipoDestino> tipoDestinoDB1 = tipoDestinoRepository.findById(tipoDestino.getIdTide());
		if(tipoDestinoDB1.isEmpty()) {
			throw new Exception("No existe un tipo destino con este id");
		}
			
		TipoDestino tipoDestinoDB = consultarTipoDestinoPorCod(tipoDestino.getCodigo());
		if (tipoDestinoDB == null ) {
			throw new Exception("No existe un tipo destino con este codigo");
		}

		if (tipoDestino.getNombre() == null || tipoDestino.getNombre().trim().equals("") || tipoDestino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre valido.");
		}

		if (tipoDestino.getDescripcion() == null || tipoDestino.getDescripcion().trim().equals("")
				|| tipoDestino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripcion valida.");
		}
		
		if (tipoDestino.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha valida.");
		}
		if (tipoDestino.getUsuCreador() == null || tipoDestino.getUsuCreador().trim().equals("")
				|| tipoDestino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario creador valido.");
		}
		if (tipoDestino.getEstado() == null || tipoDestino.getEstado().trim().equals("") || tipoDestino.getEstado().length() > 1) {
			throw new Exception("Debe ingresar una A o una I en este campo.");
		}

		if (tipoDestino.getCodigo() == null || tipoDestino.getCodigo().trim().equals("") || tipoDestino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un codigo valido.");
		}
        
		if (tipoDestino.getUsuModificador() == null || tipoDestino.getUsuModificador().trim().equals("") || tipoDestino.getUsuModificador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario modificador valido.");
		}

		tipoDestinoRepository.save(tipoDestino);
	}
    
	// -------------------------------- Guardar tipo destino
	@Override
	public void guardarTipoDestino(TipoDestino tipoDestino) throws Exception {
		if (tipoDestino == null) {
			throw new Exception("Debe ingresar un tipo de destino.");
		}
		
		TipoDestino tipoDestinoDB = tipoDestinoRepository.findByCodigo(tipoDestino.getCodigo().trim());
		if (tipoDestinoDB != null) {
			throw new Exception("Ya existe un destino con este codigo");
		}
		
		TipoDestino tipoDestinoDB1 = tipoDestinoRepository.findByNombre(tipoDestino.getNombre().trim());
		if (tipoDestinoDB1 != null) {
			throw new Exception("Ya existe un destino con este nombre");
		}

		if (tipoDestino.getNombre() == null || tipoDestino.getNombre().trim().equals("") || tipoDestino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre valido.");
		}

		if (tipoDestino.getDescripcion() == null || tipoDestino.getDescripcion().trim().equals("")
				|| tipoDestino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripcion valida.");
		}
		
		if (tipoDestino.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha valida.");
		}
		if (tipoDestino.getUsuCreador() == null || tipoDestino.getUsuCreador().trim().equals("")
				|| tipoDestino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario creador valido.");
		}
		if (tipoDestino.getEstado() == null || tipoDestino.getEstado().trim().equals("") || tipoDestino.getEstado().length() > 1) {
			throw new Exception("Debe ingresar una A o una I en este campo.");
		}

		if (tipoDestino.getCodigo() == null || tipoDestino.getCodigo().trim().equals("") || tipoDestino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un codigo valido.");
		}

		tipoDestinoRepository.save(tipoDestino);

	}

	// -------------------------------- Consultar los tipos destino por codigo
	@Override
	public Optional<TipoDestino> consultarTipoDestinoPorCodigo(Integer id){
		return tipoDestinoRepository.findById(id);
		
	}

	@Override
	public TipoDestino consultarTipoDestinoPorCod(String codigo) throws Exception {
		TipoDestino tp = tipoDestinoRepository.findByCodigo(codigo);
		if(tp == null) {
			throw new Exception("No existe ningun tipo de destino con este codigo.");
		}
		return tp;
	}
	
	@Override
	public Optional<TipoDestino> consultarTipoDestinoPorId(Integer idTi) throws Exception {
		Optional <TipoDestino> tis= tipoDestinoRepository.findById(idTi);
		if(tis == null) {
			throw new Exception ("No existe ningun tipo de destino con esta identificacion.");
		}
		return tis;
		
	}
   
	
}
