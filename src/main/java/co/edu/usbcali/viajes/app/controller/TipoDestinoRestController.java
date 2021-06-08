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

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;

@RestController
@RequestMapping("/api/tipoDestino") //todo lo de esta URL entra a tipoDestinoRestController
@CrossOrigin("*")
public class TipoDestinoRestController {
	
	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	//lo convierte en JSON por la anotacion REST CONTROLLER
	@GetMapping("/getTiposDestino")
	public ResponseEntity<?> consultarTodosTipoDestino(){
		try {
			
			return ResponseEntity.ok().body(tipoDestinoService.consultarTipoDestino());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/getTipoDestinoPorCodigo")
	public ResponseEntity<?> consultarTipoDestinoPorCodigo(@RequestParam("codigo") String codigo){
		try {
			
			return ResponseEntity.ok().body(tipoDestinoService.consultarTipoDestinoPorCod(codigo));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
		}
		
	}
	
	@GetMapping("/getTipoDestinoPorId/{id}")
	public ResponseEntity<?> consultarTipoDestinoPorId(@PathVariable("id") Integer idTide){
		try {
			
			return ResponseEntity.ok().body(tipoDestinoService.consultarTipoDestinoPorId(idTide));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
		}
		
	}
	
    @PostMapping("/guardarTipoDestino")
	public ResponseEntity<?> guardarTipoDestino(@RequestBody TipoDestinoDTO tipoDestinoDTO){
    	
    	try {
    		TipoDestino tipoDestino = new TipoDestino();
    		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
    		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
    		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
    		tipoDestino.setFechaCreacion(new Date());
    		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
    		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());
    				
    		tipoDestinoService.guardarTipoDestino(tipoDestino);
    		
    		return ResponseEntity.ok().body(tipoDestino);
    		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		
	}
    
    
    @PutMapping("/actualizarTipoDestino")
	public ResponseEntity<?> actualizarTipoDestino(@RequestBody TipoDestinoDTO tipoDestinoDTO){
    	
    	try {
    		TipoDestino tipoDestino = new TipoDestino();
    		tipoDestino.setIdTide(tipoDestinoDTO.getIdTide());
    		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
    		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
    		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
    		tipoDestino.setFechaCreacion(new Date());
    		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
    		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());
    		tipoDestino.setFechaModificacion(new Date());
    		tipoDestino.setUsuModificador(tipoDestinoDTO.getUsuModificador());
    				
    		tipoDestinoService.actualizarTipoDestino(tipoDestino);
    		
    		return ResponseEntity.ok().body(tipoDestino);
    		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		
	}
    
    @DeleteMapping("/eliminarTipoDestino/{id}") //para recibir el id por la url
	public ResponseEntity<?> eliminarTipoDestino(@PathVariable("id") Integer idTipoDestino){ //el path variable es para decirle que me tome el id que le paso en la url
    try {
    	TipoDestino d = new TipoDestino();
    	d.setIdTide(idTipoDestino);
		tipoDestinoService.eliminarTipoDestino(d);
        
		return ResponseEntity.ok().build();	
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}

}
