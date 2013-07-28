/**
 * 
 */
package be.scorgar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.scorgar.demo.domain.User;

/**
 * @author Dirk
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByAccount(String account);
}
