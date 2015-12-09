package ch.fhnw.webfr.flashcard.web;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.web.TestUtil.QuestionnaireBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestContext.class})
// WebAppConfiguration triggers WebMvcConfigurationSupport which enables all the default handler-mappings and handler-adapters
// needed for a spring mvc webapp
@WebAppConfiguration  
public class QuestionnaireControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
    private QuestionnaireRepository questionnaireRepositoryMock;

	@Before
    public void setUp() {
		Mockito.reset(questionnaireRepositoryMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	@Test
    public void findById_QuestionnaireFound_ShouldReturnFound() throws Exception {
		Questionnaire questionnaire = new QuestionnaireBuilder(1L)
				.description("MyDescription")
				.title("MyTitle")
				.build();
		
		when(questionnaireRepositoryMock.findOne(1L)).thenReturn(questionnaire);
		
	    mockMvc.perform(get("/questionnaires/{id}", 1L)
                .header("Accept", "application/json")
        )
        		//.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.id", is(1)))
        		.andExpect(jsonPath("$.title",is("MyTitle")))
        		.andExpect(jsonPath("$.description", is("MyDescription")));
    }
	
	@Test
    public void findById_QuestionnaireNotExisting_ShouldReturnNotFound() throws Exception {	
	    mockMvc.perform(get("/questionnaires/{id}", 2L)
                .header("Accept", "application/json")
        )
        		.andExpect(status().isNotFound());
    }	

}
