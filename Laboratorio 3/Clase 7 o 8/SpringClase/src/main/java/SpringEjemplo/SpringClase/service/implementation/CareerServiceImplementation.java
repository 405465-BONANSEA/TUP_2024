package SpringEjemplo.SpringClase.service.implementation;

import SpringEjemplo.SpringClase.domain.Career;
import SpringEjemplo.SpringClase.service.ICareerService;

import java.util.List;
import java.util.Optional;

public class CareerServiceImplementation implements ICareerService {
    @Override
    public Career save(Career career) {
        return  carrera
    }

    @Override
    public List<Career> findAll() {
        return List.of();
    }

    @Override
    public Optional<Career> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
