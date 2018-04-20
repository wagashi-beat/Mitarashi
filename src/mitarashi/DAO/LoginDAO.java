package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mitarashi.DTO.LoginDTO;
import mitarashi.util.DBConnector;

public class LoginDAO {
	private DBConnector db= new DBConnector();
	private Connection con= db.getConnection();
	private LoginDTO loginDTO= new LoginDTO();


	// LoginActionからuserId、passwordを受け取る
	public LoginDTO getLogin (String userId, String password) {

		// userId、passwordをsqlのuser_infoにセット
		String sql= "SELECT * FROM user_info WHERE user_id= ? AND password= ?";

		try {
			PreparedStatement ps= con.prepareStatement(sql);

			// 上記のsql文にuserId、passwordの順にセット
			ps.setString(1, userId);
			ps.setString(2, password);

			// 実行し結果を返す
			ResultSet rs= ps.executeQuery();


			// user_infoにセットできた場合、loginDTOにセット＝ログイン成功
			if (rs.next()) {
				loginDTO.setUserId(rs.getString("user_id"));
				loginDTO.setPassword(rs.getString("password"));

				// 初期値でfalseになっているloginFlgにtrueをセット
				loginDTO.setLoginFlg(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginDTO;

	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

}
