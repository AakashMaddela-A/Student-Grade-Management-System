package project2;

import java.util.ArrayList;
import java.util.List;

    public class StudentManager {
        private List<Student> students = new ArrayList<>();

        public void addStudent(int id, String name) {
            students.add(new Student(id, name));
        }

        public Student findStudentById(int id) {
            for (Student s : students) {
                if (s.getId() == id) return s;
            }
            return null;
        }

        public boolean removeStudent(int id) {
            return students.removeIf(s -> s.getId() == id);
        }

        public List<Student> getAllStudents() {
            return students;
        }
    }
