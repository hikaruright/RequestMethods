package jp.co.solxyz.jsn.samples.web.methods.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jp.co.solxyz.jsn.samples.web.methods.entity.ChatEntity;

/**
 * チャットデータのDB操作を行うDAO
 * 
 */
public class DataDao {

	/** Database URL */
	private static final String URL = "jdbc:mysql://localhost:3306/chat";
	/** Database Access User */
	private static final String DBUSER = "root";
	/** Database Access Password */
	private static final String DBPASS = "myadmin";

	/**
	 * コンストラクタ
	 */
	public DataDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			// このエラーが発生したときは続行不能エラーのため処理を中断させる
			throw new RuntimeException(e);
		}
	}

	/**
	 * コネクション生成
	 * @return コネクション
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL, DBUSER, DBPASS);
		con.setAutoCommit(false);
		return con;
	}

	/**
	 * ResultSetをEntityに変換する
	 * @param resultSet DB実行結果の行情報
	 * @return 変換されたEntityデータ
	 * @throws SQLException DB情報の取得に失敗した際に発生するエラー
	 */
	private ChatEntity convertRStoEntity(ResultSet resultSet) throws SQLException {
		//TODO ここを実装
		return null;
	}

	/**
	 * すべての情報を取得
	 * 
	 * @return 全データ
	 */
	public List<ChatEntity> getAll() throws SQLException {

		//TODO ここを実装
		return null;

	}

	/**
	 * 単一情報の取得
	 * 
	 * @param id 取得するデータのID
	 * @return 取得結果
	 */
	public Optional<ChatEntity> get(int id) {

		//TODO ここを実装
		return null;
	}

	/**
	 * 新規登録
	 * 
	 * @param entity 登録データ
	 */
	public void insert(ChatEntity entity) throws SQLException {

		//TODO ここを実装
		return;

	}

	/**
	 * 更新
	 * 
	 * @param entity 更新データ
	 */
	public void update(ChatEntity entity) throws SQLException {

		return;
	}

	/**
	 * 削除
	 * 
	 * @param id 削除するID
	 */
	public void delete(int id) throws SQLException {

		return;
	}
}
