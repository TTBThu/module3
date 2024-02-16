package com.ra;

import com.ra.entity.Category;
import com.ra.repository.IRepository;
import com.ra.repository.impl.CategoryRepository;
import com.ra.service.CategoryService;
import com.ra.service.impl.CategoryServiceImpl;
import com.ra.util.MySQLConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CategoryService categoryService = new CategoryServiceImpl();

    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryServiceImpl();
        IRepository<Category, Integer> repository = new CategoryRepository();
//        Connection conn = MySQLConnect.open();
//        if (conn != null)
//            System.out.println("SUCCESS");
//        else
//            System.out.println("FAILED");
        //for (Category c : categoryService.findByName("h")) {
        Category category = new Category();
        category.setName("Test Repository 4");
        category.setKeyword("test,new,jdbc");
        category.setDescription("None");
        category.setStatus(false);
        repository.add(category);
        System.out.println("New id: " + category.getId());
        for (Category c : repository.findAll()) {
            System.out.println(c.getId() + ": " + c.getName() + " " + c.isStatus());
        }
        System.out.println("Tìm kiếm theo id");
        Category cat = categoryService.findId(4);
        if (category != null)
            System.out.println("Tên danh mục: " + cat.getName());


        boolean exit = false;
        while (!exit) {
            System.out.println("1. Hiển thị danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Sửa thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayCategories();
                    break;
                case 2:
                    addCategory();
                    break;
                case 3:
                    editCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void displayCategories() {
        List<Category> categories = categoryService.findAll();
        for (Category category : categories) {
            System.out.println(category.getId() + ": " + category.getName());
        }
    }

    private static void addCategory() {
        Category category = new Category();
        System.out.print("Tên danh mục: ");
        category.setName(scanner.nextLine());
        System.out.print("Từ khóa: ");
        category.setKeyword(scanner.nextLine());
        System.out.print("Mô tả: ");
        category.setDescription(scanner.nextLine());
        System.out.print("Trạng thái (true/false): ");
        category.setStatus(scanner.nextBoolean());
        categoryService.insert(category);
    }

    private static void editCategory() {
        System.out.print("Nhập ID danh mục cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Category category = categoryService.findId(id);
        if (category != null) {
            System.out.print("Tên danh mục mới: ");
            category.setName(scanner.nextLine());
            System.out.print("Từ khóa mới: ");
            category.setKeyword(scanner.nextLine());
            System.out.print("Mô tả mới: ");
            category.setDescription(scanner.nextLine());
            System.out.print("Trạng thái mới (true/false): ");
            category.setStatus(scanner.nextBoolean());
            categoryService.update(category);
        } else {
            System.out.println("Không tìm thấy danh mục có ID " + id);
        }
    }

    private static void deleteCategory() {
        System.out.print("Nhập ID danh mục cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (categoryService.delete(id)) {
            System.out.println("Đã xóa danh mục có ID " + id);
        } else {
            System.out.println("Không thể xóa danh mục có ID " + id);
        }
    }
}

