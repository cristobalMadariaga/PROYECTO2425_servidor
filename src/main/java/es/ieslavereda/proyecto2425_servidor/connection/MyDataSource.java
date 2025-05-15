package es.ieslavereda.proyecto2425_servidor.connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class MyDataSource {
    @Bean(name="mysqlDataSource")
    public static DataSource getMyDataSource(){
        Properties properties = new Properties();
        MysqlDataSource dataSource = null;

        try(FileInputStream fis = new FileInputStream("db.properties")){
            properties.load(fis);
            dataSource = new MysqlDataSource();
            //to do añadir URL, USER & PASSWORD
            dataSource.setUser("MYSQL_DB_USERNAME");
            dataSource.setPassword("MYSQL_DB_PASSWORD");
            dataSource.setURL("MYSQL_DB_URL");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

}
