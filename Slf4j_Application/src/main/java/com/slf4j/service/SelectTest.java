package com.slf4j.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class SelectTest {
	private static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	//Logger object
	private static Logger logger=LoggerFactory.getLogger(SelectTest.class);
	
	public static void main(String[] args) {
		
		logger.debug("start of main method");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			logger.debug("start of try block");
			//load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.info("JDBC driver class is loaded");
			
			//establish connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			logger.info("Connection is established");
			
			//create preparedStatement object
			ps=con.prepareStatement(GET_ALL_EMPS);
			logger.info("PreparedStatement object is created");
			
			//execute the Query
			rs=ps.executeQuery();
			logger.info("JDBC Resultset object is created");
			
			//process the ResultSet
			int count=0;
			while(rs.next()) {
				count++;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
			}//while
			logger.info("JDBC Resultset object processed");
			if(count==0) {
				System.out.println("No Records Found in the Database table");
				logger.warn("ResultSet object should not be the empty object in any give case");
			}
			logger.debug("end of try block");
		}//try
		catch(SQLException se) {
			logger.error("DB Problem :"+se.getMessage());
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			logger.error("Problem in Loading JDBC driver class");
			cnf.printStackTrace();
		}
		catch(Exception e) {
			logger.error("Unknown problem in the Application"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close jdbc objects
			logger.debug("start of finally block");
			try {
				if(rs!=null)
					rs.close();
				logger.info("close of Resultset object");
			}
			catch(SQLException se) {
				logger.error("Problem in closing the Resultset object");
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					logger.info("PreparedStatement object is closed");
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				logger.error("Problem in closing preparedStatement object");
			}
			try {
				if(con!=null)
					con.close();
				logger.info("Connection object is closed");
			}
			catch(SQLException se) {
				se.printStackTrace();
				logger.error("Problem in closing the JDBC Connction object");
			}
			logger.debug("end of the finally block");
		}//finally
		logger.debug("end of main method");
	}//main
}//class
