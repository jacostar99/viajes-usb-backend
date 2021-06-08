package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> consultarTodosUsuario() throws Exception {
		List<Usuario> listUsuarios = usuarioRepository.findAll();

//		Validar si la lista está vacía
		if (listUsuarios.isEmpty()) {
			throw new Exception("No hay usuarios en el sistema.");
		}

		return listUsuarios;
	}

	@Override
	public void guardarUsuario(Usuario usuario) throws Exception {
		
		if(usuario==null) {
			throw new Exception("Debe ingresar un usuario");
		}
		
		Usuario usuarioDB = usuarioRepository.findByIdentificacion(usuario.getIdentificacion());
		if (usuarioDB != null) {
			throw new Exception("Ya existe un Usuario con ese numero de identificacion.");
		}
		
		Usuario usuarioDB1 = usuarioRepository.findByLogin(usuario.getLogin());
		if (usuarioDB1 != null) {
			throw new Exception("Ya existe un Usuario con este nombre de usuario.");
		}
		
		if(usuario.getLogin()==null || usuario.getLogin().trim().equals("") || usuario.getLogin().length() > 10) {
			throw new Exception("El campo login no debe ser nulo o vacio");
		}
		if(usuario.getPassword()==null || usuario.getPassword().trim().equals("") || usuario.getPassword().length() > 50) {
			throw new Exception("El campo password no debe ser nulo o vacio");
		}
		if(usuario.getNombre()==null || usuario.getNombre().trim().equals("") || usuario.getNombre().length() > 100) {
			throw new Exception("El campo nombre no debe ser nulo o vacio");
		}
		if(usuario.getIdentificacion()==null || usuario.getIdentificacion().trim().equals("") || usuario.getIdentificacion().length() > 50) {
			throw new Exception("El campo identificacion no debe ser nulo o vacio");
		}
		if(usuario.getFechaCreacion()==null ) {
			throw new Exception("El campo fecha creacio no debe ser nulo");
		}
		if(usuario.getUsuCreador()==null || usuario.getUsuCreador().trim().equals("") || usuario.getUsuCreador().length() > 10) {
			throw new Exception("El campo usuario creador no debe ser nulo o vacio");
		}
		if(usuario.getEstado()==null || usuario.getEstado().trim().equals("") || usuario.getEstado().length() > 1) {
			throw new Exception("El campo estado no debe ser nulo o vacio");
		}
		
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws Exception {
		
		if (usuario.getIdUsua() == null) {
			throw new Exception("Debe ingresar un id de usuario valido para actualizar.");
			
		}
		
		Optional <Usuario> clienteBD = usuarioRepository.findById(usuario.getIdUsua());
		if(clienteBD.isEmpty()) {
			throw new Exception("No existe un usuario con este id");
		}
		
		
		if(usuario.getLogin()==null || usuario.getLogin().trim().equals("") || usuario.getLogin().length() > 10) {
			throw new Exception("El campo login no debe ser nulo o vacio");
		}
		if(usuario.getPassword()==null || usuario.getPassword().trim().equals("") || usuario.getPassword().length() > 50) {
			throw new Exception("El campo password no debe ser nulo o vacio");
		}
		if(usuario.getNombre()==null || usuario.getNombre().trim().equals("") || usuario.getNombre().length() > 100) {
			throw new Exception("El campo nombre no debe ser nulo o vacio");
		}
		if(usuario.getIdentificacion()==null || usuario.getIdentificacion().trim().equals("") || usuario.getIdentificacion().length() > 50) {
			throw new Exception("El campo identificacion no debe ser nulo o vacio");
		}
		if(usuario.getFechaCreacion()==null ) {
			throw new Exception("El campo fecha creacio no debe ser nulo");
		}
		if(usuario.getUsuCreador()==null || usuario.getUsuCreador().trim().equals("") || usuario.getUsuCreador().length() > 10) {
			throw new Exception("El campo usuario creador no debe ser nulo o vacio");
		}
		if(usuario.getEstado()==null || usuario.getEstado().trim().equals("") || usuario.getEstado().length() > 1) {
			throw new Exception("El campo estado no debe ser nulo o vacio");
		}
		
		if(usuario.getUsuModificador()==null || usuario.getUsuModificador().trim().equals("") || usuario.getUsuModificador().length() > 10) {
			throw new Exception("El campo usuario modificador no debe ser nulo o vacio");
		}
		
		if(usuario.getFechaModificacion()==null ) {
			throw new Exception("El campo fecha modificacion no debe ser nulo");
		}
		
		
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws Exception {
		if(usuario == null || usuario.getIdUsua()== null) {
			throw new Exception("Se debe ingresar un usuario a eliminar");
		}
		
		Optional <Usuario> usuarioDb = usuarioRepository.findById(usuario.getIdUsua());
		
		if(usuarioDb.isPresent()) {
			usuarioRepository.delete(usuarioDb.get());
		} else {  
		throw new Exception("No existe un usuario con ese id.");
		}
		
	}

	@Override
	public Usuario consultarUsuarioPorId(Integer idUsuario) throws Exception {
		Usuario usuario = usuarioRepository.findByIdUsua(idUsuario);
		if (usuario == null) {
			throw new Exception("No existe ningun usuario con este id.");

		}
		return usuario;
	}
	

}
