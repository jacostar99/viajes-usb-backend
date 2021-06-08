package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.Cliente;


//la anotacion @Service va en el impl, en esta interface solo va la firma del metodo
public interface ClienteService {
    
	
	public void guardarCliente(Cliente cliente) throws Exception;

	public void eliminarCliente(Cliente cliente) throws Exception;

	public void actualizarCliente(Cliente cliente) throws Exception;

	public List<Cliente> consultarCliente() throws Exception;

	public Optional<Cliente> consultarClientePorCodigo(Integer id) throws Exception;
	
	public Cliente consultarClientePorIdentificacion(String identificacion) throws Exception;


}
