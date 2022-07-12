package springrest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SpringRestApplicationTests {

	//This annotaion allows to inject dependency implicitly (Allows for mock  objects)
	//@MockBean would be another option
	@Autowired
	private RestController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Autowired
	private TestRestTemplate restTemplate;
	//Allows to make rest calls
	@Autowired MockMvc mockMvc;
	@Test
	public void testHome(){
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

		String expected = "Hello from the Spring homepage";

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is(200));

		//assertThat(expected, result.getResponse())
				//.contains("Hello from the Spring homepage");
	}

}
