package com.example.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTest {
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/logstas";
	static String username="postgres";
	static String password="pass";
	
	public static void  updateStudents() {
		
	try {
		
	   Connection connection = DriverManager.getConnection(jdbcURL, username, password);
	   System.out.println("connected to postgres sql server");
	   
	   String sql = "UPDATE STUDENTS set MARKS = 100 where id=198";
	   Statement statement = connection.createStatement();
	   ResultSet result = statement.executeQuery("SELECT * FROM students;");
	   
	  while(result.next()) {
		  int id = result.getInt("id");
            String  name = result.getString("name");
            int marks  = result.getInt("marks");
            String  favorite = result.getString("favorite");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "FAVORITE = " + favorite );
            System.out.println( "MARKS = " + marks);
            System.out.println();
	  }
	   
	   connection.close();
	   
}catch(SQLException e) {
	System.out.println("Error in connecting to postgres server");
	e.printStackTrace();
	
}
	
}
	
	public static void deleteStudent() {
		try {
			
			   Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			   System.out.println("connected to postgres sql server");
			   
			   String sql = "DELETE STUDENTS set MARKS = 100 where id=198";
			   Statement statement = connection.createStatement();
			   ResultSet result = statement.executeQuery("SELECT * FROM students;");
			   
			  while(result.next()) {
				  int id = result.getInt("id");
		            String  name = result.getString("name");
		            int marks  = result.getInt("marks");
		            String  favorite = result.getString("favorite");
		            System.out.println( "ID = " + id );
		            System.out.println( "NAME = " + name );
		            System.out.println( "FAVORITE = " + favorite );
		            System.out.println( "MARKS = " + marks);
		            System.out.println();
			  }
			   
			   connection.close();
			   
		}catch(SQLException e) {
			System.out.println("Error in connecting to postgres server");
			e.printStackTrace();
			
	}

}
		public static void readStudent() {
			
			try {
				
				   Connection connection = DriverManager.getConnection(jdbcURL, username, password);
				   System.out.println("connected to postgres sql server");
				   
				   String sql = "INSERT INTO Students (id, favorite, marks, name)"
						   +"VALUES('198','TRUE',95,'MEENAL')";
				   Statement statement = connection.createStatement();
				   ResultSet result = statement.executeQuery("SELECT * FROM students;");
				   
				  int rows =statement.executeUpdate(sql);
				  if(rows>0) {
					  System.out.println("A new row has been inserted");
				  }
				   
				   connection.close();
				   
			}catch(SQLException e) {
				System.out.println("Error in connecting to postgres server");
				e.printStackTrace();
				
		}

			
			
		}
		
		public static void selectStudent() {
			
			try {
				
				   Connection connection = DriverManager.getConnection(jdbcURL, username, password);
				   System.out.println("connected to postgres sql server");
				   
				   String sql = "SELECT * FROM students";
				   Statement statement = connection.createStatement();
				   ResultSet result = statement.executeQuery(sql);
				   
				 while (result.next()) {
					 int id=result.getInt("id");
					 String Name=result.getString("name");
					 String Favorite=result.getString("favorite");
					 String Marks=result.getString("marks");
					 
					 System.out.printf("%d - %s - %s -%s\n",id, Name, Favorite,Marks);
				  }
				   
				   connection.close();
				   
			}catch(SQLException e) {
				System.out.println("Error in connecting to postgres server");
				e.printStackTrace();
				
		}

			
			
			
		}

}
