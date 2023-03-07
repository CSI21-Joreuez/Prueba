package prueba2.edu.aplicacion.dto.todto;

import org.springframework.stereotype.Service;

import prueba2.edu.aplicacion.dto.alumnos_portatilesDTO;
import prueba2.edu.aplicacion.entidades.*;
/**
 * @author JOD
 * Interfaz que implementa la case aDTOServicio
 */
@Service
public class aDTOServicioImpl implements aDTOServicio {

	public alumnos_portatilesDTO alumnoADTO(String nombre, String telefono, portatiles num_port) {
		alumnos_portatilesDTO apDTO = new alumnos_portatilesDTO(nombre, telefono, num_port);
		return apDTO;
	}

	public alumnos_portatilesDTO portatilADTO(String marca, String modelo, int alumno_id) {
		alumnos_portatilesDTO paDTO = new alumnos_portatilesDTO(marca, modelo, alumno_id);
		return paDTO;
	}


}
