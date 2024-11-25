package com.test.springwservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.springwservice.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//positional parameter
	//select user_name,user_email from userdata where user_name=;
		@Query("select u from User u where u.email=?1" )
		public User getUserByEmail(String email);
		
			//named parameter
	//	@Query("select s from User u where u.name=:name" )
	//	public List<User> getUsersByName(String name);
		
		//DML
//		@Modifying
//		@Query("delete  from User u where u.name=?1" )
//		public int deleteUserByName(String name);
//		
		@Modifying
		@Query("update User u set u.email=?1 where u.name=?2" )
		public int updateUserByName(String email,String name);
//		
//		
//	 @Query(value="select * from userdata email=?1 ",  nativeQuery=true)
//	 	public List<User> fetchUserByEmail(String  mail);
		
	 
		List<User> findByNameStartingWith(String prefix);
		List<User> findByNameEndingWith(String suffix);
		
		


}
