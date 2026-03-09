import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProdutoPerecivel extends Produto {

    private static final double DESCONTO = 0.25;
    private static final int PRAZO_DESCONTO_DIAS = 7;

    private LocalDate validade;

    public ProdutoPerecivel(String descricao, double precoCusto, double margemLucro, LocalDate validade) {
        super(descricao, precoCusto, margemLucro);

        if (validade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Produto fora da validade.");
        }

        this.validade = validade;
    }

    @Override
    public double valorDeVenda() {

        if (validade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Produto vencido.");
        }

        double valor = valorBase();

        long diasParaVencer = ChronoUnit.DAYS.between(LocalDate.now(), validade);

        if (diasParaVencer <= PRAZO_DESCONTO_DIAS) {
            valor *= (1 - DESCONTO);
        }

        return valor;
    }
}