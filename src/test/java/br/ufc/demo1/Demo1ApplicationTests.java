package br.ufc.demo1;

import br.ufc.demo1.author.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class Demo1ApplicationTests {

	/*private MockMvc mockMvc;

	@Autowired
	private AuthorServiceImpl authorService;

	@InjectMocks
	AuthorController authorController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(authorController)
				.addFilters(new CorsFilter(null))
				.build();
	}

	@Test
	public void testGetAllSucess() {
		List<Author> authors = Arrays.asList(
				new Author(1, "Emerson", "Vieira"),
				new Author(2, "Teste", "Teste 2")
		);
		Mockito.when(authorService);

	}*/

}
