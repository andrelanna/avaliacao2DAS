package Financeiro;

public class Calculadora {

  public float calcularPrestacoes(Price price) {
    price.parcelas = new Parcela[price.fin.getN()];

    // float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
    // pmt = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
    // pmt = fin.getPv() * pmt;

    float p_price1 = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
    float p_price2 = (float) (p_price1/(Math.pow((1+price.i), price.fin.getN()) - 1));
    float pmt = price.fin.getPv() * p_price2;

    float a1 = pmt - price.fin.getPv() * price.i;
    for (int i=1; i<= price.fin.getN(); i++) {
      float amortizacao = (float) (a1 * Math.pow((1+price.i), i-1));
      float juros = pmt - amortizacao;
      Parcela p = new Parcela(pmt, juros, amortizacao);
      price.parcelas[i-1] = p;
    }

    return pmt;
  }

}
