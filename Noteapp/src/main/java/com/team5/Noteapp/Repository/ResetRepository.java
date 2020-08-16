package com.team5.Noteapp.Repository;

import com.team5.Noteapp.Entity.Reset;
import com.team5.Noteapp.Entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetRepository extends CrudRepository<Reset, Integer> {

    @Query(value = "SELECT user_info_id FROM Reset AS UserInfo WHERE reset_code = ?1", nativeQuery = true)
    Optional<Integer> findUserInfoIdByResetCode(int resetCode);
}

