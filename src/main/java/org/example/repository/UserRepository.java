package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
    @Query(value = "select * from user where email = ? or phoneNumber = ?", nativeQuery = true)
    User findByPhoneOrEmail(String email, String phoneNumber);
    @Query(value = "SELECT * FROM user\n" +
            "WHERE sex = 1\n" +
            "AND TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 20 AND 30", nativeQuery = true)
    User isMenBetWeen20And30();
}
