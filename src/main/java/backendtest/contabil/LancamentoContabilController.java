package backendtest.contabil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class LancamentoContabilController {

    @Autowired
    private LancamentoContabilService lancamentoContabilService;

    @RequestMapping(method = RequestMethod.POST, value = "/lancamentos-contabeis")
    public ResponseEntity cadastrarLancamentoContabil(@RequestBody LancamentoContabil lancamentoContabil){

        if(!informouTodosCampos(lancamentoContabil)){
            throw new RuntimeException("Favor informar todos os campos");
        }
        String codigo = lancamentoContabilService.cadastrarLancamentoContabil(lancamentoContabil);
        return ResponseEntity.status(HttpStatus.CREATED).body("Id: " + codigo);
    }


    @RequestMapping("/lancamentos-contabeis/{id}")
    public ResponseEntity buscarLancamentoContabilPorID(@PathVariable String id){

        LancamentoContabil lancamentoContabil = lancamentoContabilService.buscarLancamentoContabilPorID(id);
        if(lancamentoContabil == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoContabil);
    }


    @RequestMapping(value = "/lancamentos-contabeis")
    public ResponseEntity buscarLancamentoPorContaContabil(@RequestParam("contaContabil") String contaContabil){

        List<LancamentoContabil> list = lancamentoContabilService.buscarLancamentoPorContaContabil(contaContabil);
        if(ObjectUtils.isEmpty(list)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @RequestMapping(value = "/lancamentos-contabeis/_stats")
    public ResponseEntity buscarEstatisticas(@RequestParam("contaContabil") Optional<String> contaContabil){
        DoubleSummaryStatistics doubleSummaryStatistics = lancamentoContabilService.buscarEstatisticas(contaContabil);
        if(doubleSummaryStatistics.getCount() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estatistica nao calculada por falta de registro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doubleSummaryStatistics);
    }


    public boolean informouTodosCampos(LancamentoContabil lancamentoContabil){

        boolean informouTodos = Stream.of(lancamentoContabil.getContaContabil()
                ,lancamentoContabil.getValor()
                ,lancamentoContabil.getData()).allMatch(Objects::nonNull);

        if(informouTodos) {
            informouTodos = Stream.of(
                    lancamentoContabil.getContaContabil().getNumero()
                    , lancamentoContabil.getContaContabil().getDescricao()).noneMatch(String::isEmpty);
        }

        return informouTodos;
    }

}

