package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BlockCRUD {
	
	private DBConnection db;
	
	public BlockCRUD(DBConnection db){
		this.db = db;
	}
	
	public void insert(String topic, String description, String date, String timeZone) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Block" + " values( " + "?,?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
        	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	  
	        try {
	        	java.sql.Date date1 = new java.sql.Date( dateformat.parse(date).getTime());

				
				pstmt.setObject(1, topic);
	            pstmt.setObject(2, description);
	            pstmt.setObject(3, date1);
	            pstmt.setObject(4, timeZone);

	            pstmt.execute();
	            
			} catch (ParseException e) {
				e.printStackTrace();
			}
	            
            
        }
        con.close();
    }
	
	public void insertBlockActivity(String name,String topic) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Block_Activity" + " values( " + "?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, topic);
	            pstmt.setObject(2, name);

	            pstmt.execute();	                                 
        }
        con.close();
    }
}
