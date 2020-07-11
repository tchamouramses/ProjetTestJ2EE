package controller.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.work.entities.chambre;
import model.work.interfaces.implementation.chambreImpl;

public class chambreController extends HttpServlet {
	chambreImpl cha;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/chambre.jsp")
				.forward(req, response);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		String nature = req.getParameter("nature");
		double prix = Double.parseDouble(req.getParameter("prix"));
		float surface = Float.parseFloat(req.getParameter("surface"));
		if (this.add(nature, surface, prix))
			req.setAttribute("response", "ajout effectuer avec succes");
		else
			req.setAttribute("response", "echec d'ajout");

		this.doGet(req, response);
	}

	public boolean add(String nature, float surface, double prix) {
		cha = new chambreImpl();
		chambre c = new chambre();
		c.setNature(nature);
		c.setPrix(prix);
		c.setSurface(surface);
		return cha.add(c);
	}

}
