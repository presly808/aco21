package ua.artcode.week1.task1.model;

/**
 * Created by serhii on 03.09.17.
 */
public class Group {

    private Student[] studentsList = new Student[10];
    private int counter = 0;


    public void addStudent(Student student){
        if(student == null){
            System.out.println("Illegal argument exception");
            return;
        }

        if(counter == studentsList.length){
            System.out.println("No free space in the group");
            return;
        }

        studentsList[counter++] = student;
    }

    public Student[] getStudentsList() {
        return studentsList;
    }

    public int getSize(){
        return counter;
    }

    public Student findStudent(String name) {
        if(name == null){
            return null;
        }


        for (int i = 0; i < studentsList.length && studentsList[i] != null; i++) {
            Student currStudent = studentsList[i];
            if(name.equals(currStudent.name)){
                return currStudent;
            }
        }

        System.out.println("Student has not been found found");

        return null;

    }

    public void showAll() {
        System.out.println("№\t\tName\t\tAge\n");
        for (int i = 0; i < studentsList.length && studentsList[i] != null; i++) {
            Student student = studentsList[i];
            System.out.printf("%d\t\t%s\t\t%d\n",i + 1, student.name, student.age);
        }
    }
}
