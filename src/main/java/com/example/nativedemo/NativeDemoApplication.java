package com.example.nativedemo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class NativeDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(NativeDemoApplication.class, args);
  }

  @Bean
  ApplicationRunner run(MyMapper mapper) {
    return args -> {
      mapper.insert(new Message(null, "Hello World!"));
      Message message = mapper.select(1);
      System.out.println(message);
    };
  }

  @Mapper
  interface MyMapper {

    @Insert("""
          INSERT INTO messages (message)
            VALUES (#{message})
        """)
    void insert(Message message);

    @Select("""
          SELECT
            id
            ,message
          FROM
            messages
          WHERE
            id = #{id}
        """)
    Message select(Integer id);

  }

  record Message(Integer id, String message) {
  }

}
