
package hu.elte.ftdl.repository;

import hu.elte.ftdl.model.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Family, Integer> {

    Optional<Family> findByUsername(String username);

    Optional<Family> findByUsernameAndPassword(String username, String password);
}