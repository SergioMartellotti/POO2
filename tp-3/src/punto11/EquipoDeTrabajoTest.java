package punto11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class EquipoDeTrabajoTest {

	private EquipoDeTrabajo equipo;
	private Persona personaA;
	private Persona personaB;
	private Persona personaC;
	private Persona personaD;
	private Persona personaE;
	
	@Test
	void testPromedio() {
		equipo = new EquipoDeTrabajo("UNQ");
		personaA = new Persona("nombreA", "apellidoA", LocalDate.of(1990,1,1));
		personaB = new Persona("nombreB", "apellidoB", LocalDate.of(1995,1,1));
		personaC = new Persona("nombreC", "apellidoC", LocalDate.of(2000,1,1));
		personaD = new Persona("nombreD", "apellidoD", LocalDate.of(2005,1,1));
		personaE = new Persona("nombreE", "apellidoE", LocalDate.of(2010,1,1));
		equipo.agregarAEquipo(personaA);
		equipo.agregarAEquipo(personaB);
		equipo.agregarAEquipo(personaC);
		equipo.agregarAEquipo(personaD);
		equipo.agregarAEquipo(personaE);
		assertEquals(26, equipo.getPromedioEdad());
	}
	
	

}
