package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;

//la anotacion @Service va en el impl, en esta interface solo va la firma del metodo
public interface TipoIdentificacionService {
	
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception;

	public void eliminarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception;

	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception;

	public List<TipoIdentificacion> consultarTipoIdentificacion() throws Exception;

	public Optional<TipoIdentificacion> consultarTipoIdentificacionPorCodigo(Integer id) throws Exception;
	
	public TipoIdentificacion consultarTipoIdentificacionPorCod(String codigo) throws Exception;
	
	public Optional<TipoIdentificacion> consultarTipoIdentificacionPorId(Integer idTi) throws Exception;
	
	

}
