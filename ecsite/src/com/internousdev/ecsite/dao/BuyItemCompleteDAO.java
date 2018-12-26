package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private DateUtil dateUtil = new DateUtil();

	private String sql = "insert into user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date, item_name) values(?,?,?,?,?,?,?)";

	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay, String item_name) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());
		    preparedStatement.setString(7, item_name);


			preparedStatement.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
