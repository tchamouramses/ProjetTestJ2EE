package controller.work;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.work.entities.client;
import model.work.interfaces.implementation.clientImpl;

public class clientController extends HttpServlet {
	clientImpl client;
	private client c = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String va = "add";
		client = new clientImpl();
		try {
			va = request.getParameter("type");
		} catch (NullPointerException e) {
			va = "add";
		}
		String page = "/showClient.jsp";
		if (va.equals("add")) {
			page = "/home.jsp";
		} else if (va.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (client.delete(new client(id))) {
				request.setAttribute("reponse",
						"Suppression effectué avec succès");
			} else {
				request.setAttribute("reponse", "Echec de suppression");
			}
			List<client> liste = client.get();
			request.setAttribute("listeClient", liste);
			page = "/showClient.jsp";
		} else if (va.equals("show")) {
			List<client> liste = client.get();
			request.setAttribute("listeClient", liste);
			page = "/showClient.jsp";
		} else if (va.equals("up")) {
			int id = -1;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			client e = client.findById(new client(id));
			if (id == -1) {
				List<client> liste = client.get();
				request.setAttribute("listeClient", liste);
				page = "/showClient.jsp";
			} else {
				this.c = e;
				request.setAttribute("client", e);
				page = "/updateClient.jsp";
			}

		}
		this.getServletContext().getRequestDispatcher(page)
				.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		client = new clientImpl();
		System.out.println("test arrivate");
		String val = "add";
		try {
			val = request.getParameter("type");
		} catch (NullPointerException e) {
			val = "add";
		}

		if (val.equals("add")) {
			String lieu = request.getParameter("lieu");
			String nom = request.getParameter("nom");
			System.out.println(nom);
			String date = request.getParameter("date");
			SimpleDateFormat spl = new SimpleDateFormat();
			Date d = new Date(System.currentTimeMillis());
			try {
				d = (Date) spl.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (addClient(nom, lieu, d)) {
				request.setAttribute("reponse", "Ajout effectué avec succès");

			} else {
				request.setAttribute("reponse", "Echec d'ajout");
			}
		} else if (val.equals("up")) {
			String lieu = request.getParameter("lieu");
			String nom = request.getParameter("nom");
			System.out.println(nom);
			String date = request.getParameter("date");
			SimpleDateFormat spl = new SimpleDateFormat();
			Date d = new Date(System.currentTimeMillis());
			try {
				d = (Date) spl.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (upp(nom, lieu, d)) {
				request.setAttribute("reponse", "Ajout effectué avec succès");

			} else {
				request.setAttribute("reponse", "Echec d'ajout");
			}
		}
		this.doGet(request, response);
	}

	public boolean addClient(String nom, String lieu, Date date) {
		client = new clientImpl();
		client c = new client();
		c.setNoms(nom);
		c.setDate(date);
		c.setLieu(lieu);
		return client.add(c);
	}

	public boolean upp(String nom, String lieu, Date date) {
		client = new clientImpl();
		this.c.setNoms(nom);
		this.c.setDate(date);
		this.c.setLieu(lieu);
		return client.update(c);
	}

}
