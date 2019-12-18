package comitcast.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("comitcast.service.mapper")
//启用eureka的客户端,使用@EnableDiscoveryClient和@EnableEurekaClient
@EnableDiscoveryClient
public class ItcastServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItcastServiceProviderApplication.class, args);
    }

}
