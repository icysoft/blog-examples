/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.icysoft.blog.example.springdatamongodb.repositories;

import org.icysoft.blog.example.springdatamongodb.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cmillauriaux
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
