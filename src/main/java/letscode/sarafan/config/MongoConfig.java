package letscode.sarafan.config;


import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
@EnableMongoRepositories(basePackages = "letscode.sarafan.repository")
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {

    private MongoProperties properties;

    public MongoConfig(MongoProperties properties) {
        this.properties = properties;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(properties.getHost());
    }

    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }
}
