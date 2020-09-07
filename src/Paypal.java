public class Paypal implements PagamentoOnline{
    final double taxaPaypal = 0.01;

    @Override
    public double taxaDepagamento(double valor) {
       double totalt = valor* 0.02;
       return totalt;
    }

    @Override
    public double juros(double valor, int meses) {
       return valor * 0.1 * meses;
    }
}
