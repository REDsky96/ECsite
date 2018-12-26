package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.IteminfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {



		List<IteminfoDTO>itemInfoDTOList = new ArrayList<IteminfoDTO>();

		public List<IteminfoDTO>select(){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "select item_name, item_price, item_stock, insert_date from item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while(resultSet.next()){
	        	IteminfoDTO dto = new IteminfoDTO();
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				itemInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemInfoDTOList;

		}
}
