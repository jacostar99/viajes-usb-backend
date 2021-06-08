package co.edu.usbcali.viajes.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.UsuarioDTO;
import co.edu.usbcali.viajes.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioRestController {
	
	@Autowired
	public UsuarioService usuarioService;
	
	
	@GetMapping("/getUsuarioPorId")
	public ResponseEntity<?> consultarUsuarioPorId(@RequestParam("idUsua") Integer id){
		try {
			
			return ResponseEntity.ok().body(usuarioService.consultarUsuarioPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
		}
		
	}
	@GetMapping("/getUsuarios")
	public ResponseEntity<?> consultarUsuarios() {
		try {
			return ResponseEntity.ok().body(usuarioService.consultarTodosUsuario());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Integer idUsuario) {

		try {
			Usuario usuario = new Usuario();
			usuario.setIdUsua(idUsuario);;
			usuarioService.eliminarUsuario(usuario);

			return ResponseEntity.ok().body("Se elimino satisfactoriamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {

			Usuario usuario= new Usuario();
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setPassword(usuarioDTO.getPassword());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setIdentificacion(usuarioDTO.getIdentificacion());
			usuario.setEstado(usuarioDTO.getEstado());
			usuario.setFechaCreacion(new Date());
			usuario.setUsuCreador(usuarioDTO.getUsuCreador());
			
			usuarioService.guardarUsuario(usuario);
			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
		try {
		

			Usuario usuario= new Usuario();
			usuario.setIdUsua(usuarioDTO.getIdUsua());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setPassword(usuarioDTO.getPassword());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setIdentificacion(usuarioDTO.getIdentificacion());
			usuario.setEstado(usuarioDTO.getEstado());
			usuario.setFechaCreacion(new Date());
			usuario.setUsuCreador(usuarioDTO.getUsuCreador());			
			usuario.setFechaModificacion(new Date());
			usuario.setUsuModificador(usuarioDTO.getUsuModificador());
			usuarioService.actualizarUsuario(usuario);
	
			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}



