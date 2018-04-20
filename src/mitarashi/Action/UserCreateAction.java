package mitarashi.Action;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware{

	// 変数用意
		// ユーザーID
		private String userId;

		// パスワード
		private String password;

		// 姓
		private String familyName;

		// 名
		private String firstName;

		// 姓よみがな
		private String familyNameKana;

		// 名よみがな
		private String firstNameKana;

		// 性別
		private int sex;
		private String sexNum;

		// 誕生日
		private String birthDay;

		// メールアドレス
		private String email;


		// 未入力エラー
		private String errorUser;

		// IDに関するエラー
		private String errorUserId;
		// IDに関するエラーリスト
		private ArrayList<String> errorUserIdList= new ArrayList();

		// パスワードに関するエラー
		private String errorUserPass;
		// パスワードに関するエラーリスト
		private ArrayList<String> errorUserPassList= new ArrayList();

		// 姓に関するエラー
		private String errorUserFam;
		// 姓に関するエラーリスト
		private ArrayList<String> errorUserFamList= new ArrayList();

		// 名に関するエラー
		private String errorUserFir;
		// 名に関するエラーリスト
		private ArrayList<String> errorUserFirList= new ArrayList();

		// 姓よみがなに関するエラー
		private String errorUserFamKana;
		// 姓よみがなに関するエラーリスト
		private ArrayList<String> errorUserFamKanaList= new ArrayList();

		// 名よみがなに関するエラー
		private String errorUserFirKana;
		// 名よみがなに関するエラーリスト
		private ArrayList<String> errorUserFirKanaList= new ArrayList();

		// 性別に関するエラー
		private String errorUserSex;
		// 性別に関するエラーリスト
		private ArrayList<String> errorUserSexList= new ArrayList();

		// メールアドレスに関するエラー
		private String errorUserMail;
		// メールアドレスに関するエラーリスト
		private ArrayList<String> errorUserMailList= new ArrayList();



	public String execute() throws SQLException {
		// エラー前提で結果を返す
		String ret= ERROR;

		// ERROR判定に使用 0ならSUCCESS、1以上の場合ERROR
		int errorCount= 0;



	}

}
