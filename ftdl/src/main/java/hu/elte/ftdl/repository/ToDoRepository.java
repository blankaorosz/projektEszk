/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.repository;

import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.model.Todo;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Blanka Orosz
 */
@Repository
public interface ToDoRepository extends CrudRepository<Todo, Integer>{
    Collection<Todo> findByFamily(Family family);
}
