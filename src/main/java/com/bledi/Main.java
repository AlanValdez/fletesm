/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bledi;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@SpringBootApplication
public class Main {

  @Value("${spring.datasource.url}")
  private String dbUrl;
  
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public DataSource dataSource() throws SQLException {
	  String username = System.getenv("username");
	  String pwf = System.getenv().get("password");
	  String db = System.getenv().get("JAWSDB_URL");
	  String env = System.getenv().get("enviroment");
    if (dbUrl == null || dbUrl.isEmpty() && db != "" && env != "prod") {
    	HikariConfig config = new HikariConfig();
        config.setJdbcUrl(db);
        config.setUsername( username );
        config.setPassword( pwf );
        return new HikariDataSource(config);
    } else {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      config.setUsername( "c8s6cfa6po7ubcj1" );
      config.setPassword( "misic9rpj33tynh3" );
      return new HikariDataSource(config);
    }
  }

}
