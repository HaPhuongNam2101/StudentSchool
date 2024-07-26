package view;

import manager.StudentManager;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStudent {
    StudentManager studentManager = new StudentManager();
    Scanner intputInt = new Scanner(System.in);
    Scanner intputSring = new Scanner(System.in);
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Danh sách sinh viên ===== ");
            System.out.println("1. Thêm mới sinh viên ");
            System.out.println("2. Sửa thông tin sinh viên ");
            System.out.println("3. Xóa sinh viên ");
            System.out.println("4. Hiển thị tất cả sinh viên ");
            System.out.println("5. Tìm kiếm theo tên ");
            System.out.println("6. Tìm kiếm sinh viên theo khoảng điểm ");
            System.out.println("7. Tìm kiếm sinh viên theo khoảng tuổi ");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");

            choice = intputInt.nextInt();
            switch (choice) {
                case 1:
                    showStudentMenu();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                    case 3:
                    showMenuRemote();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showForSeachByname();
                    break;
                case 6:
                    showForSearchByScore();
                    break;
                case 7:
                    showForSearchByAgeRange();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn ");
            }
        } while (choice != 0);
    }
    public void showStudentMenu() {
        System.out.println("===== Danh sách thêm mới =====");
        System.out.println("Nhập tên: ");
        String name = intputSring.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = intputInt.nextInt();
        System.out.println("Nhập điểm: ");
        double score = intputInt.nextDouble();
        Student student = new Student(name, age, score);
        studentManager.add(student);
        System.out.println("===== Thêm thành công =====");
    }
    public void showAll(){
        System.out.println("===== Danh sách sinh viên là =====");
        ArrayList<Student> listStudent = studentManager.findAll();
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }
    public void showMenuRemote(){
        System.out.println("===== Xóa học sinh =====");
        System.out.println("Nhập id muốn xóa: ");
        int idDelete = intputInt.nextInt();
        studentManager.remove(idDelete);
        System.out.println("===== Xóa thành công =====");
    }
    public void showMenuEdit(){
        System.out.println("===== Sửa thông tin sinh viên =====");
        System.out.println("Nhập id muốn sửa: ");
        int idEdit = intputInt.nextInt();
        System.out.println("Nhập tên: ");
        String name = intputSring.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = intputInt.nextInt();
        System.out.println("Nhập điểm: ");
        double score = intputInt.nextDouble();
        Student student = new Student(idEdit,name, age, score);
        studentManager.update(idEdit,student);
        System.out.println("===== Sửa thành công =====");
    }
    public void showForSeachByname(){
        System.out.println("===== Tìm kiếm theo tên =====");
        System.out.println("Nhập tên cần tìm: ");
        String name = intputSring.nextLine();
        ArrayList<Student> studentArrayList = studentManager.findBynameContain(name);
        if (!studentArrayList.isEmpty()) {
            for (Student student : studentArrayList) {
                System.out.println(student);
            }
        }else{
            System.out.println("Không tìm thấy tên sinh viên này: " + name);
        }
    }
    public void showForSearchByScore() {
        System.out.println("===== Tìm kiếm theo khoảng điểm =====");
        System.out.println("Nhập điểm từ: ");
        double from = intputInt.nextDouble();
        System.out.println("Nhập điểm đến: ");
        double to = intputInt.nextDouble();
        ArrayList<Student> studentArrayList = studentManager.findByScore(from, to);
        if (!studentArrayList.isEmpty()) {
            for (Student student : studentArrayList) {
                System.out.println(student);
            }
        } else {
            System.out.println("Không tìm thấy sinh viên trong khoảng điểm này.");
        }
    }
    public void showForSearchByAgeRange() {
        System.out.println("===== Tìm kiếm theo khoảng tuổi =====");
        System.out.println("Nhập tuổi từ: ");
        int from = intputInt.nextInt();
        System.out.println("Nhập tuổi đến: ");
        int to = intputInt.nextInt();
        ArrayList<Student> studentArrayList = studentManager.findByAgeRange(from, to);
        if (!studentArrayList.isEmpty()) {
            for (Student student : studentArrayList) {
                System.out.println(student);
            }
        } else {
            System.out.println("Không tìm thấy sinh viên trong khoảng tuổi này.");
        }
    }
}

