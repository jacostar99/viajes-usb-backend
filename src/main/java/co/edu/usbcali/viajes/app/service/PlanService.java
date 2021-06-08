package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.Plan;

public interface PlanService {
	
	public void guardarPlan(Plan plan) throws Exception;

	public void eliminarPlan(Plan plan) throws Exception;

	public void actualizarPlan(Plan plan) throws Exception;

	public List<Plan> consultarPlan() throws Exception;

	public Plan consultarPlanPorCodigo(String codigo) throws Exception;
	
    
	
}
