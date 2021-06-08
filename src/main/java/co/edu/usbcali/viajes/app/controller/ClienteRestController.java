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

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteRestController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	
	@GetMapping("/getClientes")
	public ResponseEntity<?> consultarTodosCliente(){
		try {
			
			return ResponseEntity.ok().body(clienteService.consultarCliente());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
	
	@GetMapping("/getClientePorIdentificacion")
	public ResponseEntity<?> consultarClientePorIdentificacion(@RequestParam("numeroIdentificacion") String identificacion){
		try {
			
			return ResponseEntity.ok().body(clienteService.consultarClientePorIdentificacion(identificacion));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
		}
		
	}
	
	@GetMapping("/getClientePorId/{id}")
	public ResponseEntity<?> consultarClientePorId(@PathVariable("id") Integer idClie){
		try {
			
			return ResponseEntity.ok().body(clienteService.consultarClientePorCodigo(idClie));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
		}
		
	}
	
	@PostMapping("/guardarCliente")
	public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO){
		try {
			
			TipoIdentificacion tiIde = tipoIdentificacionService.consultarTipoIdentificacionPorCod(clienteDTO.getTipoIdentificacionCodigo());
			Cliente cliente = new Cliente();
			cliente.setCorreo(clienteDTO.getCorreo());
			cliente.setEstado(clienteDTO.getEstado());
			cliente.setFechaCreacion(new Date());
			cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
			cliente.setNombre(clienteDTO.getNombre());
			cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
			cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
			cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
			cliente.setTelefono2(clienteDTO.getTelefono2());
			cliente.setSexo(clienteDTO.getSexo());
			cliente.setTelefono1(clienteDTO.getTelefono1());
			cliente.setTiId(tiIde);
			cliente.setUsuCreador(clienteDTO.getUsuCreador());

			clienteService.guardarCliente(cliente);
			
			return ResponseEntity.ok().body(cliente);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@PutMapping("/actualizarCliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO){
		try {
			TipoIdentificacion tiIde = tipoIdentificacionService.consultarTipoIdentificacionPorCod(clienteDTO.getTipoIdentificacionCodigo());
			Cliente cliente = new Cliente();
			cliente.setIdClie(clienteDTO.getIdClie());
			cliente.setCorreo(clienteDTO.getCorreo());
			cliente.setEstado(clienteDTO.getEstado());
			cliente.setFechaCreacion(new Date());
			cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
			cliente.setNombre(clienteDTO.getNombre());
			cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
			cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
			cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
			cliente.setTelefono2(clienteDTO.getTelefono2());
			cliente.setSexo(clienteDTO.getSexo());
			cliente.setTelefono1(clienteDTO.getTelefono1());
			cliente.setTiId(tiIde);
			cliente.setUsuCreador(clienteDTO.getUsuCreador());
			cliente.setUsuModificador(clienteDTO.getUsuModificador());
			cliente.setFechaModificacion(new Date());

			clienteService.actualizarCliente(cliente);
			
			return ResponseEntity.ok().body(cliente);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/eliminarCliente/{id}") //para recibir el id por la url
	public ResponseEntity<?> eliminarCliente(@PathVariable("id") Integer idCliente){ //el path variable es para decirle que me tome el id que le paso en la url
    try {
    	Cliente c = new Cliente();
    	c.setIdClie(idCliente);
    	clienteService.eliminarCliente(c);
        
		return ResponseEntity.ok().build();
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}
	
}
