package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		float pmt_calc = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		float pmt_final = fin.getPv() * pmt_calc;
		
		float a1 = pmt_final - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt_final - amortizacao;
			Parcela p = new Parcela(pmt_final, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt_final;
	}

	// depois da refatoracao da questao 2
	
	// Parcela parcelas = new Parcela[fin.getN()];
	// CalcularPrestacoes calculoPrestacoes = new CalcularPrestacoes(parcelas);

	// public float calcularPrestacoes() {
	// 	float pmt_final = calcularPrestacoes.calculate(parcelas);
	// 	return pmt_final
	// }

	
}
