package prueba2.edu.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import prueba2.edu.aplicacion.dto.todao.aDAOServiceImpl;
import prueba2.edu.aplicacion.dto.todto.aDTOServicioImpl;
import prueba2.edu.aplicacion.entidades.alumnos;
import prueba2.edu.aplicacion.repositorios.alumnosRepo;
import prueba2.edu.aplicacion.servicios.ConsultasServiceImpl;

@Controller
public class PaginaControladora {
	

	
	@Autowired
	private ConsultasServiceImpl imp;
	
	protected final Log logger = LogFactory.getLog(getClass());
	Map<String, Object> miModelo= new HashMap<String,Object>();
	
	Iterable<alumnos> listaAlumnos =new ArrayList<alumnos>();
	
	String mensaje="Holaaaa Mundo";
	@RequestMapping(value="/formulario")
	public ModelAndView listar() {
		
	listaAlumnos=imp.listadoAlumnos();
			logger.info("Todo OK");	
			miModelo.put("listaAlumnos", listaAlumnos);
		return new ModelAndView("formulario", "miModelo", miModelo);
	}
}
