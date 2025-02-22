package app.repository;

import app.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository  extends JpaRepository<UserAccount,Long> {

    @Query("Select u from UserAccount u where u.username=:username")
    public Optional<UserAccount> findByUsername(@Param("username") String username);
}