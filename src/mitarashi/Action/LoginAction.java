package mitarashi.Action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import mitarashi.DAO.LoginDAO;
import mitarashi.DTO.LoginDTO;

public class LoginAction extends ActionSupport implements SessionAware {

	// 変数用意
		// ログインID
		private String userId;

		// パスワード
		private String password;

		// 商品詳細から遷移した場合
		private String productFlg;

		// ログインID保存
		private String loginMemory= "";

		// session
		public Map<String, Object> session;


		// 未入力エラー
		private String errorLog;

		// IDに関するエラー
		private String errorLogId;

		// IDに関するエラーリスト
		private ArrayList<String> errorLogIdList;

		// パスワードに関するエラー
		private String errorLogPass;

		// パスワードに関するエラーリスト
		private ArrayList<String> errorLogPassList;

		private LoginDAO loginDAO= new LoginDAO();
		private LoginDTO loginDTO= new LoginDTO();


	// ログイン実行
	public String execute() throws SQLException {
		// エラー前提で結果を返す
		String ret= ERROR;

		// ERROR判定に使用 0ならSUCCESS、1以上の場合ERROR
		int errorCount= 0;


		// 未入力項目があった場合
		if (userId.equals("") || password.equals("")) {
			errorLog= "未入力項目があります（o・▽・o）";
			session.put("errorLog", errorLog);
			errorCount++;
		}


		// IDに関するエラー
		// errorLogIdにセットしerrorLogIdListに詰め、jspでiteratorにより表示
		// 文字数エラー
		if (userId.length()<3 || userId.length()>16 && !userId.equals("")) {
			errorLogId= "3文字以上16文字以下で入力してください（o・▽・o）";
			errorLogIdList.add("errorLogId");
			errorCount++;
		}

		// 文字種エラー
		if (!userId.matches("^[0-9a-zA-Z]+$") && !userId.equals("")) {
			errorLogId= "半角英数字で入力してください（o・▽・o）";
			errorLogIdList.add("errorLogId");
			errorCount++;
		}


		// パスワードに関するエラー
		// errorLogPassにセットしerrorLogPassListに詰め、jspでiteratorにより表示
		// 文字数エラー
		if (password.length()<3 || password.length()>16 && !password.equals("")) {
			errorLogPass= "3文字以上16文字以下で入力してください（o・▽・o）";
			errorLogPassList.add("errorLogPass");
			errorCount++;
		}

		// 文字種エラー
		if (!password.matches("^[0-9a-zA-Z]+$") && !password.equals("")) {
			errorLogPass= "半角英数字で入力してください（o・▽・o）";
			errorLogPassList.add("errorLogPass");
			errorCount++;
		}

		// errorCount集計、0以上の場合ERRORを返す
		if (errorCount> 0) {
			ret= ERROR;
			return ret;
		}


		// LoginDAOのgetLoginUserInfoにuserId、passwordをセットし、user_infoと照合
		loginDTO= loginDAO.getLogin(userId, password);

		if (userId.equals(loginDTO.getUserId()) && password.equals(loginDTO.getPassword())) {
			ret= SUCCESS;

			// sessionにuserId、password、loginDAOから返ってきたloginFlgのtrueをセット
			session.put("userId", loginDTO.getUserId());
			session.put("password", loginDTO.getPassword());
			session.put("loginFlg", loginDTO.getLoginFlg());

			// loginMemoryにチェックが入っている場合、1がくる
			// loginDTOにセット
			if (loginMemory.equals("1")) {
				loginDTO.setLoginMemory("1");
				ret= SUCCESS;
			}

			// チェックが入っていない場合はそのままSUCCESSを返す
			else {
				ret= SUCCESS;
			}

			return ret;
		}

		else {
			errorLog= "ログインIDかパスワードが違うよ～（o・▽・o）";
			session.put("errorLog", errorLog);
			ret= ERROR;
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


	public String getProductFlg() {
		return productFlg;
	}


	public void setProductFlg(String productFlg) {
		this.productFlg = productFlg;
	}


	public String getLoginMemory() {
		return loginMemory;
	}


	public void setLoginMemory(String loginMemory) {
		this.loginMemory = loginMemory;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getErrorLog() {
		return errorLog;
	}


	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}


	public String getErrorLogId() {
		return errorLogId;
	}


	public void setErrorLogId(String errorLogId) {
		this.errorLogId = errorLogId;
	}


	public ArrayList<String> getErrorLogIdList() {
		return errorLogIdList;
	}


	public void setErrorLogIdList(ArrayList<String> errorLogIdList) {
		this.errorLogIdList = errorLogIdList;
	}


	public String getErrorLogPass() {
		return errorLogPass;
	}


	public void setErrorLogPass(String errorLogPass) {
		this.errorLogPass = errorLogPass;
	}


	public ArrayList<String> getErrorLogPassList() {
		return errorLogPassList;
	}


	public void setErrorLogPassList(ArrayList<String> errorLogPassList) {
		this.errorLogPassList = errorLogPassList;
	}


	public LoginDAO getLoginDAO() {
		return loginDAO;
	}


	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}


	public LoginDTO getLoginDTO() {
		return loginDTO;
	}


	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}


}
