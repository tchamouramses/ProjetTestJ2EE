package controller.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import model.work.entities.cite ;
import javax.servlet.http.HttpServletResponse;

import model.work.interfaces.implementation.citeImpl;

public class citeController extends HttpServlet {
	citeImpl cit;

	@Override
	public void doGet( HttpServletRequest req, HttpServletResponse reponse) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher("/cite.jsp").forward(req, reponse);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse reponse)throws ServletException, IOException{
		String bailleur = req.getParameter("bailleur");
		int nbChambre =  Integer.parseInt(req.getParameter("nb"));
		if (this.add(bailleur, nbChambre)){
			req.setAttribute("reponse","Ajout effectu avec succes");
		}else{
			req.setAttribute("reponse", "echec d'ajout");
		}
		
		
		
		this.doGet(req, reponse);
	}
	
	
	public boolean add( String bailleur,int nbChambre){
		cite c = new cite();
		cit= new citeImpl();
		c.setBailleur(bailleur);
		c.setNbChambre(nbChambre);
		return cit.add(c);
		
	}
}
