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
	
	
	// Não consegui encontrar uma indireção nesse método para que fosse possível aplicar
	// remover homem do meio, tendo em vista que a classe cliente (Modalidade) requer
	// algo (juros) de forma direta da classe Parcelas, ou seja, não há uma classe entre 
	// essas duas.
	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.getJuros();
		}
		return juros;
	}
	
}
