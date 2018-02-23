/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weatherPrediction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//connect to database for visualization
public class dBConnect {
	final public static String DRIVER="com.mysql.jdbc.Driver";
	final  public static String DB_URL="jdbc:mysql://localhost:3306/weather_db";
	public  final static String DB_USER="root";
	public final static String DB_PASS="";
	
	public dBConnect(){
		 try {
		        //initialize driver
		        Class.forName(DRIVER);
		    } catch (ClassNotFoundException ex) {
		       System.out.println(ex);
		    } 
		    
	}
		   
		    
	public static Connection connect() throws SQLException{
            Connection Con = null;
            try {
                Con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                
            } catch (SQLException ex) {
                Logger.getLogger(dBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
           
//            String sql;
//            sql = "INSERT INTO `weather`(`date`, `Tmax`, `Tmin`, `humidity`, `rainfall`)  VALUES (?,?,?,?,?)";
//            PreparedStatement pstmt=Con.prepareStatement(sql);
//       
//            pstmt.setInt(1,500);
//            pstmt.setInt(2,5);
//            pstmt.setInt(3,3);
//            pstmt.setInt(4,25);
//            pstmt.setInt(5,25);
//           
//            pstmt.executeUpdate();
//            pstmt.close();
//            Con.close();
            return Con;
	   
		
	}

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	}
	 
