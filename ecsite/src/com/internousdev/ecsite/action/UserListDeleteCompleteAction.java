package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteComplereDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {

	public String deleteFlg;
	private String result;

	public String execute()throws SQLException{

	    UserListDeleteComplereDAO dao = new UserListDeleteComplereDAO();
		int res = dao.userListDelete();

		if(res>0){
			System.out.println("商品情報は正しく削除されました。");
			result=SUCCESS;
		}else if(res == 0){
			System.out.println("商品情報の削除に失敗しました。");
			result=ERROR;
		}
		return result;
	}

}
