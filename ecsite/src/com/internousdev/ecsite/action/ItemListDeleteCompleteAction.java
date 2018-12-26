package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {

	public String deleteFlg;
	private String result;

	public String execute()throws SQLException{

	    ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();
		int res = dao.itemListDelete();

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
