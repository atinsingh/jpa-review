package io.pragra.jpareview.repo;

import io.pragra.jpareview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u from User u WHERE upper(u.lastName) like %:lastName% ")
    List<User> findAllCustom(@Param("lastName") String lastName);

    @Query(value = "SELECT count(*) from TABLE_USER", nativeQuery = true)
    int getAllUserCount();

    @Query("SELECT u from User u WHERE upper(u.lastName) like %:lastName% ")
    User getCustomUser(@Param("lastName") String user);
}
