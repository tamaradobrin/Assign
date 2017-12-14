package edu.iss.repository;

import edu.iss.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentJpaRepository extends AbstractJpaRepository<Student> {

    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }
}
