import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class ContratoService extends Contrato{
    private PagamentoOnline pagamentoOnline;

    public ContratoService(PagamentoOnline pagamentoOnline){
        this.pagamentoOnline = pagamentoOnline;
    }
    private Date addMonths(Date date, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
        }
    public void processaContrato(Contrato contrato, int meses){
    // primeira coisa é definir o valor de cada parcela
        double parcela = contrato.getValor_total()/meses;

        for(int i=1; i<=meses; i++){

            double parcelajuros = parcela + pagamentoOnline.juros(parcela,i);
            double parcelatotal = parcelajuros + pagamentoOnline.taxaDepagamento(contrato.getValor_total());

            Date data = addMonths(contrato.getData_contrato(), i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data_Formatada = sdf.format(data);
            System.out.println("Vencimento: "+ data_Formatada + " Valor: R$" + parcelatotal);
        }
    }
}
