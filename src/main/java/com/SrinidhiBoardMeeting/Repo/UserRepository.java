package com.SrinidhiBoardMeeting.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.dto.LoadOptionIntegerDto;
import com.SrinidhiBoardMeeting.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

	@Query(value = "select * from users u where u.user_name = :username", nativeQuery = true)
	Optional<Users> findByUserName(@Param("username") String username);

	@Query(value = "select count(u.*) from ecomm.user u where u.username = :username or u.email = :email", nativeQuery = true)
	Long findByUsernameOrEmail(String username, String email);

	Optional<Users> findById(Long i);

	@Query("SELECT u.userName FROM Users u WHERE u.id = :userId")
	Optional<String> findUserNameById(@Param("userId") Long userId);

	@Query("SELECT u.id, u.userName FROM Users u WHERE u.id IN :userIds")
	List<Object[]> findUserNamesByIds(@Param("userIds") List<Long> userIds);

	@Query(value = "select * from users u where u.user_id = :userId", nativeQuery = true)
	Optional<List<Users>> findByUserIdIn(@Param("userId") List<Long> userId);

	// Additional methods for Password reset operation.
	@Query(value = "select * from users u where u.email= :email", nativeQuery = true)
	Optional<Users> findByEmail(@Param("email") String email);

	@Query(value = "select * from users u where u.reset_password_token= :token", nativeQuery = true) // resetPasswordToken
	Optional<Users> findByResetPasswordToken(@Param("token") String token);

	// New method to update resetPasswordToken
	@Modifying
	@Query("UPDATE Users u SET u.resetPasswordToken = :token WHERE u.userName= :email")
	void updateResetPasswordToken(@Param("token") String token, @Param("email") String email);

	@Query(value = "SELECT new com.SrinidhiBoardMeeting.dto.LoadOptionIntegerDto(mm.UserId as value, mm.PersonName as label) from Users mm WHERE mm.roleId =:roleId "
			+ "order by mm.PersonName asc")
	// @Query("select cm.customer_id as value, cm.name as label from customer_master
	// cm")
	List<LoadOptionIntegerDto> findUserByRole(@Param("roleId") long i);

	// New method to update resetPasswordToken
	@Modifying
	@Query("UPDATE Users u SET u.Password= :password WHERE u.Email= :email")
	void updateResetPassword(@Param("email") String email, @Param("password") String password);

	@Modifying
	@Query("UPDATE Users u SET u.Password = :password, u.resetPasswordToken = :resetPasswordToken WHERE u.userName = :username")
	void updatePasswordAndResetToken(@Param("username") String username, @Param("password") String password,
			@Param("resetPasswordToken") String resetPasswordToken);

	Users findByRoleId(Long updatedBy);

	@Query(value = "SELECT * FROM users u WHERE u.person_name = :pname", nativeQuery = true)
	Users findUserByPersonName(@Param("pname") String pname);

}