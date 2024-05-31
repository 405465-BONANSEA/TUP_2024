package SpringEjemplo.SpringClase.service.implementation;

import SpringEjemplo.SpringClase.domain.Persona;
import SpringEjemplo.SpringClase.repository.IPersonaRepository;
import SpringEjemplo.SpringClase.service.IPersonaService;

import java.util.List;
import java.util.Optional;

// @Service (podria estar aca o en la clase que implementa la interfaz IPersonaService, es indistinto)
public class PersonaServiceImplementation implements IPersonaService
{
    private final IPersonaRepository personaRepository;

    public PersonaServiceImplementation(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository ;
    }

    @Override
    public Persona insertPersona(Persona persona) {
        Persona insertedPersona = null;
        try {
             insertedPersona= personaRepository.save(persona); // se guarda la persona en la base de datos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertedPersona;
    }

    @Override
    public Persona updatePersona(Long id, Persona persona) {
        Optional<Persona> personaToUpdate = personaRepository.findById(id);
        if (personaToUpdate.isPresent()) {
            personaToUpdate.get().setName(persona.getName());
            personaToUpdate.get().setLastName(persona.getLastName());
            personaToUpdate.get().setAge(persona.getAge());
             return personaRepository.save(personaToUpdate.get());
        }
        else{
            //si no se encuentra la persona con el id pasado por parametro
            //se guarda la persona pasada por parametro con el id pasado por parametro
            //esto es para que no se cree un nuevo registro en la base de datos
            return personaRepository.save(persona);
        }

    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);

    }

    @Override
    public Persona findByName(String name) {
    return personaRepository.findByName(name);
    }

    @Override
    public List<Persona> listPersonas() {
        return List.of();
    }
}
