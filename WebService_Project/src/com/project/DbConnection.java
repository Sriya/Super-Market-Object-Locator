package com.project;
import java.sql.DriverManager;
import java.sql.Connection;


public class DbConnection {
	
	// Below is the format of jdbc url for MySql database.
	public static final String URL =
	"jdbc:mysql://localhost/testdb";
	 
	// The username for connecting to the database
	public static final String USERNAME = "root";
	 
	// The password for connecting to the database
	public static final String PASSWORD = "";
 
	public static void main(String[] args) throws Exception
	{
	Connection connection = null;
	try
	{
	// Register a database jdbc driver to be used by
	// our program. In this example I choose a MySQL
	// driver.
	Class.forName("com.mysql.jdbc.Driver");
	 
	// Get the connection object from the driver manager
	// by passing the url of our database, username and
	// the password.
	connection = DriverManager.getConnection(URL,
	USERNAME, PASSWORD);
	 
	// Do what ever you want to do with the connection
	// object, such as reading some records from database,
	// updating or deleting a row. But don't for get the
	// close the connection right after you've finished
	// using it.
	} finally
	{
	if (connection != null)
	{
	connection.close();
	}
	}
}

}
