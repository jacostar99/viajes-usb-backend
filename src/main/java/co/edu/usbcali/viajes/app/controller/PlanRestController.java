	package co.edu.usbcali.viajes.app.controller;

import java.util.Date;
import java.util.GregorianCalendar;

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

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.PlanDTO;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.PlanService;
import co.edu.usbcali.viajes.app.service.UsuarioService;

@RestController
@RequestMapping("/api/plan")
public class PlanRestController {
	
	
	@Autowired
	private PlanService planService;
    
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/getPlanes")
	public ResponseEntity<?> consultarTodosPlan() {
		try {

			return ResponseEntity.ok().body(planService.consultarPlan());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/getPlanPorCodigo")
	public ResponseEntity<?> consultarPlanPorCodigo(
			@RequestParam("codigo") String codigo) {
		try {

			return ResponseEntity.ok().body(planService.consultarPlanPorCodigo(codigo));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}

	@PostMapping("/guardarPlan")
	public ResponseEntity<?> guardarPlan(@RequestBody PlanDTO planDTO) {
		try {
			GregorianCalendar  gc = new GregorianCalendar(2021,06,12);
			GregorianCalendar  gc2 = new GregorianCalendar(2021,06,20);

			
			Cliente idCli = clienteService.consultarClientePorIdentificacion(planDTO.getNumeroIdClie());
			Usuario idUs = usuarioService.consultarUsuarioPorId(planDTO.getIdUsua());
			
			Plan plan = new Plan();
			plan.setCantidadPersonas(planDTO.getCantidadPersonas());
			plan.setCodigo(planDTO.getCodigo());
			plan.setDescripcionSolicitud(planDTO.getDescripcionSolicitud());
			plan.setEstado(planDTO.getEstado());
			plan.setFechaCreacion(new Date());
			plan.setFechaFinViaje(gc2.getTime());
			plan.setFechaInicioViaje(gc.getTime());
			plan.setFechaSolicitud(new Date());
			plan.setIdClie(idCli);
			plan.setIdUsua(idUs);
			plan.setNombre(planDTO.getNombre());
			plan.setUsuCreador(planDTO.getUsuCreador());
			plan.setValorTotal(planDTO.getValorTotal());

		
			planService.guardarPlan(plan);

			return ResponseEntity.ok().body(plan);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@PutMapping("/actualizarPlan")
	public ResponseEntity<?> actualizarPlan(@RequestBody PlanDTO planDTO) {
		try {
			GregorianCalendar  gc = new GregorianCalendar(2021,06,12);
			GregorianCalendar  gc2 = new GregorianCalendar(2021,06,20);

			
			Cliente idCli = clienteService.consultarClientePorIdentificacion(planDTO.getNumeroIdClie());
			Usuario idUs = usuarioService.consultarUsuarioPorId(planDTO.getIdUsua());
			
			Plan plan = new Plan();
		    plan.setIdPlan(planDTO.getIdPlan());
			plan.setCantidadPersonas(planDTO.getCantidadPersonas());
			plan.setCodigo(planDTO.getCodigo());
			plan.setDescripcionSolicitud(planDTO.getDescripcionSolicitud());
			plan.setEstado(planDTO.getEstado());
			plan.setFechaCreacion(new Date());
			plan.setFechaFinViaje(gc2.getTime());
			plan.setFechaInicioViaje(gc.getTime());
			plan.setFechaSolicitud(new Date());
			plan.setIdClie(idCli);
			plan.setIdUsua(idUs);
			plan.setNombre(planDTO.getNombre());
			plan.setUsuCreador(planDTO.getUsuCreador());
			plan.setValorTotal(planDTO.getValorTotal());
			plan.setFechaModificacion(new Date());
			plan.setUsuModificador(planDTO.getUsuModificador());

		
			planService.actualizarPlan(plan);

			return ResponseEntity.ok().body(plan);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/eliminarPlan/{id}") // para recibir el id por la url
	public ResponseEntity<?> eliminarPlan(@PathVariable("id") Integer idPlan) { // el path variable es para
																						// decirle que me tome el id que
																						// le paso en la url
		try {
			Plan p = new Plan();
			p.setIdPlan(idPlan);
			planService.eliminarPlan(p);

			return ResponseEntity.ok().body("Se elimino satisfactoriamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
