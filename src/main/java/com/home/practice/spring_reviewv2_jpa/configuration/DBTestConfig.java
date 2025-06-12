//package com.home.practice.spring_reviewv2_jpa.configuration;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//
//@Configuration
//public class DBTestConfig {
//
//    @Bean
//    public CommandLineRunner testConnection(DataSource dataSource){
//        return args -> {
//            try (Connection conn = dataSource.getConnection()) {
//                System.out.println("MySQL 연결 성공!");
//                System.out.println("URL : " + conn.getMetaData().getURL());
//            } catch (Exception e) {
//                System.out.println("MySQL 연결 실패!");
//                e.printStackTrace();
//            }
//        };
//    }
//}
