package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Loginbeen;
import jp.co.aforce.dao.DAOlogin;

/**
 * Servlet implementation class login
 */
@WebServlet("/views/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSiteSample/views/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String member_id=request.getParameter("member_id");
		String password=request.getParameter("password");
		
		DAOlogin dao = new DAOlogin();
		Loginbeen login;
		try {
			login = dao.search(member_id, password);
			String aaa = "aaa";
			if(member_id == aaa){
				response.sendRedirect("/views/kanri");
			}else if (login !=null) {
				login = dao.search(member_id, password);
				session.setAttribute("loggedInUser", login);
				request.getRequestDispatcher("/views/home.jsp").forward(request, response);
			}else {
				session.setAttribute("errormsg", "ユーザーIDもしくはパスワードが違います。");
				response.sendRedirect("/ShoppingSiteSample/views/login.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
