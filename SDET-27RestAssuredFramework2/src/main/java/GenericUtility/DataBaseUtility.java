package GenericUtility;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.sun.jdi.connect.spi.Connection;

/**
 * 
 * @author SUHAS RAVINDRA
 *
 */

public class DataBaseUtility {
	java.sql.Connection con=null;
	//Register the database
	//get connection
	//create issue statement
	//execute the query
	//close the connection

	public void connecttoDB() throws SQLException 
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUsername, IConstants.dbPassword);
	}

	public String ExecuteQueryAndGetData(String query, int columnIndex, String expData) throws SQLException  
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag=true;  //rising flag
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+ "Data verified ");
			return expData;
		}
		else
		{
			System.out.println("Data not present");
			return "";
		}
	}

	public void closeDB() throws IOException, SQLException  {
		//close the database connection

		con.close();
	}
}