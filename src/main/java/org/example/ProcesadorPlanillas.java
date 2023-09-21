package org.example;

import lombok.NoArgsConstructor;

import java.util.List;

public class ProcesadorPlanillas {

    private final ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;

    public ProcesadorPlanillas(ProveedorMiembrosPlanilla proveedorMiembrosPlanilla) {
        this.proveedorMiembrosPlanilla = proveedorMiembrosPlanilla;
    }

    public float calcularPlanilla() {
        List<Empleado> empleados = proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla();
        return (float) empleados.stream().filter(Empleado::esActivoValido).mapToDouble(Empleado::getMontoMensual).sum();
    }
}
