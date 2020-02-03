package edu.swfu.routeplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class testController {
	   @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @RequestMapping("/test")
	    @ResponseBody
	    public String index(){

	        String sql = "select sysdate from dual";
	        jdbcTemplate.execute(sql);
	        System.out.println("执行完成");

	        return "hello spring boot";
	    }
}
