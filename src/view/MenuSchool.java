package view;

import manager.SchoolManager;
import model.School;
import model.Student;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuSchool {
    SchoolManager schoolManager = new SchoolManager();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Danh sách trường ");
            System.out.println("1. Thêm mới trường học ");
            System.out.println("2. Sửa thông tin trường học ");
            System.out.println("3. Xóa thông tin trường học ");
            System.out.println("4. Hiển thị tất cả trường học ");
            System.out.println("5. Tìm kiếm theo tên trường học gần đúng ");
            System.out.println("O. Thoát chương trình");
            System.out.println("Nhập lựa chọn ");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
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
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn ");
            }
        } while (choice != 0);
    }
    public void showMenuAdd() {
        System.out.println("===== Danh sách thêm mới =====");
        System.out.println("Nhập tên trường: ");
        String name = inputString.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = inputString.nextLine();
        School school = new School(name,address);
        schoolManager.add(school);
        System.out.println("Thêm thành công ");
    }
    public void showAll() {
        System.out.println("Danh sách trường học là: ");
        ArrayList<School> listSchool = schoolManager.findAll();
        for (School school : listSchool) {
            System.out.println(school);
        }
    }
    public void showMenuRemote(){
        System.out.println("===== Xóa trường học =====");
        System.out.println("Nhập id muốn xóa: ");
        int idDelete = inputInt.nextInt();
        schoolManager.remove(idDelete);
        System.out.println("===== Xóa thành công =====");
    }
    public void showMenuEdit(){
        System.out.println("===== Sửa thông tin trường học =====");
        System.out.println("Nhập id muốn sửa: ");
        int idEdit = inputInt.nextInt();
        System.out.println("Nhập tên trường: ");
        String name = inputString.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = inputString.nextLine();
        School school = new School(idEdit,name,address);
        schoolManager.update(idEdit,school);
        System.out.println("===== Sửa thành công =====");
    }
    public void showForSeachByname(){
        System.out.println("===== Tìm kiếm theo tên =====");
        System.out.println("Nhập tên cần tìm: ");
        String name = inputString.nextLine();
        ArrayList<School> schoolArrayList = schoolManager.findByNameContain(name);
        if (!schoolArrayList.isEmpty()) {
            for (School school : schoolArrayList) {
                System.out.println(school);
            }
        } else {
            System.out.println("Không tìm thấy tên trường học này");
        }
    }
}

