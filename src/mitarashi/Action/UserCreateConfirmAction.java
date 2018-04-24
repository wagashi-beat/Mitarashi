package mitarashi.Action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import mitarashi.DAO.DestinationDAO;
import mitarashi.DAO.UserCreateDAO;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	// 変数用意
		// ユーザーID
		private String userId;

		// パスワード
		private String password;

		// メールアドレス
		private String email;

		// 姓
		private String familyName;

		// 名
		private String firstName;

			// 姓よみがな
		private String familyNameKana;

		// 名よみがな
		private String firstNameKana;

		// 性別
		private String sex;
		private int sexNum;

		// 誕生日
		private String year;
		private String month;
		private String day;
		private String birthDay;

		// 電話番号
		private String telNumber;

		// 郵便番号
		private String postNumber;

		// 住所
		private String address;

		public Map<String, Object> session;
		private UserCreateDAO userCreateDAO= new UserCreateDAO();
		private DestinationDAO destinationDAO= new DestinationDAO();


	// 登録
	public String execute() throws SQLException {

		// UserCreateDAOのuserCreateに登録情報を登録
		userCreateDAO.userCreate(session.get("userId").toString(), session.get("password").toString(), session.get("email").toString(),
				session.get("familyName").toString(), session.get("firstName").toString(),
				session.get("familyNameKana").toString(), session.get("firstNameKana").toString(),
				Integer.parseInt(session.get("sex").toString()), session.get("birthDay").toString());


		// DestinationDAOのuserCreateDestinationに初期宛先情報を登録
		destinationDAO.userCreateDestination(session.get("userId").toString(), session.get("familyName").toString(), session.get("firstName").toString(),
				session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), session.get("telNumber").toString(), session.get("postNumber").toString(), session.get("address").toString());

		String ret= SUCCESS;

		return ret;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFamilyName() {
		return familyName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getFamilyNameKana() {
		return familyNameKana;
	}


	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}


	public String getFirstNameKana() {
		return firstNameKana;
	}


	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getSexNum() {
		return sexNum;
	}


	public void setSexNum(int sexNum) {
		this.sexNum = sexNum;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public String getTelNumber() {
		return telNumber;
	}


	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}


	public String getPostNumber() {
		return postNumber;
	}


	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public UserCreateDAO getUserCreateDAO() {
		return userCreateDAO;
	}


	public void setUserCreateDAO(UserCreateDAO userCreateDAO) {
		this.userCreateDAO = userCreateDAO;
	}


	public DestinationDAO getDestinationDAO() {
		return destinationDAO;
	}


	public void setDestinationDAO(DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}




}
