package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Productbeen;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class Serch
 */
@WebServlet("/views/serch")
public class Serch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		ProductDAO productDAO = new ProductDAO();
	    try {
	        List<Productbeen> products = productDAO.searchProducts(keyword);
	        request.setAttribute("products", products);
		    request.getRequestDispatcher("/views/list.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // エラー処理
	    }


	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
