package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.Destino;

//la anotacion @Service va en el impl, en esta interface solo va la firma del metodo
public interface DestinoService {
	
	public void guardarDestino(Destino destino) throws Exception;
	
	public void eliminarDestino(Destino destino) throws Exception;
	
	public void actualizarDestino (Destino destino) throws Exception;
	
	public List <Destino> consultarDestino () throws Exception;
	
	public Optional<Destino> consultarDestinoPorCodigo(Integer id) throws Exception;
	
	public Destino consultarDestinoPorCod(String codigo) throws Exception;

	

}
