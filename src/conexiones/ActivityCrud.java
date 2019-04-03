package conexiones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityCrud {

	private DBConnection db;
	
	public ActivityCrud(DBConnection db){
		this.db = db;
	}
	
	public void insertOriginalData(String type, String name, String date, String sTime, String fTime, String description) throws SQLException {
		 	Connection con = db.openConnection();
	        String sql = "insert into " + "Activity" + " values( " + "?,?,?,?,?,?" + ")";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        	
	        	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		  
		        try {
		        	java.sql.Date date1 = new java.sql.Date( dateformat.parse(date).getTime());

					
					pstmt.setObject(1, type);
		            pstmt.setObject(2, name);
		            pstmt.setObject(3, date1);
		            pstmt.setObject(4, sTime);
		            pstmt.setObject(5, fTime);
		            pstmt.setObject(6, description);

		            pstmt.execute();
		            
				} catch (ParseException e) {
					e.printStackTrace();
				}
		            
	            
	        }
	        con.close();
	    }
}
