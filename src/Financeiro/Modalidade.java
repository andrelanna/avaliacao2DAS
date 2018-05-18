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
	
	public Parcela[] getParcelas() {
		return this.parcelas;
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

	//  Passando esse método para a classe Financiamento, remove-se a possível indireção
	//  de modo que é necessário ter uma chamada de modalidade.parcela.[Atributo Desejado]
	public float calcularTotalJuros() {
		return fin.calcularTotalJuros();
	}

}
