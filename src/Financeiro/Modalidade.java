package Financeiro;

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    Parcela[] _parcelas;

	Modalidade(String banco, float i) {
		this.banco = banco;
		this.i = i;
	}
	
	public static Modalidade criarSimulacao(String modalidade, String banco, float i) {
		Modalidade resposta = null;
		if (modalidade.equalsIgnoreCase("Price"))
			resposta = new Price(banco, i);
		else 
			resposta = null;
		return resposta;
	}
	public Parcela[] getParcelas() {
		return _parcelas;
	}

	public abstract float calcularPrestacoes();

	public void adicionarFinanciamento(Financiamento fin) {
		this.fin = fin;
	}

	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(getParcelas().length);
		for (Parcela p : getParcelas()) {
			juros += p.getJuros();
		}
		return juros;
	}
	
}
