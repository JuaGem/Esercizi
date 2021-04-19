package it.prova.cercalibro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;


import it.prova.cercalibro.model.Libro;

/**
 * Servlet implementation class ExecuteRicercaLibroServlet
 */
@WebServlet("/ExecuteRicercaLibroServlet")
public class ExecuteRicercaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Libro> libri = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteRicercaLibroServlet() {
        super();
        Libro libro = new Libro("Titolo","Genere", 10);
        libri.add(libro);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titoloParameter = request.getParameter("titoloInput");
		String genereParameter = request.getParameter("genereInput");
		String pagineParameter = request.getParameter("pagineInput");
		
		RequestDispatcher rd = null;
		if(titoloParameter!= null && genereParameter!= null && pagineParameter!= null && !titoloParameter.isEmpty() && !genereParameter.isEmpty() && !pagineParameter.isEmpty()) {
			Libro libroParameter = new Libro(titoloParameter, genereParameter, Integer.parseInt(pagineParameter));
			if(libri.contains(libroParameter)) {
				rd = request.getRequestDispatcher("libroTrovato.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("libroNonTrovato.jsp");
				rd.forward(request, response);
			}
		}
			
		
		
		doGet(request, response);
	}

}
