package project2;

import java.util.HashMap;
import java.util.Map;

    public class Student {
        private int id;
        private String name;
        private Map<String, Double> grades;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
            this.grades = new HashMap<>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void addGrade(String subject, double grade) {
            grades.put(subject, grade);
        }

        public Map<String, Double> getGrades() {
            return grades;
        }

        public double getAverageGrade() {
            if (grades.isEmpty()) return 0;
            double sum = 0;
            for (double grade : grades.values()) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }

