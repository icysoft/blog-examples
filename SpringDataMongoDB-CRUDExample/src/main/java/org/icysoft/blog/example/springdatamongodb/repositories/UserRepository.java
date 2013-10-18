package org.icysoft.blog.example.springdatamongodb.repositories;

import org.icysoft.blog.example.springdatamongodb.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository used to manage User documents
 * @author cmillauriaux
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
