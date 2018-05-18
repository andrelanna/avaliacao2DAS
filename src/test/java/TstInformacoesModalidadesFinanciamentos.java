
import static org.junit.Assert.*;

import org.junit.Test;

public class TstInformacoesModalidadesFinanciamentos {

	@Test
	public void testeCriacaoFinanciamentoPrice() {
		Modalidade m = Modalidade.criarSimulacao("Price", "Banco X", 2.0f);
		assertNotNull(m);
	}
	

}
