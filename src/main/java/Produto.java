import java.text.NumberFormat;
import java.util.Locale;

public abstract class Produto {

    public static final double MARGEM_PADRAO = 0.2;

    protected String descricao;
    protected double precoCusto;
    protected double margemLucro;

    public Produto(String descricao, double precoCusto) {
        this(descricao, precoCusto, MARGEM_PADRAO);
    }

    public Produto(String descricao, double precoCusto, double margemLucro) {
        if (precoCusto < 0) {
            throw new IllegalArgumentException("Preço de custo não pode ser negativo.");
        }
        if (margemLucro < 0) {
            throw new IllegalArgumentException("Margem de lucro não pode ser negativa.");
        }
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro;
    }

    public double valorBase() {
        return precoCusto * (1 + margemLucro);
    }

    public abstract double valorDeVenda();

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return descricao + " - " + nf.format(valorDeVenda());
    }
}