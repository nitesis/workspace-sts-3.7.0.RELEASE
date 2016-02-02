package ch.fhnw.webfr.flashcard.web;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.web.TestUtil.QuestionnaireBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TestContext.class })
// WebAppConfiguration triggers WebMvcConfigurationSupport which enables all the
// default handler-mappings and handler-adapters
// needed for a spring mvc webapp
@WebAppConfiguration
public class QuestionnaireControllerTest {
	private MockMvc mockMvc;

	@Autowired
	// WebApplicationContext is an Interface to provide configuration for a web
	// application. This is
	// read-only while the application is running, but may be reloaded if the
	// implementation supports this.

	// This interface adds a getServletContext() method to the generic
	// ApplicationContext interface, and defines a well-known application
	// attribute name that the root context must be bound to in the bootstrap
	// process.
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
		Questionnaire questionnaire = new QuestionnaireBuilder(1L).description("MyDescription").title("MyTitle")
				.build();

		when(questionnaireRepositoryMock.findOne(1L)).thenReturn(questionnaire);

		mockMvc.perform(get("/questionnaires/{id}", 1L).header("Accept", "application/json"))
				// .andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.title", is("MyTitle")))
				.andExpect(jsonPath("$.description", is("MyDescription")));
	}

	@Test
	public void findById_QuestionnaireNotExisting_ShouldReturnNotFound() throws Exception {
		mockMvc.perform(get("/questionnaires/{id}", 2L).header("Accept", "application/json"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void findAll_QuestionnairesFound_ShouldReturnFoundQuestionnaires() throws Exception {
		Questionnaire questionnaire1 = new QuestionnaireBuilder(1L).description("MyDescription1").title("MyTitle1")
				.build();

		Questionnaire questionnaire2 = new QuestionnaireBuilder(2L).description("MyDescription2").title("MyTitle2")
				.build();

		when(questionnaireRepositoryMock.findAll(new Sort("id")))
				.thenReturn(Arrays.asList(questionnaire1, questionnaire2));

		mockMvc.perform(get("/questionnaires").header("Accept", "application/json"))
				// .andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].title", is("MyTitle1")))
				.andExpect(jsonPath("$[0].description", is("MyDescription1"))).andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].title", is("MyTitle2")))
				.andExpect(jsonPath("$[1].description", is("MyDescription2")));
	}

	@Test
	public void create_NewQuestionnaire_ShouldReturnOK() throws Exception {
		Questionnaire questionnaire = new QuestionnaireBuilder(1L).description("MyDescription").title("MyTitle")
				.build();

		// Important: You must override Questionnaire.equals() to be able to
		// execute these mock calls!
		when(questionnaireRepositoryMock.save(questionnaire)).thenReturn(questionnaire);

		mockMvc.perform(post("/questionnaires").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(questionnaire))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.title", is("MyTitle")))
				.andExpect(jsonPath("$.description", is("MyDescription")));
	}

	@Test
	public void create_NewQuestionnaireWithEmptyTitle_ShouldReturnNOK() throws Exception {
		Questionnaire questionnaire = new QuestionnaireBuilder(1L).description("MyDescription").build();

		// Important: You must override Questionnaire.equals() to be able to
		// execute these mock calls!
		when(questionnaireRepositoryMock.save(questionnaire)).thenReturn(questionnaire);

		mockMvc.perform(post("/questionnaires").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(questionnaire))).andExpect(status().isBadRequest());
	}

	@Test
	public void update_questionnaire_ShouldReturnOK() throws Exception {
		Questionnaire updatedQuestionnaire = new QuestionnaireBuilder(1L).description("MyDescription").title("MyTitle")
				.build();

		when(questionnaireRepositoryMock.save(updatedQuestionnaire)).thenReturn(updatedQuestionnaire);

		mockMvc.perform(put("/questionnaires/1").contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(updatedQuestionnaire))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.title", is("MyTitle")))
				.andExpect(jsonPath("$.description", is("MyDescription")));
	}

	@Test
	public void delete_questionnaire_ShouldReturnOK() throws Exception {
		questionnaireRepositoryMock.delete(1L);

		mockMvc.perform(delete("/questionnaires/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
