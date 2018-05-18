package Financeiro;

public class CalcularPrestacoes {}
	
  Parcela parcelas;
  Parcela p;

  float pmt;
  float pmt_calc;
  float pmt_final;
  float a1;
  float amortizacao;
  float juros;

  
  public CalcularPrestacoes(Parcela parcelas) {
		  this.parcelas = parcelas;
	}

	public float calculate() {
		pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		pmt_calc = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		pmt_final = fin.getPv() * pmt_calc;
		
		a1 = pmt_final - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			juros = pmt_final - amortizacao;
			p = new Parcela(pmt_final, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt_final;
	}
	
}
