package controller.work;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.work.entities.client;
import model.work.interfaces.implementation.clientImpl;

public class clientController extends HttpServlet{
	clientImpl client;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		client = new clientImpl();

		String nom = request.getParameter("nom");
		Date date = new Date(Date.parse(request.getParameter("date")));
		String lieu = request.getParameter("lieu");
		if(addClient(nom, lieu, date)){
			request.setAttribute("Adding_respose", "Ajout effectué avec succès");
		}else{
			request.setAttribute("Adding_respose", "Echec d'ajout");
		}

	}
	
	public boolean addClient(String nom, String lieu, Date date){
		client = new clientImpl();
		client c = new client();
		c.setNoms(nom);
		c.setDate(date);
		c.setLieu(lieu);
		return client.add(c);
	}

}
