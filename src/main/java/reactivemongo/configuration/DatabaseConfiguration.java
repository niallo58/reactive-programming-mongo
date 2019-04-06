package reactivemongo.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
public class DatabaseConfiguration {
	
	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private Integer port;
	
	@Value("${spring.data.mongodb.username}")
	private String username;
	
	@Value("${spring.data.mongodb.password}")
	private String password;

	@Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient(), database);
    }
	
	private MongoClient mongoClient() {
		if(!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
			return MongoClients.create("mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + database);
		} else {
			return MongoClients.create("mongodb://" + host + ":" + port + "/" + database);
		}
	}

}
