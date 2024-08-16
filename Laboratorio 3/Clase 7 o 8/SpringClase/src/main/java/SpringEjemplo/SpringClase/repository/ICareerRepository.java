package SpringEjemplo.SpringClase.repository;

import SpringEjemplo.SpringClase.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICareerRepository extends JpaRepository<Career, Long> {



}
