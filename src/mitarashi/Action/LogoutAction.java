package mitarashi.Action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import mitarashi.DTO.LoginDTO;

public class LogoutAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private LoginDTO loginDTO= new LoginDTO();

	public String execute() throws SQLException{
		// sessionをすべて消す（ログインしていない状態にする）
		loginDTO.setUserId(session.get("userId").toString());
		session.clear();
		String ret= ERROR;

		// ID保存がされていたらloginDTOにセットしたログインIDをsessionに入れ直す
		if (loginDTO.getLoginMemory() == "1") {
			session.put("loginMemoryId", loginDTO.getUserId());
			ret= SUCCESS;
		}

		// そうでなくても成功を返す、上記のERRORは一応
		else {
			ret= SUCCESS;
		}

		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}






}
