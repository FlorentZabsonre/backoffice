package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet(name="CatalogueServlet",urlPatterns= {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(Catalogue.listOfWorks.isEmpty())
		{
			Work a = new Work();
			a.setGenre("genreA");
			Artist artA= new Artist();
			artA.setName("auteurA");
			a.setMainArtist(artA);
			a.setRelease(1991);
			a.setSummary("ekpfklkrklrklb");
			a.setTitle("titreA");

			Work b = new Work();
			b.setGenre("genreB");
			Artist artB= new Artist();
			artB.setName("auteurB");
			b.setMainArtist(artB);
			b.setRelease(1991);
			b.setSummary("bbbbbbbbbbbbbbbbbbbbbbb");
			b.setTitle("titreB");

			Work d = new Work();
			d.setGenre("genreD");
			Artist artD= new Artist();
			artD.setName("auteurD");
			d.setMainArtist(artD);
			d.setRelease(1991);
			d.setSummary("dddddddddddddddddddddddd");
			d.setTitle("titreD");

			HashSet<Work> listofWork= new HashSet<Work>();
			listofWork.add(a);
			listofWork.add(b);
			listofWork.add(d);
			Catalogue.setListOfWorks(listofWork);;
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\" />");
			out.println("<title>OnlineStore</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Catalogue</h1> <br/> <br/>");
			for( Work tmp: Catalogue.getListOfWorks())
			{

				out.print(tmp.getTitle() +" (" + tmp.getRelease() +") <br/>" );

			}
			out.println("</body>");
			out.println("</html>");
		}
	}



}
