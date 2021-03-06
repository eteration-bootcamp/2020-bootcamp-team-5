package com.team5.Noteapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team5.Noteapp.Entity.HashCode;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HashCodeRepository extends CrudRepository<HashCode, Integer> {

    @Query("SELECT HashCode FROM HashCode AS HashCode WHERE code = ?1")
    Optional<HashCode> findByHashCode(String code);

    @Transactional
    @Modifying
    @Query("DELETE FROM HashCode AS HasHCode WHERE userId = ?1")
    void deleteHashCode(int userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM HashCode AS HasHCode WHERE code = ?1")
    void deleteLoginHash(String hashCode);
}
