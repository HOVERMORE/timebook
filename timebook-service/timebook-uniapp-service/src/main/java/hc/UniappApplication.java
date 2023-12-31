package hc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("hc.mapper")
@EnableFeignClients(value = {"hc.apis.sensitive","hc.apis.elasticsearch"})
@EnableAsync //开启异步调用
public class UniappApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniappApplication.class,args);
    }
}
