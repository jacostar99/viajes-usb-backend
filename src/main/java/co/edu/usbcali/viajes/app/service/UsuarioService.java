package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> consultarTodosUsuario() throws Exception;

	public void guardarUsuario(Usuario usuario) throws Exception;

	public void actualizarUsuario(Usuario usuario) throws Exception;

	public void eliminarUsuario(Usuario usuario) throws Exception;


	public Usuario consultarUsuarioPorId(Integer idUsuario) throws Exception;

}
