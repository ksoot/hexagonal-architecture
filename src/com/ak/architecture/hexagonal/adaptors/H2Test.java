package com.ak.architecture.hexagonal.adaptors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2Test {
	public static void main(String[] args) throws SQLException {

		Thread read = new Thread(new ReadRunanle());
		Thread update = new Thread(new WriteRunanle());

		read.start();
		update.start();
	}

}

class ReadRunanle implements Runnable {

	@Override
	public void run() {
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");) {
			
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			con.setSchema("PRACTICE_SQL");
			PreparedStatement ps = con.prepareStatement("select * from employees where id =1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Reader : " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class WriteRunanle implements Runnable {

	@Override
	public void run() {
		
		try (Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");) {
			
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			con.beginRequest();
			con.setAutoCommit(false);
			con.setSchema("PRACTICE_SQL");
			
			PreparedStatement ps1 = con.prepareStatement("select * from employees where id = 1");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				System.out.println("before update : " + rs.getString(2));
			}
			
			PreparedStatement ps = con.prepareStatement("update employees set name='nimmi' where id=1");

			int i = ps.executeUpdate();
			printit(i);
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	private void printit(int i) {
		System.out.println("Writer : " + i);
		throw new RuntimeException();
		
	}

}