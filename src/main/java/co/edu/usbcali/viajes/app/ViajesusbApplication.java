package co.edu.usbcali.viajes.app;

	import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;
import co.edu.usbcali.viajes.app.repository.ClienteRepository;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajes.app.service.ClienteService;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;
import co.edu.usbcali.viajes.app.utils.Constantes;

/*Es la primera clase que se ejecuta al levantar el proyecto,
Esta clase lo que hace es escanear todos los componentes y arrobas,para saber cuantos jpa repository
y cuantas entidades hay y componentes de spring que tenga */

@SpringBootApplication
public class ViajesusbApplication implements CommandLineRunner { // al levantar el programa corre primero el metodo run

	@Autowired // inyeccion de dependencia, si no viene nulo, se le asigna
	// espacio en memoria para poder utilizar la variable private
	private TipoDestinoRepository tipoDestinoRepository; // variable para hacer la
	// inyeccion de dependencias

	@Autowired
	private DestinoRepository destinoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	@Autowired
	private TipoDestinoService tipoDestinoService;

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TipoIdentificacionService tipoIdService;

	public static void main(String[] args) {
		SpringApplication.run(ViajesusbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ------HECHOS EN CLASE------------
		/*
		 * consultarTiposDestino(); // sirve 
		 * guardarDestino(); // sirve
		 * eliminarDestino(); // sirve 
		 * actualizarDestino(); // sirve //
		 * --------------CLIENTES----------- 
		 * guardarCliente(); // sirve
		 * consultarClientes(); // sirve 
		 * actualizarCliente(); // sirve
		 * eliminarCliente(); // sirve 
		 * existeClienteId(1); // sirve 
		 * contarCliente(); // sirve 
		 * encontrarClientePorIds(); 
		 * // -------TIPO IDENTIFICACION-------
		 * guardarTipoIdentificacion(); // sirve 
		 * consultarAllTipoIdentificacion(); //sirve 
		 * actualizarTipoIdentificacion(); // sirve 
		 * eliminarTipoIdentificacion(); // sirve 
		 * existeTipoIdentificacionId(2); //sirve //
		 * contarTipoIdentificacion(); //sirve // 
		 * encontrarTiposIdentificacionPorIds(); //sirve
		 * 
		 * // contarTipoDestino(); 
		 * // todosOrdenados(); 
		 * // eliminarTodosDestino(); //OJO METODO PELIGROSO !!!! 
		 * // consultarTiposDestinosPaginados(); 
		 *findByFechaCreacionBetween(); 
		 * // consultarDestinoTipoDestino(); //
		 * ----------------------------------------TAREA--------------------------------
		 * --------
		 * 
		 * /* System.out.println("--------------Consultar los tipo de identificacion, ordenados, sin paginador---------------------"); 
		 * consultarTipoIdOrdenados();// SIRVE 
		 * System.out.println("--------------Consultar los tipo de identificacion, ordenados, sin paginador CON QUERY METHODS---"); 
		 * consultarTipoIdOrdenadosF2();// SIRVE 
		 * System.out.println("-------------------Consultar clientES, paginado, ordenado por identificacion---------------------"); 
		 * consultarCliPaginadoOrdId();// SIRVE 
		 * System.out.println("-------------------Consultar clientes, paginado, ordenado por identificacion CON QUERY METHODS---"); 
		 * findByEstadoOrderByNumeroIdentificacionAsc(); // SIRVE 
		 * System.out.println("------------------------Consultar cliente por numero de identificacion--------------------------"); 
		 * findByNumeroIdentificacion();// SIRVE 
		 * System.out.println("--------------------------------Consultar cliente por correo------------------------------------"); 
		 * findByCorreo();// SIRVE 
		 * System.out.println("------------------------------Consultar cliente por estado--------------------------------------"); 
		 * findByEstado();// SIRVE System.out.println("----------------------------Consultar cliente por nombre usando like----------------------------"); 
		 * findByNombreLike();// SIRVE 
		 * System.out.println("--Consultar clientes entre un rango de fechas (fecha de nacimiento), identificacion (usando like) y tipo identificacion por codigo (ej:cc)---"); 
		 * consultarClientePorOrm();
		 */
		consultarClientePorOrm();
		//--------------TAREA CRUD'S - ABRIL 6--------------
		//-------------- DESTINO ----------------
		//consultarDestinoServ();
		//eliminarDestinoServ();
		//guardarDestinoServ();
		//actualizarDestinoServ();
		
		//----------------TIPO DESTINO------------
		//consultarTipoDestinoServ();
		//guardarTipoDestinoServ();
		//eliminarTipoDestinoServ();
		//actualizarTipoDestinoServ();
		
		//----------------CLIENTE------------------
		//consultarClienteServ();
		//guardarClienteServ();
		//eliminarClienteServ();
		//actualizarClienteServ();
		
		//-------------TIPO IDENTIFICACION---------
		//consultarTipoIdentificacionServ();
		//guardarTipoIdentificacionServ();
		//eliminarTipoIdentificacionServ();
		//actualizarTipoIdentificacionServ();

	}

	/*
	 * Metodo para consultar todos los tipos de destino del sistema
	 * 
	 * Lo primero que hay que saber es que ya se tienen los repositorios que tienen
	 * unos metodos por defecto tipoDestinoRepository se llama atraves de inyeccion
	 * de dependencias
	 */
	// ---------------------------------------------------------------------------------------------------------------------------------
	private void consultarTiposDestino() {
		// Consultar todos los tipos de destino , va hasta la bd y me trae los datos
		// En realidad el find all por debajo hace una consulta sql es un Select * de
		// tipo destino.
		/*
		 * List<TipoDestino> listTipoDestino = tipoDestinoRepository.findAll(); // me
		 * retorna una lista de tipoDestino for (TipoDestino tipoDestino :
		 * listTipoDestino) { System.out.println("Tipo destino: " +
		 * tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
		 * 
		 * }
		 */
		List<TipoDestino> listTipoDestino = null;
		try {
			listTipoDestino = tipoDestinoService.consultarTipoDestino();
			for (TipoDestino tipoDestino : listTipoDestino) {
				System.out.println("Tipo destino: " + tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
			}
		} catch (Exception e) {
			// muestra el mensaje del error que esta en la clase TipoDestinoServiceImpl
			System.out.println(e.getMessage());
		}
	}

	// Metodo para guardar un destino
	private void guardarDestino() {

		try {
			// Se consulta el tipo de destino
			TipoDestino tide = buscarTipoDestinoPorId(2); // llame al metodo, pasele un 2, va al tipoDestinoRepository y
															// me
															// busca al 2

			Destino destino = new Destino();
			destino.setAire(Constantes.SI);
			destino.setCodigo("CARTG");
			destino.setDescripcion("Destino Cartagena");
			destino.setEstado(Constantes.ACTIVO);
			destino.setFechaCreacion(new Date()); // fecha actual
			destino.setMar(Constantes.SI);
			destino.setNombre("Cartagena");
			destino.setTierra(Constantes.NO);
			destino.setUsuCreador("JACOSTAR");
			destino.setTipoDestino(tide); // hay que poner el objeto tipo destino

			destinoService.guardarDestino(destino);// destinoRepository.save(destino); // le paso la entidad destino
			System.out.println("¡Destino creado satisfactoriamente!");
			// .save para guardarlo , por debajo hace un insert

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	// Metodo para buscar un tipo de destino por su id
	private TipoDestino buscarTipoDestinoPorId(Integer id) {

		// Optional para indicar que puede que traiga algo o no
		Optional<TipoDestino> tipoDestino = tipoDestinoRepository.findById(id);

		if (tipoDestino.isPresent()) {
			return tipoDestino.get(); // si esta, retorneme ese tipo destino
		} else {
			return null;
		}
	}

	// Metodo para eliminar un destino
	private void eliminarDestino() {

		// consulto el destino por su id
		Optional<Destino> destino = destinoRepository.findById(1);
		if (destino.isPresent()) {
			destinoRepository.delete(destino.get());

		}

	}

	// Metodo para actualizar un destino
	private void actualizarDestino() {

		Optional<Destino> optional = destinoRepository.findById(1);

		Destino destino = optional.get(); // aqui ya esta el objeto con toda su informacion

		System.out.println("Destino inicial: " + destino.getCodigo() + destino.getNombre());

		destino.setNombre("Prueba update");
		destino.setFechaModificacion(new Date());
		destino.setUsuModificador("JACOSTAR");

		destinoRepository.save(destino); // por debajo en el save valida si la entidad es nueva inserte si es nuevo
											// actualiza, revisa para saber si es nuevo que el objeto no tenga id

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// Metodo para guardar un cliente
	private void guardarCliente() {

		TipoIdentificacion tiIde = buscarTipoIdentificacionPorId(1);
		Calendar fechaNacimient = new GregorianCalendar(1990, 2, 15);

		Cliente cliente = new Cliente();
		cliente.setCorreo("prueba6@hotmail.com");
		cliente.setEstado(Constantes.ACTIVO);
		cliente.setFechaCreacion(new Date());
		cliente.setFechaNacimiento(fechaNacimient.getTime());
		cliente.setNombre("Sebastian");
		cliente.setNumeroIdentificacion("1994223993");
		cliente.setPrimerApellido("Belalcazar");
		cliente.setSexo(Constantes.MASCULINO);
		cliente.setTelefono1("5554512");
		cliente.setTiId(tiIde);
		cliente.setUsuCreador("JACOSTAR");

		clienteRepository.save(cliente);
		System.out.println("¡Cliente insertado con exito!");

	}

	// Metodo para buscar un tipo de identificacion por su id
	private TipoIdentificacion buscarTipoIdentificacionPorId(Integer id) {
		// Optional para indicar que puede que traiga algo o no
		Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionRepository.findById(id);

		if (tipoIdentificacion.isPresent()) {
			return tipoIdentificacion.get(); // si esta, retorneme ese cliente
		} else {
			return null;
		}

	}

	// Metodo para eliminar un cliente
	private void eliminarCliente() {
		// consulto el cliente por su id
		Optional<Cliente> cliente = clienteRepository.findById(1);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());

		}

	}

	// Metodo para actualizar un cliente
	private void actualizarCliente() {

		Optional<Cliente> optional = clienteRepository.findById(6);

		Cliente cliente = optional.get(); // aqui ya esta el objeto con toda su informacion

		System.out.println("Cliente inicial: " + cliente.getNombre() + cliente.getPrimerApellido());

		Calendar fechaNac = new GregorianCalendar(2003, 5, 20);
		// cliente.setNombre("Victor update");
		cliente.setFechaModificacion(new Date());
		cliente.setFechaNacimiento(fechaNac.getTime());
		cliente.setUsuModificador("JACOSTAR");

		clienteRepository.save(cliente); // por debajo en el save valida si la entidad es nueva inserte si es nuevo
											// actualiza, revisa para saber si es nuevo que el objeto no tenga id
		System.out.println("¡Cliente actualizado con exito!");
	}

	// Metodo para consultar la lista de clientes
	private void consultarClientes() {

		List<Cliente> listClientes = clienteRepository.findAll(); // me retorna una lista de tipoDestino
		for (Cliente cliente : listClientes) {
			System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido());

		}

	}
	// ---------------------------------------------------------------------------------------------------------------------------------

	// Metodo para guardar un tipo de identificacion
	private void guardarTipoIdentificacion() {

		TipoIdentificacion tiId = new TipoIdentificacion();
		tiId.setCodigo("CP");
		tiId.setEstado(Constantes.ACTIVO);
		tiId.setFechaCreacion(new Date());
		tiId.setNombre("Cedula Prueba");
		tiId.setUsuCreador("JACOSTAR");

		tipoIdentificacionRepository.save(tiId);
		System.out.println("¡Tipo de identificacion insertada con exito!");

	}

	// Metodo para eliminar tipo de identificacion
	private void eliminarTipoIdentificacion() {
		// consulto el tipo identificacion por su id
		Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionRepository.findById(6);
		if (tipoIdentificacion.isPresent()) {
			tipoIdentificacionRepository.delete(tipoIdentificacion.get());

		}

	}

	// Metodo para actualizar un tipo de identificacion
	private void actualizarTipoIdentificacion() {

		Optional<TipoIdentificacion> optional = tipoIdentificacionRepository.findById(7);

		TipoIdentificacion tipoIdentificacion = optional.get(); // aqui ya esta el objeto con toda su informacion

		System.out.println("Tipo Identificacion inicial: " + tipoIdentificacion.getNombre());

		tipoIdentificacion.setNombre("Cedula UPDATE");
		tipoIdentificacion.setFechaModificacion(new Date());
		tipoIdentificacion.setUsuModificador("JACOSTAR");

		tipoIdentificacionRepository.save(tipoIdentificacion); // por debajo en el save valida si la entidad es nueva
																// inserte si es nuevo
		// actualiza, revisa para saber si es nuevo que el objeto no tenga id
		System.out.println("¡Tipo identificacion actualizado con exito!");

	}

	// Metodo para consultar todos los tipos de identificacion
	private void consultarAllTipoIdentificacion() {
		List<TipoIdentificacion> listTipoIdentificacion = tipoIdentificacionRepository.findAll(); // me retorna una
																									// lista de
																									// tipoIdenti
		for (TipoIdentificacion tipoIdentificacion : listTipoIdentificacion) {
			System.out.println("Tipo identificacion: " + tipoIdentificacion.getNombre());

		}

	}

	// Metodo que me retorna un true or false si encuentra un cliente por su id
	private void existeClienteId(Integer id) {

		boolean existe = clienteRepository.existsById(id);
		System.out.println("Cliente existe? " + existe);
	}

	// Metodo que me retorna un true or false si encuentra un tipo de identificacion
	// por su id
	private void existeTipoIdentificacionId(Integer id) {

		boolean existe = tipoIdentificacionRepository.existsById(id);
		System.out.println("Tipo identificaicon existe? " + existe);
	}

	// Metodo para contar la cantidad de clientes que hay en la bd
	private void contarCliente() {

		Long cantidad = clienteRepository.count();
		System.out.println("Existen " + cantidad + " clientes");
	}

	// Metodo para contar la cantidad de tipos de id que hay en la bd
	private void contarTipoIdentificacion() {

		Long cantidad = tipoIdentificacionRepository.count();
		System.out.println("Existen " + cantidad + " tipos de identificacion");
	}

	// Metodo para consultar todos los destinos
	private void consultarDestinos() {
		List<Destino> listDestino = destinoRepository.findAll(); // me retorna una lista de destinos

		if (listDestino != null && listDestino.isEmpty()) {
			for (Destino destino : listDestino) {
				System.out.println("Tipo destino: " + destino.getCodigo() + " - " + destino.getNombre());

			}

		} else {
			System.out.println("No hay destinos");
		}
	}

	// Eliminar todos los datos de una tabla
	private void eliminarTodosDestino() {
		destinoRepository.deleteAll();
	}

	// Contar todos los tipos de destino
	private void contarTipoDestino() {
		Long cantidad = tipoDestinoRepository.count(); // cuenteme la cantidad de registros que hay en tipodestino
		System.out.println("Existen " + cantidad + " tipos de destino");
	};

	// Metodo para consultar varios clientes por sus id, guardo los ids en una lista
	// y esa lista la paso al findAllById
	private void encontrarClientePorIds() {

		// Se crea la lista de los ids
		List<Integer> idsCli = new LinkedList<Integer>();

		idsCli.add(1);

		Iterable<Cliente> listCliente = clienteRepository.findAllById(idsCli);

		for (Cliente cliente : listCliente) {
			System.out.println("Cliente : " + cliente.getNombre());
		}
	}

	// Metodo para consultar varios tipo de id por sus id, guardo los ids en una
	// lista y esa lista la paso al findAllById
	private void encontrarTiposIdentificacionPorIds() {

		// Se crea la lista de los ids
		List<Integer> idsTiId = new LinkedList<Integer>();

		idsTiId.add(2);
		idsTiId.add(3);
		idsTiId.add(4);

		Iterable<TipoIdentificacion> listTiposIdentificacion = tipoIdentificacionRepository.findAllById(idsTiId);

		for (TipoIdentificacion tiId : listTiposIdentificacion) {
			System.out.println("Tipo identificacion: " + tiId.getNombre());
		}
	}

	// -----------------------------------Paginador y
	// ordenamiento------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------

	// me trae todos los tipos de destino ordenados por el codigo que es el atributo
	// que le paso en el Sort.by...
	private void todosOrdenados() {
		List<TipoDestino> listTiposDestino = tipoDestinoRepository.findAll(Sort.by("codigo"));

		if (listTiposDestino != null && !listTiposDestino.isEmpty()) {
			for (TipoDestino tipoDestino : listTiposDestino) {
				System.out.println("Tipo destino: " + tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());

			}

		} else {
			System.out.println("No hay destinos");
		}
	}

	/*
	 * Para evitar tiempos excesivos de carga(casos donde se tengan una cantidad muy
	 * grande de datos) se usa el paginador para ir mostrando cierta cada de datos
	 * por pantalla sort --> ordenamiento por el atributo que yo le pase al
	 * PageRequest le digo que pagina quiero y cuantos items por pagina y que me lo
	 * ordene por algun atributo
	 */
	private void consultarTiposDestinosPaginados() {
		// 0 para la primera pagina,1 para la 2da , etc
		Page<TipoDestino> pageTipoDestino = tipoDestinoRepository.findAll(PageRequest.of(0, 3, Sort.by("codigo")));

		for (TipoDestino tipoDestino : pageTipoDestino) {
			System.out.println(tipoDestino.getCodigo());

		}
		System.out.println("Total de registros" + pageTipoDestino.getTotalElements());
		System.out.println("Total de paginas" + pageTipoDestino.getTotalPages());

	}

	// Consultar un tipo de destino que este en el rango de una fecha
	public void findByFechaCreacionBetween() {

		// para manejar fechas se puede con date o calendar
		// los meses en date o calendar empiezan por 0, es decir enero = mes 0,
		// diciembre = mes 11,
		Calendar fechaInicio = new GregorianCalendar(2022, 0, 1);
		Calendar fechaFin = new GregorianCalendar(2022, 3, 1);

		// getTime() para que el calendar me devuelva en el formato que lo pide el Date
		List<TipoDestino> listTipoDestino = tipoDestinoRepository.findByFechaCreacionBetween(fechaInicio.getTime(),
				fechaFin.getTime());

		for (TipoDestino tipoDest : listTipoDestino) {
			System.out.println("Tipo destino: " + tipoDest.getCodigo());

		}
	}

	private void consultarDestinoTipoDestino() {

		List<Destino> listDestino = destinoRepository.findByTipoDestino_Codigo("PLAYA");

		for (Destino destino : listDestino) {
			System.out.println("Destino: " + destino.getNombre());
		}

	}

	/*
	 * Los query methods, son metodos para encontrar informacio en la bd y se
	 * declaran en la interfaz del repositorio metodos permiten hacer consultar por
	 * medio del nombre del metodo, osea con el nombre del metodo se arma una
	 * sentencia sql con los parametros que recibe, ej public TipoDestino
	 * findByCodigo("pCodigo")String codigo), el nombre del metodo SIEMPRE debe
	 * estar compuesto por findBy---> select * from, seguido del atributo por el que
	 * quiero buscar findByCodigo y un parametro;
	 */

	// ------------------------------------------------------------------------------------------------------------------------------
	// Consultar los tipo de identificacion, ordenados, sin paginador
	private void consultarTipoIdOrdenados() {
		// List de tipo tipoidentificacion para guardar todos los tipos de
		// identificacion, los ordeno por el codigo con el Sort.by
		List<TipoIdentificacion> listTipoId = tipoIdentificacionRepository.findAll(Sort.by("codigo"));

		if (!listTipoId.isEmpty()) {
			for (TipoIdentificacion tipoId : listTipoId) {
				System.out.println("Tipo identificacion: " + tipoId.getCodigo() + " - " + tipoId.getNombre());
			}
		}

	}

	// Consultar los tipo de identificacion, ordenados, sin paginador Con el query
	// method
	private void consultarTipoIdOrdenadosF2() {
		List<TipoIdentificacion> listTipoId = tipoIdentificacionRepository
				.findByEstadoOrderByCodigoAsc(Constantes.ACTIVO);
		// valido que la lista no esta vacia
		if (!listTipoId.isEmpty()) {
			for (TipoIdentificacion tipoId : listTipoId) {
				System.out.println("Tipo identificacion: " + tipoId.getCodigo());
			}
		} else {
			System.out.println("No hay datos en la lista");
		}

	}

	// Consultar clientes, paginado, ordenado por identificacion
	private void consultarCliPaginadoOrdId() {
		/*
		 * De tipo Page ya que me retonar una Page con los parametros que yo le
		 * pase,primer numero el numero de la pagina segundo numero la cantidad de datos
		 * que quiero por cada pagina y el sort,by para ordenar esos datos por el numero
		 * de id
		 */
		Page<Cliente> listCliente = clienteRepository.findAll(PageRequest.of(0, 2, Sort.by("numeroIdentificacion")));

		if (!listCliente.isEmpty()) {
			for (Cliente cli : listCliente) {
				System.out.println("Cliente: " + cli.getNumeroIdentificacion() + " - " + cli.getNombre());

			}
		} else {
			System.out.println("No hay datos.");
		}

	}

	// CON QUERY METHOD --->Consultar clientes, paginado, ordenado por
	// identificacion
	private void findByEstadoOrderByNumeroIdentificacionAsc() {
		Page<Cliente> listCliente = clienteRepository.findByEstadoOrderByNumeroIdentificacionAsc(PageRequest.of(0, 2),
				Constantes.ACTIVO);
		if (!listCliente.isEmpty()) {
			for (Cliente cli : listCliente) {
				System.out.println("Cliente: " + cli.getNumeroIdentificacion() + " - " + cli.getNombre());

			}
		} else {
			System.out.println("No hay datos.");
		}
	}

	// Consultar clientes por numero de identificacion
	/*private void findByNumeroIdentificacion() {
		Cliente cli = clienteRepository.findByNumeroIdentificacion("9154299993");
		System.out.println("Cliente: " + cli.getNombre() + " - " + cli.getNumeroIdentificacion());
		/*
		 * List<Cliente> listCliente =
		 * clienteRepository.findByNumeroIdentificacion("9154299993");
		 * 
		 * for (Cliente cli : listCliente) { System.out.println("Cliente: " +
		 * cli.getNombre() + " - " + cli.getNumeroIdentificacion()); }
		 */

	//}

	// Consultar cliente por correo
	private void findByCorreo() {
		Cliente cli = clienteRepository.findByCorreo("prueba5@hotmail.com");
		System.out.println("Cliente: " + cli.getNombre() + " - " + cli.getCorreo());

		/*
		 * List<Cliente> listCliente =
		 * clienteRepository.findByCorreo("prueba5@hotmail.com");
		 * 
		 * for (Cliente cli : listCliente) { System.out.println("Cliente: " +
		 * cli.getNombre() + " - " + cli.getNumeroIdentificacion()); }
		 */
	}

	// Consultar cliente por estado
	private void findByEstado() {
		List<Cliente> listClientes = clienteRepository.findByEstado(Constantes.ACTIVO);
		if (!listClientes.isEmpty()) {
			for (Cliente cli : listClientes) {
				System.out.println("Cliente: " + cli.getNombre() + " - Estado: " + cli.getEstado());

			}
		} else {
			System.out.println("No hay datos en la lista.");
		}

	}

	// Consultar cliente por nombre usando like (query method)
	private void findByNombreLike() {
		List<Cliente> listClientes = clienteRepository.findByNombreLike("Cristian");
		if (!listClientes.isEmpty()) {
			for (Cliente cli : listClientes) {
				System.out.println("Cliente: " + cli.getNombre());

			}
		} else {
			System.out.println("No hay datos en la lista.");
		}

	}

	// Consultar cliente con rango de fechas de nacimiento,con un numero de
	// identificacion, y con un tipo de identificacion por ej = CC
	private void consultarClientePorOrm() {
		// Calendar para pasarle las fechas que al darle getTime() me devuelve en
		// formato Date
		Calendar fechaInicio = new GregorianCalendar(1990, 11, 24);
		Calendar fechaInicioC = new GregorianCalendar(2020, 3, 5);
		// Atributos para pasarle al metodo de la consulta
		String numeroId = "%1234%";
		String codigoId = "CC";
		List<ClienteDTO> listCliente = clienteRepository.consultaOrm(fechaInicio.getTime(), fechaInicioC.getTime(),
				numeroId, codigoId);
		if (!listCliente.isEmpty()) {
			for (ClienteDTO cliente : listCliente) {
				System.out.println("Cliente: " + cliente.getNombre() + ", Apellido: " + cliente.getPrimerApellido()
						+ ", Fecha nacimiento " + cliente.getFechaNacimiento() + ", Numero id: "
						+ cliente.getNumeroIdentificacion());
			}
		} else {
			System.out.println("No hay datos en la lista.");
		}
	}

	// --------------------------------------------------------------TAREA-----------------------------------------------------------
	// -------Destino

	// Consultar los destinos
	public void consultarDestinoServ() {
		List<Destino> listDestino = null;
		try {
			listDestino = destinoService.consultarDestino();
			for (Destino destino : listDestino) {
				System.out.println("Destino: " + destino.getCodigo() + " - " + destino.getNombre());
			}
		} catch (Exception e) {
			// muestra el mensaje del error que esta en la clase TipoDestinoServiceImpl
			System.out.println(e.getMessage());
		}

	}

	// Eliminar destino
	public void eliminarDestinoServ() {
		try {
			Optional<Destino> destino = destinoService.consultarDestinoPorCodigo(8);
			destinoService.eliminarDestino(destino.get());
			System.out.println("Destino eliminado.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Guardar destino
	public void guardarDestinoServ() {
		try {
			// Se consulta el tipo de destino
			TipoDestino tide = buscarTipoDestinoPorId(2); // llame al metodo, pasele un 2, va al tipoDestinoRepository y
															// me
															// busca al 2

			Destino destino = new Destino();
			destino.setAire(Constantes.SI);
			destino.setCodigo("CALI");
			destino.setDescripcion("Destino Cali");
			destino.setEstado(Constantes.ACTIVO);
			destino.setFechaCreacion(new Date()); // fecha actual
			destino.setMar(Constantes.SI);
			destino.setNombre("Cali");
			destino.setTierra(Constantes.NO);
			destino.setUsuCreador("JACOSTAR");
			destino.setTipoDestino(tide); // hay que poner el objeto tipo destino

			destinoService.guardarDestino(destino);// destinoRepository.save(destino); // le paso la entidad destino
			System.out.println("¡Destino creado satisfactoriamente!");
			// .save para guardarlo , por debajo hace un insert

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	// Actualizar destino
	public void actualizarDestinoServ() {
		try {
			Optional<Destino> optional = destinoService.consultarDestinoPorCodigo(8);

			Destino destino = optional.get(); // aqui ya esta el objeto con toda su informacion


			destino.setNombre("Act prueba");
			destino.setFechaModificacion(new Date());
			destino.setUsuModificador("JACOSTAR");

			destinoService.actualizarDestino(destino);
			System.out.println("¡Destino actualizado correctamente!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

	// -------TipoDestino
	
	//Consultar tipos de destino
	public void consultarTipoDestinoServ() {
		List<TipoDestino> listTipoDestino = null;
		try {
			listTipoDestino = tipoDestinoService.consultarTipoDestino();
			for (TipoDestino tipoDestino : listTipoDestino) {
				System.out.println("Tipo destino: " + tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
			}
		} catch (Exception e) {
			// muestra el mensaje del error que esta en la clase TipoDestinoServiceImpl
			System.out.println(e.getMessage());
		}

	}
    
	//Eliminar tipo de destino
	public void eliminarTipoDestinoServ() {
		try {
			Optional<TipoDestino> tipoDestino = tipoDestinoService.consultarTipoDestinoPorCodigo(12);
			tipoDestinoService.eliminarTipoDestino(tipoDestino.get());
			System.out.println("Tipo Destino eliminado.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    
	//Guardar tipo de destino
	public void guardarTipoDestinoServ() {
		try {
			
			TipoDestino tipoDestino = new TipoDestino();
			tipoDestino.setNombre("PRUEBA");
			tipoDestino.setCodigo("PRB");
			tipoDestino.setDescripcion("DESTINO PARA PRUEBA");
			tipoDestino.setFechaCreacion(new Date());
			tipoDestino.setUsuCreador("JACOSTAR");
			tipoDestino.setEstado(Constantes.ACTIVO);
			tipoDestinoService.guardarTipoDestino(tipoDestino);
			
			System.out.println("¡Tipo de destino guardado satisfactoriamente!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    
	//Actualizar tipo de destino
	public void actualizarTipoDestinoServ() {
		try {
			Optional<TipoDestino> optional = tipoDestinoService.consultarTipoDestinoPorCodigo(12);

			TipoDestino tipoDestino = optional.get(); // aqui ya esta el objeto con toda su informacion


			tipoDestino.setNombre("Act tipodest");
			tipoDestino.setFechaModificacion(new Date());
			tipoDestino.setUsuModificador("JACOSTAR");

			tipoDestinoService.actualizarTipoDestino(tipoDestino);
			System.out.println("¡Tipo destino actualizado correctamente!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

	// -------Cliente
	
	//Consultar clientes
	public void consultarClienteServ() {
		List<Cliente> listCliente = null;
		try {
			listCliente = clienteService.consultarCliente();
			for (Cliente cliente: listCliente) {
				System.out.println("Cliente:  " + cliente.getNombre() + " - " + cliente.getPrimerApellido());
			}
		} catch (Exception e) {
			// muestra el mensaje del error que esta en la clase TipoDestinoServiceImpl
			System.out.println(e.getMessage());
		}

	}
    
	//Eliminar cliente
	public void eliminarClienteServ() {
		try {
			Optional<Cliente> cliente = clienteService.consultarClientePorCodigo(4);
			clienteService.eliminarCliente(cliente.get());
			System.out.println("Cliente eliminado.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
    
	//Guardar cliente
	public void guardarClienteServ() {
		try {
			TipoIdentificacion tiIde = buscarTipoIdentificacionPorId(1);
			Calendar fechaNacimient = new GregorianCalendar(1992, 3, 14);

			Cliente cliente = new Cliente();
			cliente.setCorreo("prueba2@hotmail.com");
			cliente.setEstado(Constantes.ACTIVO);
			cliente.setFechaCreacion(new Date());
			cliente.setFechaNacimiento(fechaNacimient.getTime());
			cliente.setNombre("Pedro");
			cliente.setNumeroIdentificacion("3282893921");
			cliente.setPrimerApellido("Suarez");
			cliente.setSexo(Constantes.MASCULINO);
			cliente.setTelefono1("9929321");
			cliente.setTiId(tiIde);
			cliente.setUsuCreador("JACOSTAR");

			clienteService.guardarCliente(cliente);
			System.out.println("¡Cliente insertado con exito!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    
	//Actualizar cliente
	public void actualizarClienteServ() {
		try {
			Optional<Cliente> optional =  clienteService.consultarClientePorCodigo(11);

			Cliente cliente = optional.get(); // aqui ya esta el objeto con toda su informacion


		
			cliente.setNombre("Pruebasa");
			//cliente.setFechaModificacion(new Date());
			//cliente.setUsuModificador("JACOSTAR");

			clienteService.guardarCliente(cliente);// por debajo en el save valida si la entidad es nueva inserte si es nuevo
												// actualiza, revisa para saber si es nuevo que el objeto no tenga id
			System.out.println("¡Cliente actualizado con exito!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	// -------TipoIdentificacion
	
	//Consultar tipos de identificacion
	public void consultarTipoIdentificacionServ() {
		List<TipoIdentificacion> listTipoId = null;
		try {
			listTipoId = tipoIdService.consultarTipoIdentificacion();
			for (TipoIdentificacion tipoId: listTipoId) {
				System.out.println("Tipo identificacion:  " + tipoId.getNombre());
			}
		} catch (Exception e) {
			// muestra el mensaje del error que esta en la clase TipoDestinoServiceImpl
			System.out.println(e.getMessage());
		}

	}
    
	//Eliminar tipo de identificacion
	public void eliminarTipoIdentificacionServ() {
		try {
			Optional<TipoIdentificacion> tipoIdentificacion = tipoIdService.consultarTipoIdentificacionPorCodigo(10);
			tipoIdService.eliminarTipoIdentificacion(tipoIdentificacion.get());
			System.out.println("Tipo identificacion eliminado.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    
	//Guardar tipo de identificacion
	public void guardarTipoIdentificacionServ() {
		try {
			TipoIdentificacion tiId = new TipoIdentificacion();
			tiId.setCodigo("TIP");
			tiId.setEstado(Constantes.ACTIVO);
			tiId.setFechaCreacion(new Date());
			tiId.setNombre("Tarjeta prueba");
			tiId.setUsuCreador("JACOSTAR");

			tipoIdService.guardarTipoIdentificacion(tiId);
			System.out.println("¡Tipo de identificacion insertada con exito!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    //...........................................................................................................................
	//Actualizar tipo de identificacion
	public void actualizarTipoIdentificacionServ() {
		try {
			Optional<TipoIdentificacion> optional = tipoIdService.consultarTipoIdentificacionPorCodigo(10);

			TipoIdentificacion tipoIdentificacion = optional.get(); // aqui ya esta el objeto con toda su informacion


			tipoIdentificacion.setNombre("Act prueba");
			tipoIdentificacion.setFechaModificacion(new Date());
			tipoIdentificacion.setUsuModificador("JACOSTAR");

			tipoIdService.guardarTipoIdentificacion(tipoIdentificacion); // por debajo en el save valida si la entidad es nueva
																	// inserte si es nuevo
			// actualiza, revisa para saber si es nuevo que el objeto no tenga id
			System.out.println("¡Tipo identificacion actualizado con exito!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
