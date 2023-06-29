package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Productbeen;
import jp.co.aforce.dao.allDAO;
/**
 * Servlet implementation class Product
 */
@WebServlet("/views/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 allDAO dao = new allDAO();
	        try {
	            // データベースから商品一覧を取得
	            List<Productbeen> productList = dao.all();

	            // リクエストスコープに商品一覧をセット
	            request.setAttribute("products", productList);

	            // JSPにフォワード
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
