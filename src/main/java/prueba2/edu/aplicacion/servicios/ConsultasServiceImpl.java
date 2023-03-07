package prueba2.edu.aplicacion.servicios;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import prueba2.edu.aplicacion.entidades.alumnos;
import prueba2.edu.aplicacion.repositorios.alumnosRepo;

/**
 * @author JOD
 * ConsultasServiceImpl: Implementa la interfaz ConsultasService
 */
@Service
public class ConsultasServiceImpl implements ConsultasService {

	
	
	@Autowired
	private alumnosRepo psi;
	
	public Iterable<alumnos> listadoAlumnos() {
		try {
			Iterable<alumnos> listaAlumn = psi.findAll();
			return listaAlumn;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al mostrar el listado de alumnos: " + e);
			return null;
		}

	}





}
