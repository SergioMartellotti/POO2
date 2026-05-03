package practico2;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        // 1. Crear la empresa
        Empresa empresa = new Empresa("Empresa S.A.", "30-12345678-9");
        
        // 2. Crear empleados permanentes
        
        // Empleado permanente 1: Casado con hijos
        EmpPermanente emp1 = new EmpPermanente(
            "Juan Perez",                    // nombre
            "Calle Falsa 123",               // direccion
            "casado",                        // estadoCivil
            LocalDate.of(1980, 5, 15),       // fechaNac
            100000f,                         // sueldoBasico
            2,                               // cantHijos
            10                               // antiguedad
        );
        
        // Empleado permanente 2: Soltero sin hijos
        EmpPermanente emp2 = new EmpPermanente(
            "Maria Lopez",                   // nombre
            "Avenida Siempre Viva 742",      // direccion
            "soltero",                       // estadoCivil
            LocalDate.of(1990, 3, 22),       // fechaNac
            85000f,                          // sueldoBasico
            0,                               // cantHijos
            5                                // antiguedad
        );
        
        // 3. Crear empleados temporarios
        
        // Empleado temporario 1: Joven, con horas extras
        EmpTemporario emp3 = new EmpTemporario(
            "Carlos Gomez",                  // nombre
            "Rivadavia 456",                 // direccion
            "soltero",                       // estadoCivil
            LocalDate.of(1995, 8, 10),       // fechaNac (29 años)
            75000f,                          // sueldoBasico
            LocalDate.of(2026, 12, 31),      // finDeDesignacion
            15                               // cantHorasExtra
        );
        
        // Empleado temporario 2: Mayor de 50 años, sin horas extras
        EmpTemporario emp4 = new EmpTemporario(
            "Ana Martinez",                  // nombre
            "San Martin 789",                // direccion
            "casada",                        // estadoCivil
            LocalDate.of(1970, 6, 20),       // fechaNac (55 años)
            90000f,                          // sueldoBasico
            LocalDate.of(2026, 12, 31),      // finDeDesignacion
            0                                // cantHorasExtra
        );
        
        // 4. Agregar empleados a la empresa
        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        empresa.agregarEmpleado(emp4);
        
        // 5. Mostrar información antes de liquidar
        System.out.println("========================================");
        System.out.println("Empresa: " + empresa.nombre);
        System.out.println("CUIT: " + empresa.cuit);
        System.out.println("========================================\n");
        
        System.out.println("--- EMPLEADOS CARGADOS ---");
        System.out.println("Permanentes:");
        System.out.println("  - Juan Perez (casado, 2 hijos, 10 años antigüedad)");
        System.out.println("  - Maria Lopez (soltera, sin hijos, 5 años antigüedad)");
        System.out.println("Temporarios:");
        System.out.println("  - Carlos Gomez (29 años, 15 horas extras)");
        System.out.println("  - Ana Martinez (55 años, sin horas extras)");
        System.out.println();
        
        // 6. Calcular y mostrar totales antes de liquidar
        System.out.println("--- TOTALES PREVIOS ---");
        System.out.printf("Suma de Sueldos Brutos: $%.2f%n", empresa.sumaDeBrutos());
        System.out.printf("Suma de Retenciones:    $%.2f%n", empresa.sumaDeRetenciones());
        System.out.printf("Suma de Sueldos Netos:  $%.2f%n", empresa.sumaDeNetos());
        System.out.println();
        
        // 7. Liquidar sueldos (genera los archivos .txt)
        System.out.println("--- LIQUIDANDO SUELDOS ---");
        empresa.liquidarSueldos();
        System.out.println("Liquidación completada. Archivos generados:");
        System.out.println("  - Juan Perez.txt");
        System.out.println("  - Maria Lopez.txt");
        System.out.println("  - Carlos Gomez.txt");
        System.out.println("  - Ana Martinez.txt");
        
        // 8. Mostrar resultados individuales en consola
        System.out.println("\n--- DETALLE POR EMPLEADO ---");
        
        // Permanente 1: Juan Perez
        System.out.println("\n[Juan Perez - Permanente]");
        System.out.printf("  Sueldo Bruto: $%.2f%n", emp1.sueldoBruto());
        System.out.printf("  Retenciones: $%.2f%n", emp1.retenciones());
        System.out.printf("  Sueldo Neto: $%.2f%n", emp1.sueldoNeto());
        System.out.println("  Conceptos de Bruto:");
        for (Concepto c : emp1.getConceptosSueldoBruto()) {
            System.out.printf("    - %s: $%.2f%n", c.getNombre(), c.getMonto());
        }
        
        // Permanente 2: Maria Lopez
        System.out.println("\n[Maria Lopez - Permanente]");
        System.out.printf("  Sueldo Bruto: $%.2f%n", emp2.sueldoBruto());
        System.out.printf("  Retenciones: $%.2f%n", emp2.retenciones());
        System.out.printf("  Sueldo Neto: $%.2f%n", emp2.sueldoNeto());
        
        // Temporario 1: Carlos Gomez
        System.out.println("\n[Carlos Gomez - Temporario]");
        System.out.printf("  Edad: %d años%n", emp3.getEdad());
        System.out.printf("  Sueldo Bruto: $%.2f%n", emp3.sueldoBruto());
        System.out.printf("  Retenciones: $%.2f%n", emp3.retenciones());
        System.out.printf("  Sueldo Neto: $%.2f%n", emp3.sueldoNeto());
        System.out.println("  Conceptos de Bruto:");
        for (Concepto c : emp3.getConceptosSueldoBruto()) {
            System.out.printf("    - %s: $%.2f%n", c.getNombre(), c.getMonto());
        }
        
        // Temporario 2: Ana Martinez
        System.out.println("\n[Ana Martinez - Temporario]");
        System.out.printf("  Edad: %d años%n", emp4.getEdad());
        System.out.printf("  Sueldo Bruto: $%.2f%n", emp4.sueldoBruto());
        System.out.printf("  Retenciones: $%.2f%n", emp4.retenciones());
        System.out.printf("  Sueldo Neto: $%.2f%n", emp4.sueldoNeto());
        
        // 9. Mostrar totales finales
        System.out.println("\n========================================");
        System.out.println("RESUMEN FINAL DE LA EMPRESA");
        System.out.println("========================================");
        System.out.printf("Total Empleados: %d%n", empresa.empleados.size());
        System.out.printf("Total Sueldos Brutos: $%.2f%n", empresa.sumaDeBrutos());
        System.out.printf("Total Retenciones:    $%.2f%n", empresa.sumaDeRetenciones());
        System.out.printf("Total Sueldos Netos:  $%.2f%n", empresa.sumaDeNetos());
        System.out.println("========================================");
    }
}