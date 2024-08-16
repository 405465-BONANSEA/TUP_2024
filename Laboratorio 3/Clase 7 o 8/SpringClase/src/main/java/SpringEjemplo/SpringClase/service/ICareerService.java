package SpringEjemplo.SpringClase.service;

import SpringEjemplo.SpringClase.domain.Career;
import java.util.Optional;

import java.util.List;

public interface ICareerService {

    Career save(Career career);

    List<Career> findAll();

    Optional<Career> findById(Long id);

    void deleteById(Long id);
}
