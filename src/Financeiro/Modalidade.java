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

	public float calcularTotalJuros() {
		
		
		// Interpretando o problema
		/*
		 * Para que exista um "Homem do meio", é preciso que haja uma
		 * classe intermediando o acesso da Modalidade à Parcela.
		 * Como A modalidade é capaz de acessar o juros de cada
		 * parcela diretamente, considero que não há um middle man.
		 * 
		 * Obs: A Modalidade não é um Middle Man porque
		 * o método "calcularTotalJuros" não é chamado em nenhuma
		 * outra classe (apenas no teste), logo, a Modalidade é a
		 * Classe Cliente da situação.
		 * 
		 */
		
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.getJuros();
		}
		return juros;
	}
	
}
