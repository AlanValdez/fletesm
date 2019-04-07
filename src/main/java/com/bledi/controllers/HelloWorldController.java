package com.bledi.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bledi.hello.Greetings;

@Controller
public class HelloWorldController {
	
	
	@Value("${spring.datasource.url}")
	  private String dbUrl;
	@Autowired
	  private DataSource dataSource;
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public List<Greetings> sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    	try (Connection connection = dataSource.getConnection()) {
    	      Statement stmt = connection.createStatement();

    	      ResultSet rs = stmt.executeQuery("select * from notes");
    	      List<Greetings> myGrets = new ArrayList<>();
    	      ArrayList<String> output = new ArrayList<String>();
    	      int i = 0;
    	      while (rs.next()) {
    	        output.add("Read from DB: " + rs.getLong("id"));
    	        myGrets.add(new Greetings(counter.incrementAndGet(), String.format(template, output.get(i++))));
    	      }
    	      
    	      
    	      return myGrets;
    	    } catch (Exception e) {
    	    	System.out.println(e);
    	      return null;
    	    }
    }

    
}