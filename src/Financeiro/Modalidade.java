package Financeiro;

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    Parcela[] parcelas;
    float totalJuros;

	Modalidade(String banco, float i) {
		this.banco = banco;
		this.i = i;
		this.totalJuros = 0;
	}
	
	public static Modalidade criarSimulacao(String modalidade, String banco, float i) {
		Modalidade resposta = null;
		if (modalidade.equalsIgnoreCase("Price"))
			resposta = new Price(banco, i);
		else 
			resposta = null;
		return resposta;
	}

	public abstract float calcularPrestacoes() ;

	public void adicionarFinanciamento(Financiamento fin) {
		this.fin = fin;
	}

	public void calcularTotalJuros(float juros) {
				totalJuros += juros;
			}
		
			public float getTotalJuros() {
				return totalJuros;
	}
	
}
