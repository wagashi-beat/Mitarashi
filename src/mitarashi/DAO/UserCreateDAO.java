package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mitarashi.DTO.LoginDTO;
import mitarashi.util.DBConnector;
import mitarashi.util.DateUtil;

public class UserCreateDAO {
	private DBConnector db= new DBConnector();
	private Connection con= db.getConnection();
	private LoginDTO loginDTO= new LoginDTO();
	private DateUtil dateUtil= new DateUtil();

	// UserCreateActionから受け取ったユーザーIDが既登録でないか確認
	public boolean userCheck(String userId) throws SQLException {
		boolean getUserCheckFlg= false;

		// user_infoにセットし読み込む
		String sql= "SELECT * FROM user_info WHERE user_id= ?";

		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs= ps.executeQuery();

			// 登録があればfalseをloginDTOにセット＝既登録
			if (rs.next()){
				loginDTO.setGetUserCheckFlg(false);
			}

			// はじかれた場合trueをセット＝登録可
			else {
				loginDTO.setGetUserCheckFlg(true);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return getUserCheckFlg;
	}


	// userCreateActionから受け取ったuserId、password, email, familyName, firstNama, familyNameKana, firstNameKana,
	// sex, birthDayと登録日時をsqlのuser_infoに登録する
	public void userCreate(String userId, String password, String email, String familyName, String firstName,
			String familyNameKana, String firstNameKana, int sex, String birthDay) throws SQLException {

		String sql= "INSERT INTO user_info (user_id, password, email, family_name, first_name, family_name_kana, first_name_kana, sex, birth_day, regist_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, familyName);
			ps.setString(5, firstName);
			ps.setString(6, familyNameKana);
			ps.setString(7, firstNameKana);
			ps.setInt(8, sex);
			ps.setString(9, birthDay);
			ps.setString(10, dateUtil.getDate());

			ps.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			con.close();
		}
	}





	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}


}
