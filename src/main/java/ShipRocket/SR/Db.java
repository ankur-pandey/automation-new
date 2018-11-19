package ShipRocket.SR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.RandomUtils;

public class Db{
	
	public String mobileNumber() {
		String number = System.currentTimeMillis() + "";
		number = RandomUtils.nextInt(7, 10) + number.substring(4, 13);
		return number;
	}


	public String getOTP(String ConnectioString, String userName, String pwd, String mobNo) {
		String otp = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(ConnectioString, userName, pwd);
			System.out.println("DB COnnected");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT * FROM `users`");
			while(rs.next()) {
				String mobile = rs.getString("mobile");
				otp = rs.getString("otp");
				if(mobile.equals(mobNo)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;
	}
}
