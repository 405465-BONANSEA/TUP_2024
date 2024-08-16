package SpringEjemplo.SpringClase.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Personas")
@Data // GENERA GETTERS Y SETTERS y CONSTRUCTOR CON Y SIN PARAMETROS

public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;
    //TAMBIEN PUEDE SER @Column(name) PARA INDICAR EL NOMBRE DE LA COLUMNA DIRECTAMENTE
    //PUEDE HABER MAS ANOTACIONES PARA INDICAR MAS CARACTERISTICAS DE LA COLUMNA
    // POR EJEMPLO:
    // nullable = false(no puede ser null),
    // length = 50(largo del varchar)(si no se pone se toma el valor por defecto, osea 255 caracteres
    // unique = true(que no se repita el valor)


    @Column(name = "apellido")
    private String lastName;

    @Column(name = "edad")
    private int age;

    //SPRING LEVANTA DE FORMA ANTICIPADA TODOS LOS DATOS QUE HAY EN LA RELACION
    @ManyToOne (fetch = FetchType.EAGER)
    //LAZY LEVANTA LOS DATOS DE LA RELACION CUANDO SE LOS PIDE
    @JoinColumn (name = "carrera_id")
    @OnDelete(action = OnDeleteAction.CASCADE) //CUANDO SE BORRA UNA CARRERA SE BORRAN TODAS LAS PERSONAS QUE TIENEN ESA CARRERA
    private Career career;

}
