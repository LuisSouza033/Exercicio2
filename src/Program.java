import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Número do seu contrato: ");
        int numero = sc.nextInt();
        System.out.println("Data de hoje(dd/mm/yyyy): ");
        Date data = sdf.parse(sc.next());
        System.out.println("Valor desejado: ");
        double valorTotal = sc.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorTotal);

        System.out.println("Número de parcelas desejadas: ");
        int meses = sc.nextInt();

        ContratoService contService = new ContratoService(new Paypal());
        contService.processaContrato(contrato,meses);
    }
}
    