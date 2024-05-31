package SpringEjemplo.SpringClase.controller;

import SpringEjemplo.SpringClase.domain.Persona;
import SpringEjemplo.SpringClase.service.IPersonaService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/persona")
    public ResponseEntity<Persona> insertPersona(Persona persona) {
        Persona result=personaService.insertPersona(persona);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
    }

    @PutMapping("/persona/{id}")
    public Persona updatePersona(@PathVariable Long id, Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/persona/all")
    public List<Persona> listPersonas() {
       return personaService.listPersonas();
    }

    @GetMapping("/persona")
    public Persona findByName(String name) {
       return personaService.findByName(name);
    }

    @GetMapping("/persona/{id}")
    public Persona findById(@PathVariable Long id) {
        return personaService.findById(id).orElse(null);
    }

}
