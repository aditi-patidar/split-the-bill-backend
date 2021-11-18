package com.app.sharebucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.app"})
public class SharebucksApplication {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SharebucksApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		String sql = "insert into `Group` (name) values (?)";
//		int result = jdbcTemplate.update(sql, "roommate");
//		if (result > 0) {
//			System.out.println("A new row has been inserted");
//		}
//		
//	}

}
