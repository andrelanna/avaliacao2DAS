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
	De acordo com minha percepção a única relação indireta presente nesse método é 
	a necessidade de chamar um método (getJuros();) da classe Parcela para que esse método 
	retorne o valor da variável juros, que seguindo os princípios básicos de OO
	é uma boa prática pois uma classe pública não deve oferecer acesso direto aos
	seus atributos, e sim através getters e setters, assim o programador não intefere de 
	maneira negativa na mutabilidade do atributo pois não consegue acessar o valor da 
	variável diretamente.

	Abaixo tem a minha resposta com o acesso direto à variável juros da classe Parcela.
	*/
	public float calcularTotalJuros() {
		float juros = 0;
		// System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.juros;
		}
		return juros;
	}
	
}
