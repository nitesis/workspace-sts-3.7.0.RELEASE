package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;

@SuppressWarnings("serial")
// Das ist ein Servlet
public class BasicServlet extends HttpServlet {

	private QuestionnaireRepository questionnaireRepository;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String[] pathElements = request.getRequestURI().split("/");
		//Aufteilung der fachlichen Logik auf Handler-Methoden durch ein Pseudo-Mapping mit "if"-Abfragen
		//Schaut, wo man ist (welche URL) und geht dann entsprechend weiter
		if (isLastPathElementQuestionnairesId(pathElements)) {

			long id = Long.parseLong(pathElements[pathElements.length - 1]);
			handleQuestionnairesIdRequest(request, response, id);
		} else if (isLastPathElementQuestionnaires(pathElements)) {
			handleQuestionnairesRequest(request, response);
		} else {
			handleIndexRequest(request, response);
		}
	}

	private boolean isLastPathElementQuestionnairesId(String[] pathElements) {
		String last = pathElements[pathElements.length - 1];
		return last.matches("[0-9]+");
	}

	private boolean isLastPathElementQuestionnaires(String[] pathElements) {
		String last = pathElements[pathElements.length - 1];
		return last.equals("questionnaires");
	}

	private void handleQuestionnairesIdRequest(HttpServletRequest request, HttpServletResponse response, long id)
			throws IOException {
		List<Questionnaire> questionnaires = QuestionnaireRepository.getInstance().findAll();
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><title>Excample</title></head><body>");
		writer.append("<h3>Questionnaire</h3>");

		// writer.append(q.getDescription());
		for (Questionnaire questionnaire : questionnaires) {
			if (questionnaire.getId() == id) {
				writer.append("<p><a>" + questionnaire.getTitle() + "</a></p>");
				writer.append("<p><a>" + questionnaire.getDescription() + "</a></p>");
			}
//			String url = request.getContextPath() + request.getServletPath();
//			url = url + "/questionnaires/" + questionnaire.getId().toString();
//			writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
		}
		writer.append("</body></html>");
	}

	private void handleQuestionnairesRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<Questionnaire> questionnaires = QuestionnaireRepository.getInstance().findAll();
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><title>Example</title></head><body>");
		writer.append("<h3>Fragebögen</h3>");
		for (Questionnaire questionnaire : questionnaires) {
			String url = request.getContextPath() + request.getServletPath();
			url = url + "/questionnaires/" + questionnaire.getId().toString();
			writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
		}
		writer.append("</body></html>");
	}

	private void handleIndexRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><title>Example</title></head><body>");
		writer.append("<h3>Welcome</h3>");
		String url = request.getContextPath() + request.getServletPath();
		writer.append("<p><a href='" + response.encodeURL(url) + "/questionnaires'>All Questionnaires</a></p>");
		writer.append("</body></html>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//QuestionnaireInitializer.createQuestionnaires();
		//questionnaireRepository = (QuestionnaireRepository).config.getServletContext().getAttribute("questionnaireRepository");
	}

}
