package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.CartDAO;

/**
 * Servlet implementation class Cartin
 */
@WebServlet("/views/cartin")
public class Cartin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//カートに追加する
		
				try {
		            // パラメータから商品IDを取得
		            int productId = Integer.parseInt(request.getParameter("productId"));
		            String productName = request.getParameter("productName");
		            int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		            int productCount = Integer.parseInt(request.getParameter("productCount"));

		            // カートに商品を追加
		            CartDAO cartDAO = new CartDAO();
		            cartDAO.addToCart(productId, productName, productPrice, productCount);
		        } catch (Exception e) {
		            e.printStackTrace();
		            // エラーハンドリングを行う（適切な方法で処理してください）
		        }
					RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
					dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
