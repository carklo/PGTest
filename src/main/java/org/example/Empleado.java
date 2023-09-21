package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {

    private int id;
    private String nombre;
    private float montoMensual;
    private boolean activo;

    public boolean esActivoValido()  {
        return id != 0 && !nombre.isEmpty() && activo && montoMensual > 0;
    }
}
