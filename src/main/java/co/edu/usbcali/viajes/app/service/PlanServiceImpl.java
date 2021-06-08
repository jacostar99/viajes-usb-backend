package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Plan;
		import co.edu.usbcali.viajes.app.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;
	
	@Override
	public void guardarPlan(Plan plan) throws Exception {
		
		Plan planDB = planRepository.findByCodigo(plan.getCodigo());
		if (planDB != null) {
			throw new Exception("Ya existe un plan con este codigo.");
		}
		
		if(plan.getCodigo() == null || plan.getCodigo().trim().equals("")) {
			throw new Exception("Ingrese un codigo valido");
			
		}
		
		if (plan.getNombre() == null || plan.getNombre().trim().equals("") || plan.getNombre().length() >100) {
			throw new Exception("Ingrese un nombre valido");			
		}
		
		if(plan.getCantidadPersonas() == null) {
			throw new Exception("Ingrese una cantidad valida");
			
		} 
		
		if(plan.getValorTotal() == null ) {
			throw new Exception("Ingrese un valor total ");
		}
		
		if (plan.getFechaSolicitud() == null) {
			throw new Exception("Ingrese una fecha valida");			
		}
		
		if(plan.getFechaCreacion() == null) {
			throw new Exception("Ingrese una fecha de creacion valida");
		}
		
		
		
		if(plan.getUsuCreador() == null || plan.getUsuCreador().trim().equals("") || plan.getUsuCreador().length() > 10) {
			throw new Exception("Ingrese un usuario creador valido");
		}
	    
		if(plan.getEstado() == null || plan.getEstado().trim().equals("")) {
			throw new Exception("Ingrese un estado valido");
		}
			
		if(plan.getIdClie() == null) {
			throw new Exception("Digite un id de cliente valido");
		}
		
		if(plan.getIdUsua() == null) {
			throw new Exception("Digite un id de usuario valido");
		}
		
		
		
		

		planRepository.save(plan);
		
	}

	@Override
	public void eliminarPlan(Plan plan) throws Exception {
		if(plan == null || plan.getIdPlan()== null) {
			throw new Exception("Se debe ingresar un plan a eliminar");
		}
		
		Optional <Plan> planDB = planRepository.findById(plan.getIdPlan());
		
		if(planDB.isPresent()) {
			planRepository.delete(planDB.get());
		} else {  
		throw new Exception("No existe un plan con ese id.");
		}
		
	}

	@Override
	public void actualizarPlan(Plan plan) throws Exception {
		
		if (plan.getIdPlan() == null) {
			throw new Exception("Debe ingresar un id de plan valido para actualizar.");
			
		}
		
		Optional <Plan> planBD = planRepository.findById(plan.getIdPlan());
		if(planBD.isEmpty()) {
			throw new Exception("No existe un plan con este id");
		}
		
		if(plan.getCodigo() == null || plan.getCodigo().trim().equals("")) {
			throw new Exception("Ingrese un codigo valido");
			
		}
		
		if (plan.getNombre() == null || plan.getNombre().trim().equals("") || plan.getNombre().length() >100) {
			throw new Exception("Ingrese un nombre valido");			
		}
		
		if(plan.getCantidadPersonas() == null) {
			throw new Exception("Ingrese una cantidad valida");
			
		} 
		
		if(plan.getValorTotal() == null ) {
			throw new Exception("Ingrese un valor total ");
		}
		
		if (plan.getFechaSolicitud() == null) {
			throw new Exception("Ingrese una fecha valida");			
		}
		
		if(plan.getFechaCreacion() == null) {
			throw new Exception("Ingrese una fecha de creacion valida");
		}
		
		if(plan.getFechaCreacion() == null) {
			throw new Exception("Ingrese una fecha de creacion valida");
		}
		
		if(plan.getUsuCreador() == null || plan.getUsuCreador().trim().equals("") || plan.getUsuCreador().length() > 10) {
			throw new Exception("Ingrese un usuario creador valido");
		}
	    
		if(plan.getEstado() == null || plan.getEstado().trim().equals("")) {
			throw new Exception("Ingrese un estado valido");
		}
		
		if(plan.getIdClie() == null) {
			throw new Exception("Digite un id de cliente valido");
		}
		
		if(plan.getIdUsua() == null) {
			throw new Exception("Digite un id de usuario valido");
		}
		
		planRepository.save(plan);
		
	}

	@Override
	public List<Plan> consultarPlan() throws Exception {
		List<Plan> listPlan = planRepository.findAll();

		if (listPlan.isEmpty()) {
			throw new Exception("No se encontraron planes en el sistema.");

		}
		return listPlan;
	}

	@Override
	public Plan consultarPlanPorCodigo(String codigo) throws Exception {
		Plan listPlan = planRepository.findByCodigo(codigo);
		if (listPlan == null) {
			throw new Exception("No existe ningun plan con este codigo.");

		}
		return listPlan;
	}

}
