package com.org.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController {
	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/feedData")
	public String idx() {
		jdbc.execute("insert into batch7 value(101,'Nikita')");
		jdbc.execute("insert into batch7 value(102,'Niharika')");
		jdbc.execute("insert into batch7 value(103,'Nilesh')");
		jdbc.execute("insert into batch7 value(104,'Nishant')");
		return "Data stored";
	}
	
		@RequestMapping("/getData")
		public String getData() {
			jdbc.execute("select * from batch7");
			return "data is here";
		}
	
}
