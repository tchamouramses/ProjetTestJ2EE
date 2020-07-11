package controller.work;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		client = new clientImpl();
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
		
		
		String lieu = request.getParameter("lieu");
		if(addClient(nom, lieu, d)){
			request.setAttribute("reponse", "Ajout effectué avec succès");
		}else{
			request.setAttribute("reponse", "Echec d'ajout");
		}
		this.doGet(request, response);
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
