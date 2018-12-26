package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserinfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	List<UserinfoDTO>userInfoDTOList = new ArrayList<UserinfoDTO>();

	public List<UserinfoDTO>select(){

	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	String sql = "select login_id, login_pass, user_name, insert_date from login_user_transaction";

	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
        	UserinfoDTO dto = new UserinfoDTO();
			dto.setLoginId(resultSet.getString("login_id"));
			dto.setLoginPassword(resultSet.getString("login_pass"));
			dto.setUserName(resultSet.getString("user_name"));
			dto.setInsertDate(resultSet.getString("insert_date"));
			userInfoDTOList.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return userInfoDTOList;

	}

}
