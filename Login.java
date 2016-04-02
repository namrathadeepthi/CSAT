package csatdisplay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	
	public boolean getUserAuthenticationDetails(String username, String role) throws Exception{
		  boolean accessstatus =false;
		  Connection connection = null;
		  ResultSet userdetailsresults=null;
		  String logincredentialquery = "select Role_ID, User_name from UsersAndRoles where Role_ID =? and User_name=? ";
		  
		  //String insertauthenticateuserquery = "insert into user_authentication_details values(?,?,?,? )";

		  try{


			connection = DaoUtil.getMySqlDBConnection();


		  PreparedStatement pstmt =connection.prepareStatement(logincredentialquery);
		  pstmt.setString(1, role);
		  pstmt.setString(2, username);

		  userdetailsresults = pstmt.executeQuery();
		  if(userdetailsresults.next()){


			  accessstatus =true;

		  }

		  }catch (SQLException e){

	         e.printStackTrace();
	      }

		  finally{
			 if(userdetailsresults!=null){

			  userdetailsresults.close();
			 }

		  }

		  return accessstatus;

	  }
	
}
