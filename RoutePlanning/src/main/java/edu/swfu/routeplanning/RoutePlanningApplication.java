package edu.swfu.routeplanning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication // Spring Boot��Ŀ�ĺ���ע�⣬��ҪĿ���ǿ����Զ�����
//@ComponentScan(basePackages={"edu.swfu.routeplanning","edu.swfu.routeplanning.service"})
//@MapperScan(basePackages = {"edu.swfu.routeplanning.dao","edu.swfu.routeplanning.dao"})
@Controller // ��������һ��SpringMVC��Controller������
public class RoutePlanningApplication {
	@RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    // ��main����������һ��Ӧ�ã��������Ӧ�õ����
    public static void main(String[] args) {
        SpringApplication.run(RoutePlanningApplication.class, args);
    }

}
