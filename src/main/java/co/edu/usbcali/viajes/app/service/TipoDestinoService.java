package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.TipoDestino;

//la anotacion @Service va en el impl, en esta interface solo va la firma del metodo
public interface TipoDestinoService {

	public void guardarTipoDestino(TipoDestino tipoDestino) throws Exception;

	public void eliminarTipoDestino(TipoDestino tipoDestino) throws Exception;

	public void actualizarTipoDestino(TipoDestino tipoDestino) throws Exception;

	public List<TipoDestino> consultarTipoDestino() throws Exception;

	public Optional<TipoDestino> consultarTipoDestinoPorCodigo(Integer id) throws Exception;
	
	public TipoDestino consultarTipoDestinoPorCod(String codigo) throws Exception;
	
	public Optional<TipoDestino> consultarTipoDestinoPorId(Integer idTide) throws Exception;


}
