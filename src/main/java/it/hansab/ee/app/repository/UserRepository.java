package it.hansab.ee.app.repository;

import it.hansab.ee.app.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    Page<User> findByName(String nameFilter, Pageable pageable);

}
