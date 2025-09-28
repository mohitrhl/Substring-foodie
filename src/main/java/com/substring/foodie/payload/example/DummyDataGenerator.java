package com.substring.foodie.payload.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DummyDataGenerator {

    public static List<Student> generateDummyStudents() {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        // ✅ Pool of real Indian names
        List<String> indianNames = Arrays.asList(
                "Aarav Sharma", "Ishita Verma", "Rohan Singh", "Priya Nair",
                "Ananya Gupta", "Arjun Mehta", "Neha Patel", "Rahul Kumar",
                "Kavya Reddy", "Vikram Joshi", "Sneha Das", "Aditya Choudhary",
                "Meera Iyer", "Karan Malhotra", "Pooja Mishra", "Siddharth Jain",
                "Divya Menon", "Manish Yadav", "Shreya Roy", "Varun Bhat"
        );

        // ✅ Engineering Departments
        List<Department> departments = Arrays.asList(
                createDepartment("Computer Science", "CSE"),
                createDepartment("Information Technology", "IT"),
                createDepartment("Electronics & Communication", "ECE"),
                createDepartment("Mechanical Engineering", "ME"),
                createDepartment("Civil Engineering", "CE")
        );

        // ✅ Engineering Subjects
        List<Subject> subjects = Arrays.asList(
                createSubject("Data Structures", "CSE201"),
                createSubject("Database Management System", "CSE301"),
                createSubject("Operating Systems", "CSE302"),
                createSubject("Computer Networks", "CSE303"),
                createSubject("Software Engineering", "CSE304"),
                createSubject("Artificial Intelligence", "CSE305"),
                createSubject("Digital Electronics", "ECE202"),
                createSubject("Communication Systems", "ECE301"),
                createSubject("Thermodynamics", "ME203"),
                createSubject("Machine Design", "ME304"),
                createSubject("Structural Analysis", "CE204"),
                createSubject("Surveying", "CE305")
        );

        // ✅ Generate 10 Students
        for (int i = 1; i <= 10; i++) {
            Student student = new Student();

            // Pick a random Indian name
            String name = indianNames.get(random.nextInt(indianNames.size()));
            student.setName(name);

            // Random age 18-22
            student.setAge(18 + random.nextInt(5));

            // Random Department
            Department dept = departments.get(random.nextInt(departments.size()));
            student.setDepartment(dept);

            // Random 3 subjects (avoid duplicates)
            List<Subject> randomSubjects = new ArrayList<>();
            while (randomSubjects.size() < 3) {
                Subject sub = subjects.get(random.nextInt(subjects.size()));
                if (!randomSubjects.contains(sub)) {
                    randomSubjects.add(sub);
                }
            }
            student.setSubjects(randomSubjects);

            students.add(student);
        }

        return students;
    }

    private static Department createDepartment(String name, String code) {
        Department d = new Department();
        d.setDepartmentName(name);
        d.setDepartmentCode(code);
        return d;
    }

    private static Subject createSubject(String title, String code) {
        Subject s = new Subject();
        s.setTitle(title);
        s.setSubjectCode(code);
        return s;
    }
}
