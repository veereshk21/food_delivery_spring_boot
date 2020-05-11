package com.foodproject.users;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

	
	//=========================================================
	
	@Query(value="select count(*) from users where email= ?1 and user_password= ?2", nativeQuery=true)
	int getUserByCred(String email, String userPassword);

	@Query(value="select user_id from users where email= ?1 and user_password= ?2", nativeQuery=true)
	String getUserByEmailId(String email, String userPassword);
	
	@Query(value="select count(*) from users where email = ?1 ", nativeQuery=true)
	int getUserByEmail(String email);
	
}
