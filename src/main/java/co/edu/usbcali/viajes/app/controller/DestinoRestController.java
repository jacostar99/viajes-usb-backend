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
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;

@RestController
@RequestMapping("/api/destino")
@CrossOrigin("*")
public class DestinoRestController {

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private TipoDestinoService tipoDestinoService;

	@GetMapping("/getDestinos")
	public ResponseEntity<?> consultarTodosDestinos() {
		try {

			return ResponseEntity.ok().body(destinoService.consultarDestino());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// return
			// ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@GetMapping("/getDestinoPorCodigo/{id}")
	public ResponseEntity<?> consultarDestinoPorCodigo(@PathVariable("id") Integer idDest) {
		try {

			return ResponseEntity.ok().body(destinoService.consultarDestinoPorCodigo(idDest));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			// return
			// ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destinoDto) {
		try {

			TipoDestino tide = tipoDestinoService.consultarTipoDestinoPorCod(destinoDto.getTipoDestinoCodigo());
			

			Destino destino = new Destino();
			destino.setAire(destinoDto.getAire());
			destino.setCodigo(destinoDto.getCodigo());
			destino.setDescripcion(destinoDto.getDescripcion());
			destino.setEstado(destinoDto.getEstado());
			destino.setFechaCreacion(new Date()); // fecha actual
			destino.setMar(destinoDto.getMar());
			destino.setNombre(destinoDto.getNombre());
			destino.setTierra(destinoDto.getTierra());
			destino.setUsuCreador(destinoDto.getUsuCreador());
			destino.setTipoDestino(tide); 
            
			destinoService.guardarDestino(destino);
			
			return ResponseEntity.ok().body(destino);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarDestino")
	public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destinoDto) {
		try {

			TipoDestino tide = tipoDestinoService.consultarTipoDestinoPorCod(destinoDto.getTipoDestinoCodigo());
			

			Destino destino = new Destino();
			destino.setIdDest(destinoDto.getIdDest());
			destino.setAire(destinoDto.getAire());
			destino.setCodigo(destinoDto.getCodigo());
			destino.setDescripcion(destinoDto.getDescripcion());
			destino.setEstado(destinoDto.getEstado());
			destino.setFechaCreacion(new Date()); // fecha actual
			destino.setMar(destinoDto.getMar());
			destino.setNombre(destinoDto.getNombre());
			destino.setTierra(destinoDto.getTierra());
			destino.setUsuCreador(destinoDto.getUsuCreador());
			destino.setUsuModificador(destinoDto.getUsuModificador());
			destino.setFechaModificacion(new Date());
			destino.setTipoDestino(tide); 
            
			destinoService.actualizarDestino(destino);
			
			return ResponseEntity.ok().body(destino);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarDestino/{id}") //para recibir el id por la url
	public ResponseEntity<?> eliminarDestino(@PathVariable("id") Integer idDestino){ //el path variable es para decirle que me tome el id que le paso en la url
    try {
    	Destino d = new Destino();
    	d.setIdDest(idDestino);
		destinoService.eliminarDestino(d);
		return ResponseEntity.ok().build();
		//return ResponseEntity.ok().body("Se elimino satisfactoriamente.");
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}
	
	
}
