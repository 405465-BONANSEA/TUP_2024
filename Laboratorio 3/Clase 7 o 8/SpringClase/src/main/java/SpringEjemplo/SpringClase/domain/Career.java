package SpringEjemplo.SpringClase.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Carreras")
@Data
public class Career {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "catedra")
    private String professorship;
}
