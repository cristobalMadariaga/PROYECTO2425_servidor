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
        MysqlDataSource dataSource = new MysqlDataSource();
        //to do añadir URL, USER & PASSWORD
        dataSource.setURL("jdbc:mysql://localhost:3306/proyectoprg_2425");
        dataSource.setUser("proyecto2425");
        dataSource.setPassword("1111");

        return dataSource;
    }

}
