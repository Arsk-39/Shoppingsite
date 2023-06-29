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
 * Servlet implementation class cartadd
 */
@WebServlet("/views/cartadd")
public class cartadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        // パラメータから商品IDを取得
	        int productId = Integer.parseInt(request.getParameter("productId"));
	        int productCount = Integer.parseInt(request.getParameter("Count"));

	        // カートに商品を追加
	        CartDAO cartDAO = new CartDAO();

	        //アクションを読み取る
	        String add = request.getParameter("add");
	        String delete = request.getParameter("delete");
	        // 減らす処理
	        if(add != null) {
	        	cartDAO.additional_feature(productId, productCount);
	        }else if(delete != null){
	        	cartDAO.decreaseCartItem(productId, productCount);
	        }

	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        // 数値に変換できない場合のエラーハンドリング
	    } catch (Exception e) {
	        e.printStackTrace();
	        // その他の例外処理（適切な方法で処理してください）
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
