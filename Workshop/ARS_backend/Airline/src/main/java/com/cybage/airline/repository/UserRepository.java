
package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cybage.airline.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);
	 @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
	 public User findByVerificationCode(String code);

}
