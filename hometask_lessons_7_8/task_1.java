package hometask_borovsky_7_8_lessons;

//1) Встановити MySql Server, налаштувати db connection & db schema.  
//	Створити таблиці та заповнити їх даними.  
//	Засобами jdbc підєднатись до створеної таблиці та отримати з неї дані. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class task_1 {

		private static final String url = "jdbc:mysql://localhost:3306/lits";
		private static final String user = "root";
		private static final String password = "1";

		private static Connection conn;
		private static Statement statem;
		private static ResultSet resume;
				 
			public static void main(String args[]) {
			String query = "select * from students";
			       try {
			    	   conn = DriverManager.getConnection(url, user, password);
				       statem = conn.createStatement();
				       resume = statem.executeQuery(query);
				             
				           while (resume.next()) {
				                int id = resume.getInt("id");
				                String name = resume.getString("name");
				            	int age = resume.getInt("age");
				                System.out.println(id+ " "+name+" "+age);
				            }
				       }
			       
			       
			       catch (SQLException sqlEx) {sqlEx.printStackTrace();}
			       
			       finally {
				            try { conn.close();} catch(SQLException se) {}
				            try { statem.close();} catch(SQLException se) {}
				            try { resume.close();} catch(SQLException se) {}
				        }
				    }
		
	}


