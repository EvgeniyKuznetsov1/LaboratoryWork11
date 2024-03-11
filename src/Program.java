import java.util.*;

class Person {
    private int age;
    public String FIO;
    public String phone;

    public Person(String FIO, String phone, int age) {
        this.FIO = FIO;
        this.phone = phone;
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}

class Student extends Person {
    public int course;
    public String faculty;
    private int admissionYear;

    public Student(String fullName, String phone, int age, int course, String faculty, int admissionYear) {
        super(fullName, phone, age);
        this.course = course;
        this.faculty = faculty;
        this.admissionYear = admissionYear;
    }

    public int getAdmissionYear(){
        return admissionYear;
    }
}

class Program {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Student[] students = {
                new Student("Сосулькин Иван Михайлович", "89524904784", 20, 2, "Программирование", 2022),
                new Student("Зубенко Петр Владимирович", "89543094030", 21, 3, "Клининг помещений", 2021),
                new Student("Степанов Степан Сидорович", "89530294940", 19, 1, "Экономика", 2023)
        };

        printStudents(students);
        printStudentsByFaculty(students);
        printStudentsAfterYear(students);
    }

    public static void printStudents(Student[] students){
        System.out.println("\tСписок всех студентов:");
        System.out.println(" ФИО\t| Возраст");
        for (Student student : students) {
            System.out.printf("%s\t| %d\n", student.FIO, student.getAge());
        }
    }

    public static void printStudentsByFaculty(Student[] students){
        System.out.print("\nВведите факультет: ");
        String givenFaculty = input.nextLine();

        System.out.printf("\t\nСписок студентов по факультету %s:\n", givenFaculty);
        for (Student student : students) {
            if (student.faculty.equals(givenFaculty)) {
                System.out.printf("%s\n", student.FIO);
            }
        }
    }

    public static void printStudentsAfterYear(Student[] students){
        System.out.print("\nВведите год: ");
        int givenYear = input.nextInt();

        System.out.printf("\t\nСписок студентов, поступивших после %d года:\n", givenYear);
        for (Student student : students) {
            if (student.getAdmissionYear() >= givenYear) {
                System.out.printf("%s\t| %d\n", student.FIO, student.getAdmissionYear());
            }
        }
    }
}
