package Financeiro; 

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    Parcela[] parcelas;

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

	public abstract float calcularPrestacoes() ;

	public void adicionarFinanciamento(Financiamento fin) {
		this.fin = fin;
	}
	
	public float getJuros(Parcela parcela){
		return parcela.getJuros();
	}

	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += getJuros(p);
		}
		return juros;
	}
	
}
