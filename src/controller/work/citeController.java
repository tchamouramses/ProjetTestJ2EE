package controller.work;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.work.entities.cite;
import model.work.interfaces.implementation.citeImpl;

public class citeController extends HttpServlet {
	citeImpl cite;
	private cite c = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String va = "add";
		cite = new citeImpl();
		try {
			va = request.getParameter("type");
		} catch (NullPointerException e) {
			va = "add";
		}
		String page = "/showCite.jsp";
		if (va.equals("add")) {
			page = "/cite.jsp";
		} else if (va.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (cite.delete(new cite(id))) {
				request.setAttribute("reponse",
						"Suppression effectué avec succès");
			} else {
				request.setAttribute("reponse", "Echec de suppression");
			}
			List<cite> liste = cite.get();
			request.setAttribute("listecite", liste);
			page = "/showCite.jsp";

		} else if (va.equals("show")) {
			List<cite> liste = cite.get();
			request.setAttribute("listeCite", liste);
			page = "/showCite.jsp";
		} else if (va.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (cite.delete(new cite(id))) {
				request.setAttribute("reponse",
						"Suppression effectué avec succès");
			} else {
				request.setAttribute("reponse", "Echec de suppression");
			}
			List<cite> liste = cite.get();
			request.setAttribute("listeCite", liste);
			page = "/showCite.jsp";
		} else if (va.equals("show")) {
			List<cite> liste = cite.get();
			request.setAttribute("listeCite", liste);
			page = "/showCite.jsp";
		} else if (va.equals("up")) {
			int id = -1;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			cite e = cite.findById(new cite(id));
			if (id == -1) {
				List<cite> liste = cite.get();
				request.setAttribute("listeCite", liste);
				page = "/showCite.jsp";
			} else {
				this.c = e;
				request.setAttribute("cite", e);
				page = "/updatecite.jsp";
			}

		}
		this.getServletContext().getRequestDispatcher(page)
				.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cite = new citeImpl();
		System.out.println("test arrivate");
		String val = "add";
		try {
			val = request.getParameter("type");
		} catch (NullPointerException e) {
			val = "add";
		}

		if (val.equals("add")) {
			String bailleur = request.getParameter("bailleur");
			int nbChambre = Integer.parseInt(request.getParameter("nbChambre"));
			System.out.println(bailleur);
			if (addcite(bailleur, nbChambre)) {
				request.setAttribute("reponse", "Ajout effectué avec succès");

			} else {
				request.setAttribute("reponse", "Echec d'ajout");
			}
		} else if (val.equals("up")) {
			String bailleur = request.getParameter("bailleur");
			int nbChambre = Integer.parseInt(request.getParameter("nbChambre"));
			System.out.println(bailleur);

			if (upp(bailleur, nbChambre)) {
				request.setAttribute("reponse", "Ajout effectué avec succès");

			} else {
				request.setAttribute("reponse", "Echec d'ajout");
			}
		}
		this.doGet(request, response);
	}

	public boolean addcite(String bailleur, int nbChambre) {
		cite = new citeImpl();
		cite c = new cite();
		c.setBailleur(bailleur);
		c.setNbChambre(nbChambre);
		return cite.add(c);
	}

	public boolean upp(String bailleur, int nbChambre) {
		cite = new citeImpl();
		this.c.setBailleur(bailleur);
		this.c.setNbChambre(nbChambre);
		return cite.update(c);
	}

}