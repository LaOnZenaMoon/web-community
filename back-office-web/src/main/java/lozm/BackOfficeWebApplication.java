package lozm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BackOfficeWebApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(BackOfficeWebApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
