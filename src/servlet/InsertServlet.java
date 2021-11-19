package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InsertDAO;

/**
 * ワード登録に関するリクエストを処理するコントローラ
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ワード登録処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word").trim();

		InsertDAO dao = new InsertDAO();
		int count = dao.insertWord(word);

		String msg = "";

		if(count != 0) {

			msg += "登録成功";

		} else {

			msg += "登録失敗";

		}

		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		rd.forward(request, response);

	}

}
