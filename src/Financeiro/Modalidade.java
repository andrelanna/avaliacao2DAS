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

	/*
	 * Nessa classe fica um pouco complicado de observar uma idireção de fato, que é a ideia da
	 * aplicação do método de Remoter o homem do meio. Ao meu ver, a única alternativa seria
	 * acessar diretamente o juros do objeto p sem a utilização do método getJuros(), mesmo isso
	 * não sendo uma prática comúm na POO (acesso direto aos atributos de uma instância).
	 */
	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.juros;
		}
		return juros;
	}
	
}
