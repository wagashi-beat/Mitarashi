package mitarashi.DTO;

public class LoginDTO {

	// ユーザーIDを保存
	private String userId;

	// パスワードを保存
	private String password;

	// ログインID保存
	private String loginMemory;

	// 新規ユーザー登録チェック
	// 初期値(false)の場合：ID登録済み（登録不可）
	// userCreateDAOからtrueがきた場合：登録可
	private boolean getUserCheckFlg= false;

	// ログイン状態を管理
	// 初期値(false)の場合：未ログイン状態
	// DAOからtrueがセットされた場合：ログイン状態となる
	private boolean loginFlg= false;



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

	public String getLoginMemory() {
		return loginMemory;
	}

	public void setLoginMemory(String loginMemory) {
		this.loginMemory = loginMemory;
	}


	public boolean getGetUserCheckFlg() {
		return getUserCheckFlg;
	}

	public void setGetUserCheckFlg(boolean getUserCheckFlg) {
		this.getUserCheckFlg = getUserCheckFlg;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

}
