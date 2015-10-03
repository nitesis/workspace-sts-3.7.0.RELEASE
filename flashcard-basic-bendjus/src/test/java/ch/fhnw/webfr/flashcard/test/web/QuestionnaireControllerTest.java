package ch.fhnw.webfr.flashcard.test.web;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.test.web.TestUtil.QuestionnaireBuilder;

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
    public void findAll_QuestionnairesFound_ShouldReturnFound() throws Exception {
		Questionnaire q1 = new QuestionnaireBuilder(1L)
				.description("MyDescription 1")
				.title("MyTitle 1")
				.build();
		
		Questionnaire q2 = new QuestionnaireBuilder(2L)
				.description("MyDescription 2")
				.title("MyTitle 2")
				.build();

		when(questionnaireRepositoryMock.findAll()).thenReturn(Arrays.asList(q1, q2));
		
	    mockMvc.perform(get("/questionnaires")
        )
        		.andExpect(status().isOk())
        		.andExpect(view().name("/questionnaires"))
        		.andExpect(model().attributeExists("questionnaire"))
        		.andExpect(model().attribute("questionnaires", hasSize(2)))
        		.andExpect(model().attribute("questionnaires", hasItem(
        				allOf(
        						hasProperty("id", is(1l)),
        						hasProperty("title", is("MyTitle 1")),
        						hasProperty("description", is("MyDescription 1"))
        				)
        		)))
        		.andExpect(model().attribute("questionnaires", hasItem(
        				allOf(
        						hasProperty("id", is(2l)),
        						hasProperty("title", is("MyTitle 2")),
        						hasProperty("description", is("MyDescription 2"))
        				)
        		)));
    }
	
	@Test
	public void create_NewQuestionnaire_ShouldReturnOK() throws Exception {
		mockMvc.perform(post("/questionnaires")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("description", "MyDescription 1")
                .param("title", "MyTitle 1")
        )
       	.andExpect(status().is3xxRedirection())
    	.andExpect(view().name("redirect:/questionnaires"))
    	.andExpect(model().attributeExists("questionnaire"));

	}
}
