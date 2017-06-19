/**
 * 
 */
package br.com.ravelino.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author ravelino
 *
 */

@Configuration
@EnableMongoRepositories(basePackages = "br.com.ravelino")
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Value("${mongodb.host}")
	private String host;
	
	@Value("${mongodb.base.package}")
	private String basePackage;
	
	@Value("${mongodb.porta}")
	private Integer porta;
	
	@Value("${mongodb.name}")
	private String dbName;
  
    @Override
    protected String getDatabaseName() {
        return dbName;
    }
  
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host, porta);
    }
  
    @Override
    protected String getMappingBasePackage() {
        return basePackage;
    }
}
