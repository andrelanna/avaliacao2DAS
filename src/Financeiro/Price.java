package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float primaryPmtCalculationParameter = (float) (Math.pow((1+i), fin.getN()) * i);
		final float secondaryPmtCalculationParameter = (float) (primaryPmtCalculationParameter/(Math.pow((1+i), fin.getN()) - 1));
		final float definitivePmtValue = fin.getPv() * secondaryPmtCalculationParameter;
		
		float a1 = definitivePmtValue - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = definitivePmtValue - amortizacao;
			Parcela p = new Parcela(definitivePmtValue, juros, amortizacao);
			parcelas[i-1] = p;
		}

		return definitivePmtValue;
	}
	
}
