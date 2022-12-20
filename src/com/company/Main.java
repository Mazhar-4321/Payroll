package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<EmployeePayroll> payrollList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Employment Payroll Programme");
        Main main = new Main();
        main.readPayrollData();
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


}
