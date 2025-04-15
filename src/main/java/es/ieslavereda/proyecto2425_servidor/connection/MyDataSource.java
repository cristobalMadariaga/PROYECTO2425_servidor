package es.ieslavereda.proyecto2425_servidor.connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean(name="mysqlDataSource")
    public static DataSource getMyDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        //to do añadir URL, USER & PASSWORD
        return dataSource;
    }

}
