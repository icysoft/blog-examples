package org.icysoft.blog.example.springdatamongodb;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Hello world!
 *
 */
@Configuration
@EnableMongoRepositories
public class App {

    @Bean
    protected static Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    public static void main(String[] args) {
        try {
            Logger.getLogger(App.class.getName()).log(Level.INFO, "Trying to connect to MongoDB");
            Mongo mongoDb = App.mongo();
            Logger.getLogger(App.class.getName()).log(Level.INFO, "Connected to {0} version {1}", new Object[]{mongoDb.getConnectPoint(), mongoDb.getVersion()});
        } catch (UnknownHostException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Impossible to reach MongoDB", ex);
        }
    }
}
