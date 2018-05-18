
import static org.junit.Assert.*;

import financeiroExceptions.PrestacaoMaiorQueMargemException;
import org.junit.Test;

public class TstInformacoesFinanciamento {

	
	@Test
	public void testeInformarDadosFinanciamento() throws PrestacaoMaiorQueMargemException {
			Financiamento f = Financiamento.criarFinanciamento(10000f, 12, 2000);
			assertNotNull(f);
	}
	
	@Test(expected = PrestacaoMaiorQueMargemException.class)
	public void testeInformarDadosFinanciamentoInvalido() throws PrestacaoMaiorQueMargemException {
		Financiamento f = Financiamento.criarFinanciamento(10000f, 12, 600);
	}

}
