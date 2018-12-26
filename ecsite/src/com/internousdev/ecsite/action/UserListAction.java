package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserinfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {

	public List<UserinfoDTO> userInfoDTOList = new ArrayList<UserinfoDTO>();
	private Map<String, Object>session;

	public String execute(){
		String ret = ERROR;
		UserListDAO dao = new UserListDAO();

		userInfoDTOList = dao.select();

		if(userInfoDTOList.size() >0){
			session.put("userInfoDTOList", userInfoDTOList);
			ret = SUCCESS;

		}else {
			ret = ERROR;
		}
		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object>session){
		this.session = session;
	}

}
