package Financeiro;

public class Parcela {
	
	float pmt; 
	float juros; 
	float amortizacao;
	Modalidade _modalidade;
	
	public Parcela(float pmt, float juros, float amortizacao) {
		this.pmt = pmt;
		this.juros = juros;
		this.amortizacao = amortizacao;
	}
	
	public Modalidade getModalidade(){
		return _modalidade;
	}
	
	public void setModalidade(Modalidade arg){
		 _modalidade = arg;
	}
	
}
