package kz.iitu.DBUsers.repo;

import kz.iitu.DBUsers.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findById(int filter);
}
