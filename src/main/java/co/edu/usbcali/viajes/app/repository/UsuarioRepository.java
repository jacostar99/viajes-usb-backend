package co.edu.usbcali.viajes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByIdentificacion(String identificacion);
	
    public Usuario findByIdUsua(Integer id);
    
    public Usuario findByLogin(String login);


}
