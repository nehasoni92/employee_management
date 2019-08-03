package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;


import dbutil.MySQLConnection;
import exception.BusinessException;


public class LoginDAO {

	public boolean isValidUser(User user) throws BusinessException, ClassNotFoundException, SQLException
	{
		boolean b=false;
		 MySQLConnection.getConnection();
/*		try(Connection connection = MySQLConnection.getConnection())
		{
			String sql="select user_id from login_master where user_id=?, password=?, role=? ";
			PreparedStatement preparedstatement=connection.prepareStatement(sql); 
			preparedstatement.setInt(1, user.getUser_id() );
			preparedstatement.setString(2, user.getPassword());
			preparedstatement.setString(3, user.getRole());
			ResultSet resultSet=preparedstatement.executeQuery();
			if(resultSet.next()){
				b=true;
			}else{
				throw new BusinessException("Invalid Logon Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error....."+e);
		}*/
		
		return b;
	}

		
}
