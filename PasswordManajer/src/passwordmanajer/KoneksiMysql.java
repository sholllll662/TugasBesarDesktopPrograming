package passwordmanajer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class KoneksiMysql {
    private Connection koneksi;
    public Connection fikskonek(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("berhasil konek");
        }catch(ClassNotFoundException ex){
            System.out.println("gagal koneksi"+ex);
        }
        
        String url = "jdbc:mysql://localhost/pm";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("berhasil koneksi database");
        } catch (SQLException ex) {
            System.out.println("gagal koneksi database"+ex);
        }
        return koneksi;
        
    }
    
}
