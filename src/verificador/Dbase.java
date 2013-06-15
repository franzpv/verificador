/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author franz
 */
public class Dbase {
    
    private String DBName = "tooitr";
    private String DBUsername = "root";
    private String DBPassword = "root";
    private String DBPort = "8889";
    private String DBUrl = "jdbc:mysql://localhost:"+DBPort+"/"+DBName;
    private Connection connection;
    public Statement statement;
    
    public Dbase(){
    }
    
    public boolean makeConnection() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
            statement = connection.createStatement();
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tablaCredentials = metaData.getTables(null, null, "dataset", null);
            if (!tablaCredentials.next()){
                int result = statement.executeUpdate("CREATE TABLE `dataset` (\n" +
                    "  `tweet_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                    "  `user_id` varchar(50) DEFAULT NULL,\n" +
                    "  `user_name` varchar(70) DEFAULT NULL,\n" +
                    "  `text` varchar(300) DEFAULT NULL,\n" +
                    "  `latitude` varchar(50) DEFAULT NULL,\n" +
                    "  `longitude` varchar(50) DEFAULT NULL,\n" +
                    "  `followers` int(10) unsigned DEFAULT NULL,\n" +
                    "  `following` int(10) unsigned DEFAULT NULL,\n" +
                    "  `tweets` int(10) unsigned DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`tweet_id`)\n" +
                    ") ENGINE=InnoDB  DEFAULT CHARSET=latin1;");
            }
            return true;
        }catch(SQLException error){
            System.out.println(error);
            return false;
        }
    }
}


