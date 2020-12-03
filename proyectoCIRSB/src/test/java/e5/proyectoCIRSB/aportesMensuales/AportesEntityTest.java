package e5.proyectoCIRSB.aportesMensuales;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AportesEntityTest {

	@Autowired
	AportesEntity aportes = new AportesEntity();
	
	@Test
	void test() {
		float valor = aportes.getvalor();
		Date fecha = aportes.getFecha(); 
	}
	
	@Test
	void Fecha () {
		Date date = new Date(2016,5,3);
		Date date2 = new Date(2019,5,3);
		
		Boolean resultado = aportes.setFecha(date);
		Boolean resultado1 = aportes.setFecha(date2);
		
		assertTrue(resultado1);
		assertFalse(resultado);
		
	}
	
	@Test
	void Valor () {
		
		Boolean valor = aportes.setvalor(-1);
		Boolean valor2 = aportes.setvalor(1);
		
		assertFalse(valor);
		assertTrue(valor2);
		
	}
}
