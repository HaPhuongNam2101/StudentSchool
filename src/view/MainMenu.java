package view;

import manager.UserManager;
import model.User;

import java.util.Scanner;

public class MainMenu {
    private MenuStudent menuStudent = new MenuStudent();
    private MenuSchool menuSchool = new MenuSchool();
    private UserManager userManager = new UserManager();
    private User currentUser = null;
    Scanner inputNumber = new Scanner(System.in);
    public void selectMenu() {
        int choice;
        do {
            System.out.println("===== Trang chủ =====");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí");
            System.out.println("3.Quản lý sinh viên");
            System.out.println("4.Quản lý trường học");
            System.out.println("0. Thoát ");
            System.out.println("Nhập lựa chọn ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    login();
                     break;
                case 2:
                    register();
                    break;
                case 3:
                    if (currentUser != null) {
                        menuStudent.showMainMenu();
                    } else {
                        System.out.println("Vui lòng đăng nhập trước.");
                    }
                    break;
                case 4:
                    if (currentUser != null) {
                        menuSchool.showMainMenu();
                    } else {
                        System.out.println("Vui lòng đăng nhập trước.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn ");
            }
        } while (choice != 0);
    }
    private void login() {
        Scanner inputString = new Scanner(System.in);
        System.out.println("===== Đăng nhập =====");
        System.out.println("Nhập tên tài khoản: ");
        String username = inputString.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = inputString.nextLine();
        User user = userManager.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Đăng Nhập thành công");
        } else {
            System.out.println("Tên tài khoản hoặc mật khẩu không đúng");
        }
    }
    private void register() {
        Scanner inputString = new Scanner(System.in);
        System.out.println("===== Đăng ký =====");
        System.out.println("Nhập tên tài khoản: ");
        String username = inputString.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = inputString.nextLine();
        User existingUser = userManager.findByUsername(username);
        if(existingUser == null) {
            User newUser = new User(username, password);
            userManager.add(newUser);
            System.out.println("Đăng ký thành công");
        } else {
            System.out.println("Tên tài khoản đã tồn tại");
        }
    }
}
