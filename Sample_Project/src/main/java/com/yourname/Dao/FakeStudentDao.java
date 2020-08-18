package com.yourname.Dao;

import com.yourname.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@Repository
@Qualifier("fakeData")
public class FakeStudentDao implements StudentDao {
    private static Map<Integer, Student> students;

   static  {
        students = new HashMap<Integer, Student>() {
            {
               put(1, new Student(1, "Jyothi", "ComputerScience"));
               put(2, new Student(2, "Poojitha", "Electronics"));
              put(3, new Student(3, "Chandana", "Finance"));
            }
        };
    }


    @Override
    public Collection<Student> getAllStudents() {

        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student);
    }

}
