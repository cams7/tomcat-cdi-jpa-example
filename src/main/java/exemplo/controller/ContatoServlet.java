/**
 * 
 */
package exemplo.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cams7.app.model.entity.Contato;
import br.com.cams7.app.service.ContatoService;

/**
 * @author César Magalhães
 *
 */
@WebServlet("/vaisalvar")
@SuppressWarnings("serial")
public class ContatoServlet extends HttpServlet {

	@Inject
	private ContatoService contatoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id").trim();
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");

		Contato contato = new Contato();
		if (!"".equals(id))
			contato.setId(Long.parseLong(id));

		contato.setNome(nome);
		contato.setTelefone(telefone);

		contatoService.salva(contato);

		// devemos ainda redirecionar para a tela de resultado
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
