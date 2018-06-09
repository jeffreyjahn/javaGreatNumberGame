package com.jeffreyahn.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class gng
 */
@WebServlet("/gng")
public class gng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Random r = new Random();
		if(session.getAttribute("answer") == null) {
			int random = r.nextInt(100)+ 1;
			session.setAttribute("answer", random);
		}
		String result;
		if(session.getAttribute("guess")!= null) {
			int guess =(int) session.getAttribute("guess");
			int answer = (int) session.getAttribute("answer");
			if(guess < answer) {
				result = "lower";
			} else if(guess > answer) {
				result = "higher";
			} else{
				result = "correct";
				request.setAttribute("answer", answer);
			}
			request.setAttribute("result", result);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/number.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if( request.getParameter("reset") != null) {
			session.removeAttribute("guess");
			session.removeAttribute("answer");
		} else {
			int guess = Integer.parseInt(request.getParameter("guess"));
			session.setAttribute("guess", guess);
		}
		response.sendRedirect("gng");
	}

}
