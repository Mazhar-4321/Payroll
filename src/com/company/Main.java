package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String fileName = "C:\\Users\\user\\Documents\\Zoom\\2022-12-20 19.08.29 Mazhar Ali's Personal Meeting Room\\abc.pdf";
    private List<EmployeePayroll> payrollList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Employment Payroll Programme");
        Main main = new Main();
        main.readPayrollData();
        main.checkIfFileExists(fileName);
        main.deleteFile(fileName);
    }

    private void deleteFile(String fileName) {
        if (checkIfFileExists(fileName)) {
            File file = new File(fileName);
            file.delete();
        }
    }

    private void readPayrollData() {
        System.out.println("Enter the id :");
        String id = scanner.next();
        System.out.println("Enter the name :");
        String name = scanner.next();
        System.out.println("Enter the salary :");
        Double salary = scanner.nextDouble();
        EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary);
        payrollList.add(employeePayroll);
        writePayrollData();
    }

    private void writePayrollData() {
        System.out.println(payrollList);
    }

    private boolean checkIfFileExists(String path) {
        Path filePath = Paths.get(path);
        if (Files.exists(filePath)) {
            System.out.println("File Exists");
            return true;
        }
        System.out.println("file doesnt exists");
        return false;

    }

}
