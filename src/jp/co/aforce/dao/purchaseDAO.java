package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Loginbeen;

public class purchaseDAO extends DAO{

	public void purc(String userId, HttpSession session) throws Exception {
		try (Connection connection = getConnection()) {
			// SQL文を組み立てて実行
			String sql = "SELECT * FROM users WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, userId); // ユーザーIDを設定
				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					// レコードから必要なデータを取得
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");

					// 取得したデータの処理
					// 例: オブジェクトにマッピングしてセッションに保存
					Loginbeen loginbeen = new Loginbeen();
					loginbeen.setId(userId);
					loginbeen.setMembername(name);
					loginbeen.setAddres(address);
					session.setAttribute("loginbeen", loginbeen);
				}

				resultSet.close();
			}
		} catch (SQLException e) {
			throw new Exception("データベース処理エラー", e);
		}
	}
}




