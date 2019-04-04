package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCRUD {

	private DBConnection db;
	
	public UserCRUD(DBConnection db){
		this.db = db;
	}
	
	public void insert(int id, String sex, String email, String name, String lastN, String lastN2, String password, String identityP) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Supervisor" + " values( " + "?,?,?,?,?,?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, sex);
	            pstmt.setObject(3, email);
	            pstmt.setObject(4, name);
	            pstmt.setObject(5, lastN);
	            pstmt.setObject(6, lastN2);
	            pstmt.setObject(7, password);
	            pstmt.setObject(8, identityP);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
	public void insertComments(String id,String name, String description) throws SQLException {
	 	Connection con = db.openConnection();
        String sql = "insert into " + "Block_Activity" + " values( " + "?,?,?" + ")";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setObject(1, id);
	            pstmt.setObject(2, name);
	            pstmt.setObject(3, description);

	            pstmt.execute();	                                 
        }
        con.close();
    }
	
}
