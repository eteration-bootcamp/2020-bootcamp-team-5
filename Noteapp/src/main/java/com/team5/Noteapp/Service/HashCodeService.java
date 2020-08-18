package com.team5.Noteapp.Service;

import com.google.common.hash.Hashing;
import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Repository.HashCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Service
public class HashCodeService {

    @Autowired
    private HashCodeRepository hashCodeRepository;

    public HashCode createLoginHash(User user) {
        hashCodeRepository.deleteHashCode(user.getId());
        HashCode hashCode = new HashCode();
        long dateMillis = System.currentTimeMillis();
        hashCode.setCode(Hashing.sha256().hashString(dateMillis + user.getMail(), StandardCharsets.UTF_8).toString());
        hashCode.setUserId(user.getId());
        hashCode.setExDate(new Date(dateMillis + 7200000));
        return hashCodeRepository.save(hashCode);
    }

    public void deleteLoginHash(String hashCode) {
        hashCodeRepository.deleteLoginHash(hashCode);
    }

    public String createPasswordHash(String pass) {
        return Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString();
    }

    public String createActivationHash(User user) {
        HashCode hashCode = new HashCode();
        hashCode.setType("Activation");
        long dateMillis = System.currentTimeMillis();
        hashCode.setCode(Hashing.sha256().hashString(dateMillis + user.getMail(), StandardCharsets.UTF_8).toString());
        hashCode.setUserId(user.getId());
        hashCode.setExDate(new Date(dateMillis + 72000000));
        return hashCodeRepository.save(hashCode).getCode();
    }

    public String createResetPasswordHash(User user) {
        HashCode hashCode = new HashCode();
        hashCode.setType("Reset");
        long dateMillis = System.currentTimeMillis();
        hashCode.setCode(Hashing.sha256().hashString(dateMillis + user.getMail(), StandardCharsets.UTF_8).toString());
        hashCode.setUserId(user.getId());
        hashCode.setExDate(new Date(dateMillis + 72000000));
        return hashCodeRepository.save(hashCode).getCode();
    }

    public HashCode findHashCode(String hashCode){
        Optional<HashCode> optionalHashCode = hashCodeRepository.findByHashCode(hashCode);
        if (optionalHashCode.isPresent())
            return optionalHashCode.get();
        else throw new IllegalArgumentException("Hashcode not found");
    }

    public Optional<HashCode> getLoginHash(String code) {
        return hashCodeRepository.findByHashCode(code);
    }

    public void deleteHashCode(int userId) {
        hashCodeRepository.deleteHashCode(userId);
    }
}
