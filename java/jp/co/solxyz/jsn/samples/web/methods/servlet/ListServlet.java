package jp.co.solxyz.jsn.samples.web.methods.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.jsn.samples.web.methods.dao.DataDao;
import jp.co.solxyz.jsn.samples.web.methods.entity.ChatEntity;

/**
 * チャットの一覧を表示するサーブレット
 *
 */
@WebServlet("/")
public class ListServlet extends HttpServlet {

	/** Forward先のJSP */
	private static final String JSP_PATH = "/WEB-INF/jsp/index.jsp";

	/** DAO */
	private final DataDao dataDao;

	/**
	 * コンストラクタ
	 */
	public ListServlet() {
		// DAOの初期化
		this.dataDao = new DataDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 全件取得する
		try {
			
			//TODO 画面に渡す処理を追加しよう
			var allData = this.dataDao.getAll();

		} catch (SQLException e) {
			e.printStackTrace();

			resp.setStatus(500);
			resp.getWriter().write(e.getMessage());

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// POSTされたデータの取得
		ChatEntity receiveData = ChatEntity.builder()
				.name((String) req.getParameter("name"))
				.message((String) req.getParameter("message")).build();

		try {
			this.dataDao.insert(receiveData);
			resp.sendRedirect("./");
		} catch (SQLException e) {
			e.printStackTrace();
			resp.setStatus(500);
			resp.getWriter().write(e.getMessage());
		}
	}
}
