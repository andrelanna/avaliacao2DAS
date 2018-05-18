package Financeiro;

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    public Parcela[] parcelas;

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
	 * Argumentação para questão (3) inválida da prova:
	 * 
	 *  	Remover Homem do Meio é uma técnica que exige ao menos 3 classes se relacionando.
	 * 	Ela propõe que a indireção que uma segunda classe esta fazendo pode ser refatorada, dando
	 * 	acesso da terceira classe a primeira classe.
	 * 
	 * Referencia: https://andrelanna.github.io/lectures/das/Catalogo_Refatoracao_movendo_caracteristicas.pdf
	 * Pág. 14
	 * 
	 * 		O argumento é que nesse método 'float calcularTotalJuros()' possua apenas a relação
	 * 	Modalidade -> Parcela.
	 * 	
	 * 		Que no contexto possui objetivo de retornar a soma dos juros das Parcelas de Modalidade.  
	 * 
	 * 		Caso a própria função seja encarada como Homem do Meio, o atributo parcelas deveria se tornar
	 * 	público para que o cálculo de juros seja realizado por fora e o método calcularTotalJuros seria extinto. 
	 *  Mas isso degradaria encapsulamento desnecessariamente. Como essa é a única alternativa encontrada será
	 *  adotada. 
	 * 	
	 *  ** No caso como não há uma class "client" que teria o contato indirecionado, será feito no próprio teste.
	 * 
	 * 
	 * 	** Mas volto a afirmar essa questão deveria ser invalidada...
	 */
	
//	public float calcularTotalJuros() {
//		float juros = 0;
//		System.out.println(parcelas.length);
//		for (Parcela p : parcelas) {
//			juros += p.getJuros();
//		}
//		return juros;
//	}
	
}
