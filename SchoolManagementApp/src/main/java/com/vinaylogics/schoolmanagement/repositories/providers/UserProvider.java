package com.vinaylogics.schoolmanagement.repositories.providers;

import com.vinaylogics.schoolmanagement.models.Gender;
import com.vinaylogics.schoolmanagement.models.Role;
import com.vinaylogics.schoolmanagement.models.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public final class UserProvider implements Serializable {
    private static final UserProvider instance = new UserProvider();
    private static final List<User> students = new ArrayList<>();
    private static final List<User> teachers = new ArrayList<>();
    /**
     * User(Long id, String name, String userId, Gender gender, Role role , LocalDateTime createdAt, LocalDateTime updatedAt
     */
    static {
       final LocalDateTime localDateTime = LocalDateTime.now();
        LongStream.rangeClosed(1,20).forEach(id -> {
            students.add(new User(id,  "student"+id, String.valueOf(id),  id %2 ==0 ? Gender.MALE: Gender.FEMALE, Role.STUDENT,
                    localDateTime, localDateTime));
        });

        LongStream.rangeClosed(1, 5).forEach(id -> {
            teachers.add(new User(id,  "teacher"+id, String.valueOf(id),  id %2 ==0 ? Gender.MALE: Gender.FEMALE, Role.TEACHER,
                    localDateTime, localDateTime));
        });

    }

    private UserProvider(){ }

    public static UserProvider getInstance() {
        return instance;
    }

    public List<User> getStudents(){
        return students;
    }

    public  List<User> getTeachers() {
        return teachers;
    }

    public Optional<User> findStudentId(Long id){
        return students.parallelStream().filter(student -> student.getId().equals(id)).findAny();
    }


}
