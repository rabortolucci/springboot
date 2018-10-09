package backendtest.contabil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LancamentoContabilService {

    private List<LancamentoContabil> lancamentosContabeis = new ArrayList<>();
    private static AtomicLong idContador = new AtomicLong();

    public static String criarID() {
        return String.valueOf(idContador.incrementAndGet());
    }

    public String cadastrarLancamentoContabil(LancamentoContabil lancamentoContabil){
        lancamentoContabil.setId(criarID());
        lancamentosContabeis.add(lancamentoContabil);
        return lancamentoContabil.getId();
    }

    public LancamentoContabil buscarLancamentoContabilPorID(String id){
        return lancamentosContabeis.stream()
                .filter(l -> l.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public List<LancamentoContabil> buscarLancamentoPorContaContabil(String contaContabil){
        return lancamentosContabeis.stream()
                .filter(l -> l.getContaContabil().getNumero().equals(contaContabil))
                .collect(Collectors.toList());
    }

    public DoubleSummaryStatistics buscarEstatisticas(Optional parametro){

        List<LancamentoContabil> listLancamentoContabil = lancamentosContabeis;

        if(parametro.isPresent()){
            listLancamentoContabil = lancamentosContabeis.stream()
                    .filter(l -> l.getContaContabil().getNumero().equals(parametro.get())).collect(Collectors.toList());
        }

        DoubleSummaryStatistics estatisticas = listLancamentoContabil.stream()
                .mapToDouble((l) -> l.getValor())
                .summaryStatistics();

        return estatisticas;
    }


}
