package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void guardarCliente(Cliente cliente) throws Exception {

		if (cliente.getCorreo() == null || cliente.getCorreo().trim().equals("")
				|| cliente.getCorreo().length() > 100) {
			throw new Exception("Introduzca correo valido.");
		}

		Cliente clienteDB = clienteRepository.findByNumeroIdentificacion(cliente.getNumeroIdentificacion());
		if (clienteDB != null) {
			throw new Exception("Ya existe un cliente con ese numero de identificacion.");
		}

		if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().trim().equals("")
				|| cliente.getNumeroIdentificacion().length() > 15) {
			throw new Exception("Introduzca un numero de identificacion valido.");
		}
		if (cliente.getPrimerApellido() == null || cliente.getPrimerApellido().trim().equals("")
				|| cliente.getNumeroIdentificacion().length() > 100) {
			throw new Exception("Introduzca un primer apellido valido.");
		}

		if (cliente.getNombre() == null || cliente.getNombre().trim().equals("")
				|| cliente.getNombre().length() > 100) {
			throw new Exception("Digite un numero de identificacion valido.");
		}
		if (cliente.getTelefono1().length() > 15) {
			throw new Exception("Digite un numero de telefono1 valido.");
		}
        	
		if (cliente.getSexo() == null || cliente.getSexo().trim().equals("") || cliente.getSexo().length() > 1) {
			throw new Exception("Digite un sexo valido (M/F)");
		}
		if (cliente.getFechaNacimiento() == null) {
			throw new Exception("Digite una fecha de nacimiento valida.");
		}
		if (cliente.getFechaCreacion() == null) {
			throw new Exception("Digite una fecha de creacion valida.");
		}
		if (cliente.getUsuCreador() == null || cliente.getUsuCreador().length() > 10) {
			throw new Exception("Usuario creador invalido.");
		}

		if (cliente.getEstado() == null || cliente.getEstado().trim().equals("") || cliente.getEstado().length() > 1) {
			throw new Exception("Estado invalido.");
		}

		if (cliente.getTiId() == null) {
			throw new Exception("Digite un tipo de identificacion valido.");
		}

		clienteRepository.save(cliente);

	}

	@Override
	public void eliminarCliente(Cliente cliente) throws Exception {
		if(cliente == null || cliente.getIdClie()== null) {
			throw new Exception("Se debe ingresar un destino a eliminar");
		}
		
		Optional <Cliente> clienteDB = clienteRepository.findById(cliente.getIdClie());
		
		if(clienteDB.isPresent()) {
			clienteRepository.delete(clienteDB.get());
		} else {  
		throw new Exception("No existe un destino con ese id.");
		}

	}

	@Override
	public void actualizarCliente(Cliente cliente) throws Exception {
		
		if (cliente.getIdClie() == null) {
			throw new Exception("Debe ingresar un id de cliente valido para actualizar.");
			
		}
		
		Optional <Cliente> clienteBD = clienteRepository.findById(cliente.getIdClie());
		if(clienteBD.isEmpty()) {
			throw new Exception("No existe un cliente con este id");
		}
		
		if (cliente.getCorreo() == null || cliente.getCorreo().trim().equals("")
				|| cliente.getCorreo().length() > 100) {
			throw new Exception("Introduzca correo valido.");
		}


		if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().trim().equals("")
				|| cliente.getNumeroIdentificacion().length() > 15) {
			throw new Exception("Introduzca un numero de identificacion valido.");
		}
		if (cliente.getPrimerApellido() == null || cliente.getPrimerApellido().trim().equals("")
				|| cliente.getNumeroIdentificacion().length() > 100) {
			throw new Exception("Introduzca un primer apellido valido.");
		}

		if (cliente.getNombre() == null || cliente.getNombre().trim().equals("")
				|| cliente.getNombre().length() > 100) {
			throw new Exception("Digite un numero de identificacion valido.");
		}
		if (cliente.getTelefono1().length() > 15) {
			throw new Exception("Digite un numero de telefono1 valido.");
		}

		if (cliente.getSexo() == null || cliente.getSexo().trim().equals("") || cliente.getSexo().length() > 1) {
			throw new Exception("Digite un sexo valido (M/F)");
		}
		if (cliente.getFechaNacimiento() == null) {
			throw new Exception("Digite una fecha de nacimiento valida.");
		}

		if (cliente.getUsuCreador() == null || cliente.getUsuCreador().length() > 10) {
			throw new Exception("Usuario creador invalido.");
		}

		if (cliente.getEstado() == null || cliente.getEstado().trim().equals("") || cliente.getEstado().length() > 1) {
			throw new Exception("Estado invalido.");
		}

		if (cliente.getTiId() == null) {
			throw new Exception("Digite un tipo de identificacion valido.");
		}
		
		if (cliente.getUsuModificador() == null || cliente.getUsuModificador().length() > 10) {
			throw new Exception("Digite un usuario modificador valido");
		}
		
		if(cliente.getFechaModificacion() == null) {
			throw new Exception("Fecha modificacion invalida.");
		}

		clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> consultarCliente() throws Exception {
		List<Cliente> listCliente = clienteRepository.findAll();

		if (listCliente.isEmpty()) {
			throw new Exception("No se encontraron clientes en el sistema.	");

		}
		return listCliente;
	}

	@Override
	public Optional<Cliente> consultarClientePorCodigo(Integer id) throws Exception {
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente consultarClientePorIdentificacion(String identificacion) throws Exception {
		Cliente listCli = clienteRepository.findByNumeroIdentificacion(identificacion);
		if (listCli == null) {
			throw new Exception("No existe ningun cliente con esta identificacion.");

		}
		return listCli;
	}

}
