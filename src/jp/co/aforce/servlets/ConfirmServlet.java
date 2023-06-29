package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.dao.CartDAO;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/views/confirm")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isLoggedIn(request)) {
	        // 未ログインの場合、ログイン画面にリダイレクト
	        response.sendRedirect(request.getContextPath() + "/views/login");  // ログイン画面のURLに適宜変更してください
	        return;
	    }
		request.setCharacterEncoding("UTF-8");
	    CartDAO dao = new CartDAO();
	    try {
	        // データベースから商品一覧を取得
	        List<CartBean> cartList = dao.getCartItems();

	        // リクエストスコープに商品一覧をセット
	        request.setAttribute("cartList", cartList);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // 確認画面を表示するJSPにフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/confirm.jsp");
	    dispatcher.forward(request, response);
	}
	private boolean isLoggedIn(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    return session != null && session.getAttribute("loggedInUser") != null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isLoggedIn(request)) {
	        // 未ログインの場合、ログイン画面にリダイレクト
	        response.sendRedirect(request.getContextPath() + "/views/login");  // ログイン画面のURLに適宜変更してください
	        return;
	    } 
		request.setCharacterEncoding("UTF-8");

		    // 入力値を取得
		    String name = request.getParameter("NAME");
		    String address = request.getParameter("ADDRESS");
		    String phoneNumber = request.getParameter("PHONE_NUMBER");
		    String mailAddress = request.getParameter("MAIL_ADDRESS");

		    // 取得した入力値をリクエスト属性に設定
		    request.setAttribute("name", name);
		    request.setAttribute("address", address);
		    request.setAttribute("phoneNumber", phoneNumber);
		    request.setAttribute("mailAddress", mailAddress);

		    CartDAO dao = new CartDAO();
		    try {
		        // データベースから商品一覧を取得
		        List<CartBean> cartList = dao.getCartItems();

		        // リクエストスコープに商品一覧と入力値をセット
		        request.setAttribute("cartList", cartList);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    // 確認画面を表示するJSPにフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/confirm.jsp");
		    dispatcher.forward(request, response);
		}
	}


