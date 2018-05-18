package Financeiro;

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    Parcela[] parcelas;
    static Pmt pmt;

	Modalidade(String banco, float i) {
		this.banco = banco;
		this.i = i;
	}
	
	public static Modalidade criarSimulacao(String modalidade, String banco, float i) {
		Modalidade resposta = null;
		if (modalidade.equalsIgnoreCase("Price")) {
			resposta = new Price(banco, i);
			pmt = resposta.getPmt();
		}
		else 
			resposta = null;
		return resposta;
	}
	
	public Pmt getPmt() {
		return pmt;
	}

	public abstract float calcularPrestacoes() ;

	public void adicionarFinanciamento(Financiamento fin) {
		this.fin = fin;
	}

	public float calcularTotalJuros() {
		float juros = pmt.getJuros(fin);
		return juros;
	}
	
}
