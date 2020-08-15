package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Entity.*;
import com.team5.Noteapp.Repository.*;
import com.team5.Noteapp.Service.HashCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private HashCodeRepository hashCodeRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @PutMapping("/create")
    public void createDB() {
        UserInfo userInfo = new UserInfo();
        User user3 = new User();
        User user = new User();
        User user2 = new User();
        Note note = new Note();
        Note note2 = new Note();
        Permission permission = new Permission();
        Permission permission2 = new Permission();
        Permission permission3 = new Permission();
        Permission permission4 = new Permission();

        HashCode hashCode = new HashCode();
        HashCode hashCode2 = new HashCode();
        HashCode hashCode3 = new HashCode();

        user3.setName("Secoo");
        user3.setSurname("Ak");
        userRepository.save(user3);
        userInfo.setUsername("sercan");
        userInfo.setPassword(hashCodeService.createPasswordHash("123"));
        userInfo.setActive(true);
        userInfo.setUser(user3);
        userInfoRepository.save(userInfo);

        System.out.println(user3.toString());
        System.out.println(userRepository.findById(user3.getId()).toString());
        System.out.println(userInfo.toString());
        System.out.println(userInfoRepository.findById(userInfo.getId()).toString());

        user.setMail("noteration@gmail.com");
        user.setPhoneNumber("00000000000");
        user.setName("Team5");
        user.setSurname("team5");

        user2.setMail("noteration2@gmail.com");
        user2.setPhoneNumber("00000000002");
        user2.setName("Team2");
        user2.setSurname("team2");

        note.setTitle("1");
        note.setContent("1");

        note2.setTitle("2");
        note2.setContent("2");

        permission.setNoteId(2);
        permission.setUserId(1);
        permission.setRole("read");

        permission2.setNoteId(1);
        permission2.setUserId(1);
        permission2.setRole("read");

        permission3.setNoteId(1);
        permission3.setUserId(1);
        permission3.setRole("write");

        permission4.setNoteId(1);
        permission4.setUserId(1);
        permission4.setRole("owner");

        hashCode.setCode("123");
        hashCode.setExDate(new Date(System.currentTimeMillis() + 999999999));
        hashCode.setType("Login");
        hashCode.setUserId(1);

        hashCode2.setCode("1234");
        hashCode2.setExDate(new Date(System.currentTimeMillis() + 999999999));
        hashCode2.setType("Login");
        hashCode2.setUserId(2);


        userRepository.save(user);
        userRepository.save(user2);
        noteRepository.save(note);
        noteRepository.save(note2);
        permissionRepository.save(permission);
        permissionRepository.save(permission2);
        permissionRepository.save(permission3);
        permissionRepository.save(permission4);
        hashCodeRepository.save(hashCode);
        hashCodeRepository.save(hashCode2);
        hashCodeRepository.save(hashCode3);
    }
}
