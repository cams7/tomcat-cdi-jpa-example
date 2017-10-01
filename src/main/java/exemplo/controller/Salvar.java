/**
 * 
 */
package exemplo.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exemplo.model.Contato;

/**
 * @author César Magalhães
 *
 */
@WebServlet("/vaisalvar")
@SuppressWarnings("serial")
public class Salvar extends HttpServlet {

	@Inject
	private EntityManager em;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id").trim();
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");

		Contato c = null;
		if (!"".equals(id))
			c = em.find(Contato.class, Long.parseLong(id));
		else
			c = new Contato();

		c.setNome(nome);
		c.setTelefone(telefone);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		transaction.commit();

		// devemos ainda redirecionar para a tela de resultado
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
