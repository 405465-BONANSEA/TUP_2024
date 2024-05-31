package SpringEjemplo.SpringClase.repository;

import SpringEjemplo.SpringClase.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface IPersonaRepository extends JpaRepository<Persona, Long>
// antes en (JpaRepository<Persona, Long>)
// se le pasa la entidad y el tipo de dato de la clave primaria
{
Persona findByName(String name);
Persona findPersonaById(Long id);


}
