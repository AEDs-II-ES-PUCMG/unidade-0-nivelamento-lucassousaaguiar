public class ProdutoNaoPerecivel extends Produto {

    public ProdutoNaoPerecivel(String descricao, double precoCusto) {
        super(descricao, precoCusto);
    }

    public ProdutoNaoPerecivel(String descricao, double precoCusto, double margemLucro) {
        super(descricao, precoCusto, margemLucro);
    }

    @Override
    public double valorDeVenda() {
        return valorBase();
    }
}