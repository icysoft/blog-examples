package org.icysoft.blog.example.springdatamongodb;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.icysoft.blog.example.springdatamongodb.domains.User;
import org.icysoft.blog.example.springdatamongodb.repositories.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    @Bean
    MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "spring-data-mongo-example");
    }

    private static void displayUsers(List<User> userList, String prompt) {
        for (User usr : userList) {
            Logger.getLogger(App.class.getName()).log(Level.INFO, "Fetch users - {0} : {1}, {2}", new Object[]{prompt, usr.getLastName(), usr.getSurName()});
        }
    }

    public static void main(String[] args) {
        // Get Spring context
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        // Get UserRepository from spring context
        UserRepository repository = context.getBean(UserRepository.class);

        // Delete all User documents
        repository.deleteAll();

        // Make new users
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            User userA = new User("User", "A", sdf.parse("13/02/1988"));
            User userB = new User("User", "B", sdf.parse("16/02/1988"));
            User userC = new User("User", "C", sdf.parse("12/05/1988"));

            // Store users in MongoDb
            repository.save(userA);
            repository.save(userB);
            repository.save(userC);

            // Fetch all users
            App.displayUsers(repository.findAll(), "After insert");

            // Update user
            userA.setLastName("UpdatedUser");
            userA.setSurName("UpdatedA");
            repository.save(userA);

            // Fetch all users
            App.displayUsers(repository.findAll(), "After update");

            // Delete a user
            repository.delete(userC);

            // Fetch all users
            App.displayUsers(repository.findAll(), "After delete");
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Cannot parse date", ex);
        }
    }
}
