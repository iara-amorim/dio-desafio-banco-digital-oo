import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    protected double valor;
    protected String tipo;
    protected String dataHora;
    protected String descritivo;

    Transacao(String tipo, double valor, String descritivo) {
        this.tipo = tipo;
        this.valor = valor;
        this.descritivo = descritivo;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        dataHora = LocalDateTime.now().format(df);
    }

    public String toString() {
        String linha = "";
        linha += dataHora + ' ';
        linha += tipo;
        linha += ' ' + String.format("%.2f", this.valor);
        linha += ' ' + this.descritivo;
        return linha;
    }

}
