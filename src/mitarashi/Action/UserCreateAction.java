package mitarashi.Action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import mitarashi.DAO.UserCreateDAO;
import mitarashi.DTO.LoginDTO;

public class UserCreateAction extends ActionSupport implements SessionAware{

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


		// 未入力エラー
		private String errorUser;

		// IDに関するエラー
		private String errorUserId;
		// IDに関するエラーリスト
		private ArrayList<String> errorUserIdList= new ArrayList<>();

		// パスワードに関するエラー
		private String errorUserPass;
		// パスワードに関するエラーリスト
		private ArrayList<String> errorUserPassList= new ArrayList<>();

		// メールアドレスに関するエラー
		private String errorUserMail;
		// メールアドレスに関するエラーリスト
		private ArrayList<String> errorUserMailList= new ArrayList<>();

		// 姓に関するエラー
		private String errorUserFam;
		// 姓に関するエラーリスト
		private ArrayList<String> errorUserFamList= new ArrayList<>();

		// 名に関するエラー
		private String errorUserFir;
		// 名に関するエラーリスト
		private ArrayList<String> errorUserFirList= new ArrayList<>();

		// 姓よみがなに関するエラー
		private String errorUserFamKana;
		// 姓よみがなに関するエラーリスト
		private ArrayList<String> errorUserFamKanaList= new ArrayList<>();

		// 名よみがなに関するエラー
		private String errorUserFirKana;
		// 名よみがなに関するエラーリスト
		private ArrayList<String> errorUserFirKanaList= new ArrayList<>();

		// 性別に関するエラー
		private String errorUserSex;
		// 性別に関するエラーリスト
		private ArrayList<String> errorUserSexList= new ArrayList<>();

		// 誕生日に関するエラー
		private String errorUserBirth;
		// 誕生日に関するエラーリスト
		private ArrayList<String> errorUserBirthList= new ArrayList<>();

		// 電話番号に関するエラー
		private String errorUserTel;
		// 電話番号に関するエラーリスト
		private ArrayList<String> errorUserTelList= new ArrayList<>();

		// 郵便番号に関するエラー
		private String errorUserPost;
		// 郵便番号に関するエラーリスト
		private ArrayList<String> errorUserPostList= new ArrayList<>();

		// 住所に関するエラー
		private String errorUserAddress;
		// 住所に関するエラーリスト
		private ArrayList<String> errorUserAddressList= new ArrayList<>();


		private UserCreateDAO userCreateDAO= new UserCreateDAO();
		private LoginDTO loginDTO= new LoginDTO();
		private Map<String, Object> session;

	// 新規登録実行
	public String execute() throws SQLException {
		// エラー前提で結果を返す
		String ret= ERROR;

		// ERROR判定に使用 0ならSUCCESS、1以上の場合ERROR
		int errorCountUser= 0;


		// 未入力項目があった場合
		if (userId.equals("") || password.equals("") || email.equals("") ||
				familyName.equals("") || firstName.equals("") ||
				familyNameKana.equals("") || firstNameKana.equals("") || year.equals("") || month.equals("") || day.equals("") ||
				telNumber.equals("") || postNumber.equals("") || address.equals("")) {
			errorUser= "未入力項目があります（o・▽・o）";
			session.put("errorUser", errorUser);
			errorCountUser++;
		}

		// 未入力項目が無かった場合
		else {

			// 既登録時エラー
			// UserCreateDAOのuserCheckにuserIdを入れ、実行できたら（登録されているIDならば）false、
			// 実行できなければ（登録されていなければ）trueをloginDTOのgetUserCheckFlgにセットする
			userCreateDAO.userCheck(userId);
			if (loginDTO.getGetUserCheckFlg() != false){
				errorUserId= "入力したユーザーIDは既に登録されています。";
				errorUserIdList.add(errorUserId);
				errorCountUser++;
			}

			else {
				ret= SUCCESS;
			}


			// IDに関するエラー
			// 文字数エラー
			if (userId.length()<3 || userId.length()>16) {
				errorUserId= "3文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserIdList.add(errorUserId);
				errorCountUser++;
			}

			// 文字種エラー
			if (!userId.matches("^[0-9a-zA-Z]+$")) {
				errorUserId= "半角英数字で入力してね～（o・▽・o）";
				errorUserIdList.add(errorUserId);
				errorCountUser++;
			}



			// パスワードに関するエラー
			// 文字数エラー
			if (password.length()<3 || password.length()>16) {
				errorUserPass= "3文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserPassList.add(errorUserPass);
				errorCountUser++;
			}

			// 文字種エラー
			if (!password.matches("^[0-9a-zA-Z]+$")) {
				errorUserPass= "半角英数字で入力してね～（o・▽・o）";
				errorUserPassList.add(errorUserPass);
				errorCountUser++;
			}

			// IDとパスワードを同一にできない
			if (userId == password) {
				errorUserPass= "ユーザーIDとパスワードを同じに設定できません。";
				errorUserPassList.add(errorUserPass);
				errorCountUser++;
			}



			// メールアドレスに関するエラー
			// 文字数エラー
			if (email.length()<11 || email.length()>32) {
				errorUserMail= "11文字以上32文字以下で入力してね～（o・▽・o）";
				errorUserMailList.add(errorUserMail);
				errorCountUser++;
			}

			// 文字種エラー
			if (!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
				errorUserMail= "半角英数字で入力してね～（o・▽・o）";
				errorUserMailList.add(errorUserMail);
				errorCountUser++;
			}



			// 姓に関するエラー
			// 文字数エラー
			if (familyName.length()<1 || familyName.length()>16) {
				errorUserFam= "1文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserFamList.add(errorUserFam);
				errorCountUser++;
			}

			// 文字種エラー
			if (!familyName.matches("^[a-zA-Zぁ-ゞ一-龠々ァ-ヶ]+$")) {
				errorUserFam= "半角英字、ひらがな、カタカナ、漢字で入力してね～（o・▽・o）";
				errorUserFamList.add(errorUserFam);
				errorCountUser++;
			}



			// 名に関するエラー
			// 文字数エラー
			if (firstName.length()<1 || firstName.length()>16) {
				errorUserFir= "1文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserFirList.add(errorUserFir);
				errorCountUser++;
			}

			// 文字種エラー
			if (!firstName.matches("^[a-zA-Zぁ-ゞ一-龠々ァ-ヶ]+$")) {
				errorUserFir= "半角英字、ひらがな、カタカナ、漢字で入力してね～（o・▽・o）";
				errorUserFirList.add(errorUserFir);
				errorCountUser++;
			}



			// 姓よみがなに関するエラー
			// 文字数エラー
			if (familyNameKana.length()<1 || familyNameKana.length()>16) {
				errorUserFamKana= "1文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserFamKanaList.add(errorUserFamKana);
				errorCountUser++;
			}

			// 文字種エラー
			if (!familyNameKana.matches("^[ぁ-ゞ]+$")) {
				errorUserFamKana= "ひらがなで入力してね～（o・▽・o）";
				errorUserFamKanaList.add(errorUserFamKana);
				errorCountUser++;
			}



			// 名よみがなに関するエラー
			// 文字数エラー
			if (firstNameKana.length()<1 || firstNameKana.length()>16) {
				errorUserFirKana= "1文字以上16文字以下で入力してね～（o・▽・o）";
				errorUserFirKanaList.add(errorUserFirKana);
				errorCountUser++;
			}

			// 文字種エラー
			if (!firstNameKana.matches("^[ぁ-ゞ]+$")) {
				errorUserFirKana= "ひらがなで入力してね～（o・▽・o）";
				errorUserFirKanaList.add(errorUserFirKana);
				errorCountUser++;
			}



			// 性別に関するエラー
			// 異常値エラー
			if (!(sex.equals("1") || sex.equals("0"))) {
				errorUserSex= "正常な値で入力してください";
				errorUserSexList.add(errorUserSex);
				errorCountUser++;
			}



			// 電話番号に関するエラー
			// 文字数エラー
			if (telNumber.length()<10 || telNumber.length()>13) {
				errorUserTel= "10文字以上13文字以下で入力してね～（o・▽・o）";
				errorUserIdList.add(errorUserTel);
				errorCountUser++;
			}

			// 文字種エラー
			if (!telNumber.matches("^[0-9]+$")) {
				errorUserTel= "半角数字のみで入力してね～（o・▽・o）";
				errorUserTelList.add(errorUserTel);
				errorCountUser++;
			}


			birthDay= year + month + day;
			// 生年月日に関するエラー
			// 文字数エラー
			if (birthDay.length() != 8) {
				errorUserBirth= "ちゃんと入力してください";
				errorUserBirthList.add(errorUserBirth);
				errorCountUser++;
			}

			// 文字種エラー
			if (!year.matches("^[0-9]+$")) {
				errorUserBirth= "半角数字のみで入力してね～（o・▽・o）";
				errorUserBirthList.add(errorUserBirth);
				errorCountUser++;
			}
			if (!month.matches("^[0-9]+$")) {
				errorUserBirth= "半角数字のみで入力してね～（o・▽・o）";
				errorUserBirthList.add(errorUserBirth);
				errorCountUser++;
			}
			if (!day.matches("^[0-9]+$")) {
				errorUserBirth= "半角数字のみで入力してね～（o・▽・o）";
				errorUserBirthList.add(errorUserBirth);
				errorCountUser++;
			}



			// 郵便番号に関するエラー
			// 文字数エラー
			if (postNumber.length() != 7) {
				errorUserPost= "7文字で入力してね～（o・▽・o）";
				errorUserPostList.add(errorUserPost);
				errorCountUser++;
			}

			// 文字種エラー
			if (!postNumber.matches("^[0-9]+$")) {
				errorUserPost= "半角数字のみで入力してね～（o・▽・o）";
				errorUserPostList.add(errorUserPost);
				errorCountUser++;
			}



			// 住所に関するエラー
			// 文字数エラー
			if (address.length()<10 || address.length()>50) {
				errorUserAddress= "10文字以上50文字以下で入力してね～（o・▽・o）";
				errorUserAddressList.add(errorUserAddress);
				errorCountUser++;
			}

			// 文字種エラー
			if (!address.matches("^[a-zA-Z0-9ぁ-ゞ一-龠々ァ-ヶ]+$")) {
				errorUserAddress= "半角英数字、ひらがな、カタカナ、漢字で入力してね～（o・▽・o）";
				errorUserAddressList.add(errorUserAddress);
				errorCountUser++;
			}


			// エラーカウント集計、0以上の場合エラーを返す
			if (errorCountUser> 0) {
				ret= ERROR;
			}

			// 何もエラーがない場合、sessionにすべてセットする
			else {
				session.put("userId", userId);
				session.put("password", password);
				session.put("email", email);
				session.put("familyName", familyName);
				session.put("firstName", firstName);
				session.put("familyNameKana", familyNameKana);
				session.put("firstNameKana", firstNameKana);
				session.put("year", year);
				session.put("month", month);
				session.put("day", day);
				session.put("birthDay", birthDay);

				// String型できた性別をInt型に変換、sexNumとして登録
				sexNum= Integer.parseInt(sex);
				session.put("sex", sexNum);
				session.put("telNumber", telNumber);
				session.put("postNumber", postNumber);
				session.put("address", address);
			}
		}

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

	public String getErrorUser() {
		return errorUser;
	}

	public void setErrorUser(String errorUser) {
		this.errorUser = errorUser;
	}

	public String getErrorUserId() {
		return errorUserId;
	}

	public void setErrorUserId(String errorUserId) {
		this.errorUserId = errorUserId;
	}

	public ArrayList<String> getErrorUserIdList() {
		return errorUserIdList;
	}

	public void setErrorUserIdList(ArrayList<String> errorUserIdList) {
		this.errorUserIdList = errorUserIdList;
	}

	public String getErrorUserPass() {
		return errorUserPass;
	}

	public void setErrorUserPass(String errorUserPass) {
		this.errorUserPass = errorUserPass;
	}

	public ArrayList<String> getErrorUserPassList() {
		return errorUserPassList;
	}

	public void setErrorUserPassList(ArrayList<String> errorUserPassList) {
		this.errorUserPassList = errorUserPassList;
	}

	public String getErrorUserMail() {
		return errorUserMail;
	}

	public void setErrorUserMail(String errorUserMail) {
		this.errorUserMail = errorUserMail;
	}

	public ArrayList<String> getErrorUserMailList() {
		return errorUserMailList;
	}

	public void setErrorUserMailList(ArrayList<String> errorUserMailList) {
		this.errorUserMailList = errorUserMailList;
	}

	public String getErrorUserFam() {
		return errorUserFam;
	}

	public void setErrorUserFam(String errorUserFam) {
		this.errorUserFam = errorUserFam;
	}

	public ArrayList<String> getErrorUserFamList() {
		return errorUserFamList;
	}

	public void setErrorUserFamList(ArrayList<String> errorUserFamList) {
		this.errorUserFamList = errorUserFamList;
	}

	public String getErrorUserFir() {
		return errorUserFir;
	}

	public void setErrorUserFir(String errorUserFir) {
		this.errorUserFir = errorUserFir;
	}

	public ArrayList<String> getErrorUserFirList() {
		return errorUserFirList;
	}

	public void setErrorUserFirList(ArrayList<String> errorUserFirList) {
		this.errorUserFirList = errorUserFirList;
	}

	public String getErrorUserFamKana() {
		return errorUserFamKana;
	}

	public void setErrorUserFamKana(String errorUserFamKana) {
		this.errorUserFamKana = errorUserFamKana;
	}

	public ArrayList<String> getErrorUserFamKanaList() {
		return errorUserFamKanaList;
	}

	public void setErrorUserFamKanaList(ArrayList<String> errorUserFamKanaList) {
		this.errorUserFamKanaList = errorUserFamKanaList;
	}

	public String getErrorUserFirKana() {
		return errorUserFirKana;
	}

	public void setErrorUserFirKana(String errorUserFirKana) {
		this.errorUserFirKana = errorUserFirKana;
	}

	public ArrayList<String> getErrorUserFirKanaList() {
		return errorUserFirKanaList;
	}

	public void setErrorUserFirKanaList(ArrayList<String> errorUserFirKanaList) {
		this.errorUserFirKanaList = errorUserFirKanaList;
	}

	public String getErrorUserSex() {
		return errorUserSex;
	}

	public void setErrorUserSex(String errorUserSex) {
		this.errorUserSex = errorUserSex;
	}

	public ArrayList<String> getErrorUserSexList() {
		return errorUserSexList;
	}

	public void setErrorUserSexList(ArrayList<String> errorUserSexList) {
		this.errorUserSexList = errorUserSexList;
	}

	public String getErrorUserTel() {
		return errorUserTel;
	}

	public void setErrorUserTel(String errorUserTel) {
		this.errorUserTel = errorUserTel;
	}

	public ArrayList<String> getErrorUserTelList() {
		return errorUserTelList;
	}

	public void setErrorUserTelList(ArrayList<String> errorUserTelList) {
		this.errorUserTelList = errorUserTelList;
	}

	public String getErrorUserPost() {
		return errorUserPost;
	}

	public void setErrorUserPost(String errorUserPost) {
		this.errorUserPost = errorUserPost;
	}

	public ArrayList<String> getErrorUserPostList() {
		return errorUserPostList;
	}

	public void setErrorUserPostList(ArrayList<String> errorUserPostList) {
		this.errorUserPostList = errorUserPostList;
	}

	public String getErrorUserAddress() {
		return errorUserAddress;
	}

	public void setErrorUserAddress(String errorUserAddress) {
		this.errorUserAddress = errorUserAddress;
	}

	public ArrayList<String> getErrorUserAddressList() {
		return errorUserAddressList;
	}

	public void setErrorUserAddressList(ArrayList<String> errorUserAddressList) {
		this.errorUserAddressList = errorUserAddressList;
	}

	public UserCreateDAO getUserCreateDAO() {
		return userCreateDAO;
	}

	public void setUserCreateDAO(UserCreateDAO userCreateDAO) {
		this.userCreateDAO = userCreateDAO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getErrorUserBirth() {
		return errorUserBirth;
	}

	public void setErrorUserBirth(String errorUserBirth) {
		this.errorUserBirth = errorUserBirth;
	}

	public ArrayList<String> getErrorUserBirthList() {
		return errorUserBirthList;
	}

	public void setErrorUserBirthList(ArrayList<String> errorUserBirthList) {
		this.errorUserBirthList = errorUserBirthList;
	}



}
