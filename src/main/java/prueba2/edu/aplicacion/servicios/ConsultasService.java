package prueba2.edu.aplicacion.servicios;



import prueba2.edu.aplicacion.entidades.*;
import prueba2.edu.aplicacion.repositorios.alumnosRepo;

/**
 * @author JOD
 * Consultas: Interfaz que define los métodos específicos de consulta sobre base de datos.
 */

public interface ConsultasService {

	/**
	 * darAltaAlumno: Inserta en base de datos un nuevo Alumno
	 * @param nuevo alumno
	 */

	 
	public Iterable<alumnos> listadoAlumnos();
	
	/**
	 * listarAlumnoConPortatil: lista los alumnos
	 * @param int alumno id
	 * @return lista de alumnos con un portatil especifico
	 */
	

}
