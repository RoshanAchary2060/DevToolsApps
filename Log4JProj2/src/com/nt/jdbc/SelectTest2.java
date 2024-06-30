 package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class SelectTest2 {
	private static Logger logger = Logger.getLogger(SelectTest2.class);

	static {
		try {
			DOMConfigurator.configure("src/com/nt/commons/log4j.xml");
			logger.info("com.nt.jdbc.SelectTest::Log4j Setup ready");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("com.nt.jdbc.SelectTest:: Problem while setting up log4j");
		}
	}

	public static void main(String[] args) {
		logger.debug("com.nt.jdbc.SelectTest:: start of main() method");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// load jdbc driver class
			Class.forName("oracle.jdbc.OracleDriver");
			logger.debug("com.nt.jdbc.SelectTest:: JDBC driver class loaded");
			// establish the connection (road)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//ROSHANPRO:1521/xe", "spring", "spring");
			logger.info("com.nt.jdbc.SelectTest:: connection is established with DB s/w");
			// create JDBC Statement object (vehicle)
			st = conn.createStatement();
			logger.debug("com.nt.jdbc.SelectTest:: Statement object is created");
			// send and execute SQL SELECT query in DB s/w and get JDBC ResultSet object
			rs = st.executeQuery("SELECT * FROM realtimedi_customer");
			logger.debug("com.nt.jdbc.SelectTest:: sql query is executed and ResultSet object is created");

			// process the ResultSet object
			logger.warn("com.nt.jdbc.SelectTest:: only some records of ResultSet object are retrieved!");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2));
				}
			logger.debug("com.nt.jdbc.SelectTest:: ResultSet object is processed");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			logger.error("com.nt.jdbc.SelectTest:: Driver class not loaded");
		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("com.nt.jdbc.SelectTest:: known db error:: " + ex.getMessage() + " sql error code:: "
					+ ex.getErrorCode());
		} catch (Exception ex) {
			logger.fatal("com.nt.jdbc.SelectTest:: Unknown problem " + ex.getMessage());
		} finally {

			try {

				// close jdbc objects
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
				logger.debug("com.nt.jdbc.SelectTest:: all jdbc objects closed");
			} catch (SQLException ex) {
				System.out.println("Error in DB");
				logger.error("com.nt.jdbc.SelectTest:: error in closing objects-> " + ex.getMessage());
			}

		}
		logger.debug("com.nt.jdbc.SelectTest:: end of main() method");

	}
}
