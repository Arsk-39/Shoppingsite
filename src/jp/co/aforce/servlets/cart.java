package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.dao.CartDAO;

/**
 * Servlet implementation class cart
 */
@WebServlet("/views/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ログイン状態のチェック
	    if (!isLoggedIn(request)) {
	        // 未ログインの場合、ログイン画面にリダイレクト
	        response.sendRedirect(request.getContextPath() + "/views/login");  // ログイン画面のURLに適宜変更してください
	        return;
	    }

		request.setCharacterEncoding("UTF-8"); 
		//cartの中身を表示させる
		CartDAO dao = new CartDAO();
		try {
			//データベースから商品一覧を取得
		    List<CartBean> cartList = dao.getCartItems();
		    
		    //リクエストスコープに商品一覧をセット
		    request.setAttribute("cartList", cartList);
		} catch (Exception e) {
		    e.printStackTrace();
		    //エラー処理
		}
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
		
		
	}

	private boolean isLoggedIn(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    return session != null && session.getAttribute("loggedInUser") != null;
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	    }
	}


