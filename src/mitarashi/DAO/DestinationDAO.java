package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mitarashi.util.DBConnector;
import mitarashi.util.DateUtil;

public class DestinationDAO {
	private DBConnector db= new DBConnector();
	private Connection con= db.getConnection();
	private DateUtil dateUtil= new DateUtil();

	public void userCreateDestination(String userId, String familyName, String firstName,
			String familyNameKana, String firstNamaKana, String telNumber, String postNumber, String address) throws SQLException {

		String sql= "INSERT INTO destination_info (user_id, family_name, first_name, "
				+ "family_name_kana, first_name_kana, tel_number, post_number, user_address, regist_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps= con.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNamaKana);
			ps.setString(6, telNumber);
			ps.setString(7, postNumber);
			ps.setString(9, address);
			ps.setString(9, dateUtil.getDate());

			ps.executeQuery();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			con.close();
		}
	}

}
