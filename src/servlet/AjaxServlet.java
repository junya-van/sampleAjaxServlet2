package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AjaxTestDAO;

/**
 * Ajax(非同期通信)テスト用サーブレット
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * index.jspのテキストボックスで入力した文字列のパターンマッチング(絞り込み検索)をする<br>
	 * 合致すればそれらの文字列群を返却
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String checkWord = request.getParameter("checkWord");

		response.setContentType("text/html; charset=UTF-8");		// これ記述しないと文字化けするので注意
		PrintWriter out = response.getWriter();

		// 条件によって返却値が変わる
		if(checkWord != null && checkWord.trim().length() != 0) {

			AjaxTestDAO dao = new AjaxTestDAO();
			List<String> list = dao.selectChackWord(checkWord);

			if(list.size() != 0) {

				out.println("以下のワードが登録されてます");

				for(String getWord : list) {

					out.println(getWord);

				}

			} else {

				out.print("該当なし");

			}

		} else {

			out.print("入力してください");

		}

	}

}
