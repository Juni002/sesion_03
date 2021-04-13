package Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Alumno {

    private int alumno;
    private String nomnbre;
    private String apellido;
    private Double pension;
    private String carrera;
}
