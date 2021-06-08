package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.repository.DetallePlanRepository;

@Service
public class DetallePlanServiceImpl implements DetallePlanService {

	@Autowired
	private DetallePlanRepository detalleRepository;

	@Override
	public List<DetallePlan> consultarTodos() throws Exception {
		List<DetallePlan> listDetalle = detalleRepository.findAll();

//		Validar si la lista está vacía
		if (listDetalle.isEmpty()) {
			throw new Exception("No hay detalles de plan existentes.");
		}

		return listDetalle;
	}

	@Override
	public void guardarDetallePlan(DetallePlan detalle) throws Exception {

		if (detalle == null) {
			throw new Exception("Debe ingresar un detalle de plan");
		}
		if (detalle.getAlimentacion() == null || detalle.getAlimentacion().trim().equals("")
				|| detalle.getAlimentacion().length() > 1) {
			throw new Exception("Campo alimentacion invalido");
		}
		if (detalle.getHospedaje() == null || detalle.getHospedaje().trim().equals("")
				|| detalle.getHospedaje().length() > 1) {
			throw new Exception("Campo hospedaje invalido");
		}
		if (detalle.getTraslados() == null || detalle.getTraslados().trim().equals("")
				|| detalle.getTraslados().length() > 1) {
			throw new Exception("Campo traslados invalido");
		}
		if (detalle.getTransporte() == null || detalle.getTransporte().trim().equals("")
				|| detalle.getTransporte().length() > 1) {
			throw new Exception("Campo transporte invalido");
		}
		if (detalle.getValor() <= 0) {
			throw new Exception("Valor no puede ser menor o igual a 0");
		}
		if (detalle.getCantidadDias() <= 0) {
			throw new Exception("Cantidad de días no puede ser menor o igual a 0");
		}
		if (detalle.getCantidadNoches() <= 0) {
			throw new Exception("Cantidad de noches no puede ser menor o igual a 0");
		}

		if (detalle.getCantidadNoches() > detalle.getCantidadDias()) {
			throw new Exception("La cantidad de noches no puede ser mayor a la cantidad de dias.");
		}

		if (detalle.getUsuCreador() == null || detalle.getUsuCreador().trim().equals("")) {
			throw new Exception("Usuario creador no debe ser nulo ni estar vacio");
		}
		if (detalle.getEstado() == null || detalle.getEstado().trim().equals("") || detalle.getEstado().length() > 1) {
			throw new Exception("Estado no puede ser nulo ni estar vacio");
		}

		detalleRepository.save(detalle);

	}

	@Override
	public void actualizarDetallePlan(DetallePlan detalle) throws Exception {

		if (detalle == null) {
			throw new Exception("Debe ingresar un destino.");
		}
		
		if (detalle.getIdDepl() == null) {
			throw new Exception("Debe ingesar un id de detalle valido para actualizar");
		}
		
		Optional <DetallePlan> detalleB1 = detalleRepository.findById(detalle.getIdDepl());
		if(detalleB1.isEmpty()) {
			throw new Exception("No existe un detalle con este id");
		}
		if (detalle.getAlimentacion() == null || detalle.getAlimentacion().trim().equals("")
				|| detalle.getAlimentacion().length() > 1) {
			throw new Exception("Campo alimentacion invalido");
		}
		if (detalle.getHospedaje() == null || detalle.getHospedaje().trim().equals("")
				|| detalle.getHospedaje().length() > 1) {
			throw new Exception("Campo hospedaje invalido");
		}
		if (detalle.getTraslados() == null || detalle.getTraslados().trim().equals("")
				|| detalle.getTraslados().length() > 1) {
			throw new Exception("Campo traslados invalido");
		}
		if (detalle.getTransporte() == null || detalle.getTransporte().trim().equals("")
				|| detalle.getTransporte().length() > 1) {
			throw new Exception("Campo transporte invalido");
		}
		if (detalle.getValor() <= 0) {
			throw new Exception("Valor no puede ser menor o igual a 0");
		}
		if (detalle.getCantidadDias() <= 0) {
			throw new Exception("Cantidad de días no puede ser menor o igual a 0");
		}
		if (detalle.getCantidadNoches() <= 0) {
			throw new Exception("Cantidad de noches no puede ser menor o igual a 0");
		}

		if (detalle.getCantidadNoches() > detalle.getCantidadDias()) {
			throw new Exception("La cantidad de noches no puede ser mayor a la cantidad de dias.");
		}

		if (detalle.getUsuCreador() == null || detalle.getUsuCreador().trim().equals("")) {
			throw new Exception("Usuario creador no debe ser nulo ni estar vacio");
		}
		if (detalle.getEstado() == null || detalle.getEstado().trim().equals("")) {
			throw new Exception("Estado no puede ser nulo ni estar vacio");
		}
		
		if(detalle.getUsuModificador() == null || detalle.getUsuModificador().trim().equals("")) {
			throw new Exception("Debe ingresar un user modificador valido");
			
		}
		if(detalle.getFechaModificacion() == null) {
			throw new Exception("Debe ingresar una fecha de modificacion valida");
		}

		detalleRepository.save(detalle);

 
	}

	@Override
	public void eliminarDetallePlan(DetallePlan detalle) throws Exception {
		if (detalle == null || detalle.getIdDepl() == null) {
			throw new Exception("Se debe ingresar un detalle a eliminar");
		}

		Optional<DetallePlan> detalleDB = detalleRepository.findById(detalle.getIdDepl());

		if (detalleDB.isPresent()) {
			detalleRepository.delete(detalleDB.get());
		} else {
			throw new Exception("No existe un detalle con ese id.");
		}

	}

	@Override
	public Optional<DetallePlan> buscarDetallePorId(Integer idDetalle) throws Exception {
		Optional<DetallePlan> detalle = detalleRepository.findById(idDetalle);

//		Validar si el detalle existe
		if (!detalle.isPresent()) {
			throw new Exception("No existe un detalle con ese ID.");
		}

		return detalle;

	}

}
