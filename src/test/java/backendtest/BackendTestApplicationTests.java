package backendtest;


import backendtest.contabil.ContaContabil;
import backendtest.contabil.LancamentoContabil;
import backendtest.contabil.LancamentoContabilController;
import backendtest.contabil.LancamentoContabilService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendTestApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private LancamentoContabilController lancamentoContabilController;

	@MockBean
	private LancamentoContabilService lancamentoContabilService;

	@Autowired
	ObjectMapper objectMapper;

	private LancamentoContabil lancamentoContabil;

	@Before
	public void setUp()throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(lancamentoContabilController).build();
		ContaContabil contaContabil = new ContaContabil("12522", "Descricao contaContabil");
		lancamentoContabil = new LancamentoContabil("1", LocalDate.of(2018, 10, 10),Double.valueOf(20), contaContabil);
	}

	@Test
	public void testBuscarLancamentoContabilPorIdInexistente () throws Exception{
		mockMvc.perform(get("/lancamentos-contabeis/20")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(content().string("Registro nao encontrado"));
	}

	@Test
	public void testCadastrarLancamentoContabil () throws Exception{

		Mockito.when(lancamentoContabilService.cadastrarLancamentoContabil(
				Mockito.any(LancamentoContabil.class))).thenReturn("1");
		mockMvc.perform(post("/lancamentos-contabeis/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(lancamentoContabil)))
				.andExpect(status().isCreated())
				.andExpect(content().string("Id: 1"));
	}

	@Test
	public void testBuscarLancamentoContabilPorID () throws Exception{

		Mockito.when(lancamentoContabilService.buscarLancamentoContabilPorID(
				Mockito.anyString())).thenReturn(lancamentoContabil);
		mockMvc.perform(get("/lancamentos-contabeis/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.contaContabil.numero", Matchers.is("12522")));
	}

	@Test
	public void testBuscarLancamentoPorContaContabil () throws Exception{

		Mockito.when(lancamentoContabilService.buscarLancamentoPorContaContabil(
				Mockito.anyString())).thenReturn(Arrays.asList(lancamentoContabil));
		mockMvc.perform(get("/lancamentos-contabeis/?contaContabil=12522")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].contaContabil.numero", Matchers.is("12522")));
	}

	@Test
	public void testBuscarLancamentoPorContaContabilNaoExistente () throws Exception{

		Mockito.when(lancamentoContabilService.buscarLancamentoPorContaContabil(
				Mockito.anyString())).thenReturn(null);
		mockMvc.perform(get("/lancamentos-contabeis/?contaContabil=12522")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(content().string("Registro nao encontrado"));
	}

	@Test
	public void testBuscarEstatisticas() throws Exception {

		List<LancamentoContabil> list = Arrays.asList(lancamentoContabil);
		DoubleSummaryStatistics statistics = list.stream()
				.mapToDouble((l) -> l.getValor())
				.summaryStatistics();

		Mockito.when(lancamentoContabilService.buscarEstatisticas(Optional.of("120012"))).thenReturn(statistics);

		mockMvc.perform(get("/lancamentos-contabeis/_stats?contaContabil=120012")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().json("{'count':1,'sum':20.0,'min':20.0,'max':20.0,'average':20.0}"));
	}

}
