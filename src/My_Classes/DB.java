package My_Classes;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aldin
 */
public class DB {

//Pravimo konekciju izmedju projekta i mysql-a
    
    private static String username = "root";
    private static String servername = "localhost";
    private static String dbname = "java_library_system";
    private static Integer portNumber = 3306;
    private static String password = ""; //nema sifre
    
    
    //funkcija za konekciju

    /**
     *
     * @return
     * @throws SQLException
     */
    
    public static Connection getConnection() throws SQLException
    {
        Connection connection = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portNumber);
        datasource.setPassword(password);
        
        
        try{
            connection = datasource.getConnection();
        }catch(SQLException ex){
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
}