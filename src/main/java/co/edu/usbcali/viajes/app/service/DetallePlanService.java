package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.DetallePlan;

public interface DetallePlanService {

	public List<DetallePlan> consultarTodos() throws Exception;

	public void guardarDetallePlan(DetallePlan entity) throws Exception;

	public void actualizarDetallePlan(DetallePlan entity) throws Exception;

	public void eliminarDetallePlan(DetallePlan entity) throws Exception;

	public Optional<DetallePlan> buscarDetallePorId(Integer idDetalle) throws Exception;
}
