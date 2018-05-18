package Financeiro;

public class Parcela {
	
	float pmt; 
	float juros; 
	float amortizacao;
	
	public Parcela(float pmt, float juros, float amortizacao) {
		this.pmt = pmt;
		this.juros = juros;
		this.amortizacao = amortizacao;
	}

	public Parcela() {
		// TODO Auto-generated constructor stub
	}

	public float getJuros() {
		return juros;
	}
	
	public float calcularTotalJuros(Modalidade modalidade) {
		float juros = 0;
		System.out.println(modalidade.parcelas.length);
		for (Parcela p : modalidade.parcelas) {
			juros += p.getJuros();
		}
		return juros;
	}
}
