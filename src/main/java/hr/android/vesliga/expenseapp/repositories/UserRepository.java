package hr.android.vesliga.expenseapp.repositories;

import hr.android.vesliga.expenseapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    Optional<User> findById(Long id);
    Iterable<User>findAll();
    User save(User user);
}
