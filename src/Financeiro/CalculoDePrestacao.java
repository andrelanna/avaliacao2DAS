package Financeiro;

public class CalculoDePrestacao {
	private final Price price;
	private float primaryPmtCalculationParameter;
	private float secondaryPmtCalculationParameter;
	private float definitivePmtValue;
	private float a1;
	private float amortizacao;
	private float juros;
	private Parcela p;

	CalculoDePrestacao(Price price) {
		this.price = price;
	}

	public float calcular() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		primaryPmtCalculationParameter = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
		secondaryPmtCalculationParameter = (float) (primaryPmtCalculationParameter/(Math.pow((1+price.i), price.fin.getN()) - 1));
		definitivePmtValue = price.fin.getPv() * secondaryPmtCalculationParameter;
		
		a1 = definitivePmtValue - price.fin.getPv() * price.i;

		for (int i=1; i<= price.fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+this.price.i), i-1));
			juros = definitivePmtValue - amortizacao;
			p = new Parcela(definitivePmtValue, juros, amortizacao);
			price.parcelas[i-1] = p;
		}

		return definitivePmtValue;
	}
}
