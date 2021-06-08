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

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;

@RestController
@RequestMapping("/api/tipoIdentificacion")
@CrossOrigin("*")
public class TipoIdentificacionRestController {

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	
	@GetMapping("/getTipoIdentificacion")
	public ResponseEntity<?> consultarTodosTipoIdentificacion(){
		try {
			
			return ResponseEntity.ok().body(tipoIdentificacionService.consultarTipoIdentificacion());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/getTipoIdentificacionPorCodigo")
	public ResponseEntity<?> consultarTipoIdentificacionPorCodigo(@RequestParam("codigo") String codigo){
		try {
			return ResponseEntity.ok().body(tipoIdentificacionService.consultarTipoIdentificacionPorCod(codigo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
 		}
		
	}
	
	@GetMapping("/getTipoIdentificacionPorId/{id}")
	public ResponseEntity<?> consultarTipoIdentificacionPorCodigo(@PathVariable("id") Integer idTiId){
		try {
			return ResponseEntity.ok().body(tipoIdentificacionService.consultarTipoIdentificacionPorId(idTiId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());	
 		}
		
	}
	
	@PostMapping("/guardarTipoIdentificacion")
	public ResponseEntity<?> guardarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdentificacionDTO){
		try {
			
			TipoIdentificacion tiId = new TipoIdentificacion();
			tiId.setCodigo(tipoIdentificacionDTO.getCodigo());
			tiId.setEstado(tipoIdentificacionDTO.getEstado());
			tiId.setFechaCreacion(new Date());
			tiId.setNombre(tipoIdentificacionDTO.getNombre());
			tiId.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());
	

			tipoIdentificacionService.guardarTipoIdentificacion(tiId);
			
			return ResponseEntity.ok().body(tiId);

			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@PutMapping("/actualizarTipoIdentificacion")
	public ResponseEntity<?> actualizarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdentificacionDTO){
		try {
			
			TipoIdentificacion tiId = new TipoIdentificacion();
			tiId.setIdTiid(tipoIdentificacionDTO.getIdTiid());
			tiId.setCodigo(tipoIdentificacionDTO.getCodigo());
			tiId.setEstado(tipoIdentificacionDTO.getEstado());
			tiId.setFechaCreacion(new Date());
			tiId.setNombre(tipoIdentificacionDTO.getNombre());
			tiId.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());
			tiId.setFechaModificacion(tipoIdentificacionDTO.getFechaModificacion());
			tiId.setUsuModificador(tipoIdentificacionDTO.getUsuModificador());


			tipoIdentificacionService.actualizarTipoIdentificacion(tiId);
			
			return ResponseEntity.ok().body(tiId);

			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	
	@DeleteMapping("/eliminarTipoIdentificacion/{id}") //para recibir el id por la url
	public ResponseEntity<?> eliminarTipoIdentificacion(@PathVariable("id") Integer idTipoId){ //el path variable es para decirle que me tome el id que le paso en la url
    try {
    	TipoIdentificacion ti = new TipoIdentificacion();
    	ti.setIdTiid(idTipoId);
    	tipoIdentificacionService.eliminarTipoIdentificacion(ti);
    	
        
		return ResponseEntity.ok().build();
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}
}
