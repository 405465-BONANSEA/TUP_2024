package SpringEjemplo.SpringClase.service;

import SpringEjemplo.SpringClase.domain.Persona;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface IPersonaService
{
    Persona insertPersona(Persona persona);

    Persona updatePersona(Long id, Persona persona);

    void deleteById(Long id);

    Optional<Persona> findById(Long id);

    Persona findByName(String name);

    List<Persona> listPersonas();

}
