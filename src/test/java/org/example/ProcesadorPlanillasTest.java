package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProcesadorPlanillasTest {

    private ProcesadorPlanillas procesadorPlanillas;

    private List<Empleado> empleadosCase1;
    private List<Empleado> empleadosCase2;

    private List<Empleado> empleadosCase3;
    private List<Empleado> empleadosCase4;

    private ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;

    @BeforeEach
    void setUp() {
        Empleado empleado0 = Empleado.builder().id(0).activo(true).montoMensual(10.2f).build();
        Empleado empleado1 = Empleado.builder().id(1).nombre("Juan").activo(true).montoMensual(3.2f).build();
        Empleado empleado2 = Empleado.builder().id(2).nombre("Jose").activo(true).montoMensual(5.4f).build();
        Empleado empleado3 = Empleado.builder().id(3).nombre("Maria").activo(true).montoMensual(4.4f).build();
        Empleado empleado4 = Empleado.builder().id(4).nombre("").activo(true).montoMensual(0f).build();
        Empleado empleado5 = Empleado.builder().id(5).nombre("Reinaldo").activo(false).montoMensual(6.1f).build();
        Empleado empleado6 = Empleado.builder().id(6).nombre("Rene").activo(true).montoMensual(-1.2f).build();
        proveedorMiembrosPlanilla = mock(ProveedorMiembrosPlanilla.class);
        procesadorPlanillas = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        empleadosCase1 = List.of(empleado1, empleado2, empleado3, empleado5);
        empleadosCase2 = List.of(empleado0, empleado1, empleado2, empleado3, empleado5);
        empleadosCase3 = List.of(empleado4, empleado1, empleado2, empleado3, empleado5);
        empleadosCase4 = List.of(empleado6, empleado1, empleado2, empleado3, empleado5);
    }

    @Test
    void calcularPlanillaCase1Test() {
        when(proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla()).thenReturn(empleadosCase1);
        Assertions.assertEquals(13f, procesadorPlanillas.calcularPlanilla());
    }

    @Test
    void calcularPlanillaCase2Test() {
        when(proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla()).thenReturn(empleadosCase2);
        Assertions.assertEquals(13f, procesadorPlanillas.calcularPlanilla());
    }

    @Test
    void calcularPlanillaCase3Test() {
        when(proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla()).thenReturn(empleadosCase3);
        Assertions.assertEquals(13f, procesadorPlanillas.calcularPlanilla());
    }

    @Test
    void calcularPlanillaCase4Test() {
        when(proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla()).thenReturn(empleadosCase4);
        Assertions.assertEquals(13f, procesadorPlanillas.calcularPlanilla());
    }
}