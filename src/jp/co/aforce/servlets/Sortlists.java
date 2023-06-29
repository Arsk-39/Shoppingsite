package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Productbeen;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class Sortlists
 */
@WebServlet("/views/sortlists")
public class Sortlists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sortlists() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		// 商品リストの取得
		List<Productbeen> products;
		try {
			products = dao.search();
		
		// ソート処理
		String sortType = request.getParameter("sort");
		if (sortType != null) {
		    if (sortType.equals("numberascending")) {
		        Collections.sort(products, Comparator.comparing(Productbeen::getPid));
		    } else if (sortType.equals("numberdescending")) {
		        Collections.sort(products, Comparator.comparing(Productbeen::getPid).reversed());
		    }
		 // 商品リストをリクエスト属性にセット
	        request.setAttribute("products", products);

	        // JSPにフォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
	        dispatcher.forward(request, response);
		}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
