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
	
	// Aqui, pelo entendimento da indireção, esta própria classe (Modalidade), possui
	// 	relação direta com Parcela, executando o método getJuros, por esse motivo, 
	//	a partir do meu entendimento, não há uma indireção, não há nenhum outro objeto 
	// 	se comunicando indiretamente para ter o valor dos juros, pois existe uma 
	// 	comunicação direta entre Modalidade e Parcela.
	// Caso a indireção seja interpretada para se ter o juros
	// 	diretamente na presente classe, poderia interferir em um dos princípios SOLID de 
	// 	responsabilidade única.
	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.getJuros();
		}
		return juros;
	}
	
}
