package co.edu.usbcali.viajes.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.dto.DetallePlanDTO;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.DetallePlanService;
import co.edu.usbcali.viajes.app.service.PlanService;

@RestController
@RequestMapping("/api/detallePlan")
public class DetallePlanRestController {

	@Autowired
	public DetallePlanService detallePService;

	@Autowired
	public DestinoService destinoService;

	@Autowired
	public PlanService planService;
    
	@GetMapping("/getDetallePorId")
	public ResponseEntity<?> consultarDetallePorCodigo(@RequestParam("idDepl") Integer id) {
		try {

			return ResponseEntity.ok().body(detallePService.buscarDetallePorId(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
	
	@GetMapping("/getTodosDetalle") 
	public ResponseEntity<?> listarTodosDetalles() {
		try {
			return ResponseEntity.ok().body(detallePService.consultarTodos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/eliminarDetalle/{id}") 
	public ResponseEntity<?> eliminarDetalle(@PathVariable("id") Integer idDetalle) {

		try {
			DetallePlan detallePlan = new DetallePlan();
			detallePlan.setIdDepl(idDetalle);
			detallePService.eliminarDetallePlan(detallePlan);

			return ResponseEntity.ok().body("Se elimino satisfactoriamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@PostMapping("/guardarDetalle") 
	public ResponseEntity<?> guardarDetalle(@RequestBody DetallePlanDTO detalleDTO) {
		try {

			Destino tide = destinoService.consultarDestinoPorCod(detalleDTO.getIdDest());

			Plan tipl = planService.consultarPlanPorCodigo(detalleDTO.getIdPlan());

			DetallePlan detalle = new DetallePlan();
			detalle.setAlimentacion(detalleDTO.getAlimentacion());
			detalle.setCantidadNoches(detalleDTO.getCantidadNoches());
			detalle.setCantidadDias(detalleDTO.getCantidadDias());
			detalle.setEstado(detalleDTO.getEstado());
			detalle.setFechaCreacion(detalleDTO.getFechaCreacion());
			detalle.setHospedaje(detalleDTO.getHospedaje());
			detalle.setTransporte(detalleDTO.getTransporte());
			detalle.setTraslados(detalleDTO.getTraslados());
			detalle.setUsuCreador(detalleDTO.getUsuCreador());
			detalle.setValor(detalleDTO.getValor());
			detalle.setIdDest(tide);
			detalle.setIdPlan(tipl);
			detallePService.guardarDetallePlan(detalle);
			return ResponseEntity.ok().body(detalle);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/actualizarDetalle")
	public ResponseEntity<?> actualizarDetalle(@RequestBody DetallePlanDTO detalleDTO) {
		try {

			Destino tide = destinoService.consultarDestinoPorCod(detalleDTO.getIdDest());

			Plan tipl = planService.consultarPlanPorCodigo(detalleDTO.getIdPlan());

			DetallePlan detalle = new DetallePlan();
			detalle.setIdDepl(detalleDTO.getIdDepl());
			detalle.setAlimentacion(detalleDTO.getAlimentacion());
			detalle.setCantidadNoches(detalleDTO.getCantidadNoches());
			detalle.setCantidadDias(detalleDTO.getCantidadDias());
			detalle.setEstado(detalleDTO.getEstado());
			detalle.setFechaCreacion(detalleDTO.getFechaCreacion());
			detalle.setHospedaje(detalleDTO.getHospedaje());
			detalle.setTransporte(detalleDTO.getTransporte());
			detalle.setTraslados(detalleDTO.getTraslados());
			detalle.setUsuCreador(detalleDTO.getUsuCreador());
			detalle.setValor(detalleDTO.getValor());
			detalle.setUsuModificador(detalleDTO.getUsuModificador());
			detalle.setFechaModificacion(new Date());
			detalle.setIdDest(tide);
			detalle.setIdPlan(tipl);
			detallePService.actualizarDetallePlan(detalle);

			return ResponseEntity.ok().body(detalle);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
