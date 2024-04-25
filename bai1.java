import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Code: " + code);
        System.out.println("Salary Rate: " + salaryRate);
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeEmployees();
        displayEmployees();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    System.out.println("Ứng dụng đã thoát.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void initializeEmployees() {
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(nextId++, "Employee" + (i + 1), 25 + i, "Department" + (i % 3 + 1), "Code" + (i + 1), 10000 + i * 1000));
        }
    }

    private static void displayEmployees() {
        System.out.println("Danh sách nhân viên:");
        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println("---------------------------");
        }
    }

    private static void addEmployee() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập bộ phận làm việc: ");
        String department = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String code = scanner.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        double salaryRate = scanner.nextDouble();

        employees.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Nhân viên mới đã được thêm vào danh sách.");
    }

    private static void deleteEmployee() {
        System.out.print("Nhập ID của nhân viên cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Nhân viên có ID " + id + " đã được xóa khỏi danh sách.");
                return;
            }
        }

        System.out.println("Không tìm thấy nhân viên có ID " + id + " trong danh sách.");
    }
}
