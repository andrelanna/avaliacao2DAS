package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		//objeto que virou método objeto:
		CalculadorDePestacoes calculador = new CalculadorDePestacoes();
		
		// chamando um dos métodos do objeto método:
		float pmt_final = calculador.calcularPmtFinal(parcelas, fin, i);
		
		for (int aux=1; aux<= fin.getN(); aux++) {
			// chamando o segundo método do objeto método:
			calculador.calculaAmortizacaoEJuros(parcelas, fin,this.i, pmt_final, aux);
		}
		
		return pmt_final;
	}


}
