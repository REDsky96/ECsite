package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.IteminfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {

	public List<IteminfoDTO> itemInfoDTOList = new ArrayList<IteminfoDTO>();
	private Map<String, Object>session;

	public String execute(){
		String ret = ERROR;
		ItemListDAO dao = new ItemListDAO();

		itemInfoDTOList = dao.select();

		if(itemInfoDTOList.size() >0){
			session.put("itemInfoDTOList", itemInfoDTOList);
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
