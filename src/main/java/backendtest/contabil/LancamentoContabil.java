package backendtest.contabil;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class LancamentoContabil {

    @JsonIgnore
    private String id;
    private LocalDate data;
    private Double valor;
    private ContaContabil contaContabil;

    public LancamentoContabil() {
    }


    public LancamentoContabil(String id, LocalDate data, Double valor, ContaContabil contaContabil) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.contaContabil = contaContabil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContaContabil getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(ContaContabil contaContabil) {
        this.contaContabil = contaContabil;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
