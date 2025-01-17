package migao.life.visa_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("migao.life.visa_manager.mapper")
public class VisaManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisaManagerApplication.class, args);
    }

}
