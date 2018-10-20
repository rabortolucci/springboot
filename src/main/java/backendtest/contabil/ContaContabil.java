package backendtest.contabil;

public class ContaContabil {

    private String numero;
    private String descricao;

    public ContaContabil(){

    }

    public ContaContabil(String numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
