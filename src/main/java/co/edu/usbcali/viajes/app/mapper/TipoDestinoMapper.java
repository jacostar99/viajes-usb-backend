package co.edu.usbcali.viajes.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

//Anotacion para darle manejo como mapper
@Mapper(componentModel = "spring")
public interface TipoDestinoMapper {
	
	//Dependiendo del nombre el hace la implementacion del tipo origen a tipo destino, en este caso entra un tipo destino
    //y me retona un dto
	public TipoDestinoDTO tipoDestinoToTipoDestinoDto(TipoDestino tipoDestino);
	
	public TipoDestino tipoDestinoDTOToTipoDestino(TipoDestinoDTO tipoDestinoDTO);
	
	public List<TipoDestinoDTO> listTipoDestinoToListTipoDestinoDto(List <TipoDestino> tipoDestino);



}
