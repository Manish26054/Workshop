
package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cybage.airline.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
