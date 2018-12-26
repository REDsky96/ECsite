package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {


	private Map<String, Object> session;

	public String execute() throws SQLException{
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
				session.get("loginPassword").toString(),
				session.get("userName").toString());//ここの3つはconfirmActionから来ている。この3つが引数となってDAO経由でDBに格納される。
		String result = SUCCESS;
		return result;
	}



	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
}
