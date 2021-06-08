package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	DestinoRepository destinoRepository;

	//------------------------------------------------ Guardar destino
	@Override
	public void guardarDestino(Destino destino) throws Exception {

		if (destino == null) {
			throw new Exception("Debe ingresar un destino.");
		}
					
		Destino destinoDB = destinoRepository.findByCodigo(destino.getCodigo().trim());
		if (destinoDB != null) {
			throw new Exception("Ya existe un destino con este codigo");
		}
	
		if (destino.getNombre() == null || destino.getNombre().trim().equals("") || destino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre valido.");
		}

		if (destino.getDescripcion() == null || destino.getDescripcion().trim().equals("")
				|| destino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripcion valida.");
		}

		if (destino.getTierra() == null || destino.getTierra().trim().equals("") || destino.getTierra().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getAire() == null || destino.getAire().trim().equals("") || destino.getAire().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getMar() == null || destino.getMar().trim().equals("") || destino.getMar().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}
		if (destino.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha valida.");
		}
		if (destino.getUsuCreador() == null || destino.getUsuCreador().trim().equals("")
				|| destino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario creador valido.");
		}
		if (destino.getEstado() == null || destino.getEstado().trim().equals("") || destino.getEstado().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getCodigo() == null || destino.getCodigo().trim().equals("") || destino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un codigo valido.");
		}

		destinoRepository.save(destino);

	}

	//------------------------------------------------ Eliminar destino
	@Override
	public void eliminarDestino(Destino destino) throws Exception {
		if(destino == null || destino.getIdDest()== null) {
			throw new Exception("Se debe ingresar un destino a eliminar");
		}
		
		Optional <Destino> destinoDB = destinoRepository.findById(destino.getIdDest());
		
		if(destinoDB.isPresent()) {
			destinoRepository.delete(destinoDB.get());
		} else {  
		throw new Exception("No existe un destino con ese id.");
		}

	}

	//------------------------------------------------ Actualizar destino
	@Override
	public void actualizarDestino(Destino destino) throws Exception {
		

		if (destino == null) {
			throw new Exception("Debe ingresar un destino.");
		}
		
		if (destino.getIdDest() == null) {
			throw new Exception("Debe ingesar un id de destino valido para actualizar");
		}
		
		Optional <Destino> destinoDB1 = destinoRepository.findById(destino.getIdDest());
		if(destinoDB1.isEmpty()) {
			throw new Exception("No existe un destino con este id");
		}
		
		/*
		Destino destinoDB = destinoRepository.findByCodigo(destino.getCodigo()); //consultarDestinoPorCod(destino.getCodigo());
		if (destinoDB == null) {
			throw new Exception("No existe un destino con este codigo");
		} */
				
		if (destino.getNombre() == null || destino.getNombre().trim().equals("") || destino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre valido.");
		}

		if (destino.getDescripcion() == null || destino.getDescripcion().equals("")
				|| destino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripcion valida.");
		}

		if (destino.getTierra() == null || destino.getTierra().equals("") || destino.getTierra().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getAire() == null || destino.getAire().equals("") || destino.getAire().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getMar() == null || destino.getMar().equals("") || destino.getMar().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}
		if (destino.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha valida.");
		}
		if (destino.getUsuCreador() == null || destino.getUsuCreador().equals("")
				|| destino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario creador valido.");
		}
		if (destino.getEstado() == null || destino.getEstado().equals("") || destino.getEstado().length() > 1) {
			throw new Exception("Debe ingresar una S o una N en este campo.");
		}

		if (destino.getCodigo() == null || destino.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un codigo valido.");
		}
		if (destino.getUsuModificador() == null || destino.getUsuModificador().equals("") || destino.getUsuModificador().length() > 10) {
			throw new Exception("Debe ingresar un nombre de usuario modificador valido.");
		}
		
		if (destino.getFechaModificacion() == null) {
			throw new Exception("Debe ingresar una fecha valida act.");
		}
		

		destinoRepository.save(destino);
	}

	//------------------------------------------------ Consultar los destinos
	@Override
	public List<Destino> consultarDestino() throws Exception {
		List<Destino> listDestino = destinoRepository.findAll();

		if (listDestino.isEmpty()) {
			throw new Exception("No se encontraron destinos en el sistema.	");

		}
		
		return listDestino;
	}

	//------------------------------------------------ Consultar destino por codigo
	@Override
	public Optional<Destino> consultarDestinoPorCodigo(Integer id) throws Exception {
		return destinoRepository.findById(id);
	}

	@Override
	public Destino consultarDestinoPorCod(String codigo) throws Exception {
		Destino listDestino = destinoRepository.findByCodigo(codigo);
		if(listDestino == null) {
			throw new Exception("No se encuentra un destino con este codigo en el sistema.");
		}
		return listDestino;
	}

}
