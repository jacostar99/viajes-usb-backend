package co.edu.usbcali.viajes.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;

@Mapper(componentModel = "spring")
public interface DestinoMapper {
	
	@Mapping(source = "tipoDestino.idTide" , target = "tipoDestinoId")
	public DestinoDTO destinoToDestinoDTO(Destino destino);
	
	
	public Destino destinoDToDestino(DestinoDTO destinoDTO);

}
