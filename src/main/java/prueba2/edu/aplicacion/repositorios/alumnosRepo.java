package prueba2.edu.aplicacion.repositorios;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prueba2.edu.aplicacion.entidades.alumnos;

@Repository
public interface alumnosRepo extends CrudRepository<alumnos, Integer >{

}
