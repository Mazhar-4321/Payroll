package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Employment Payroll Programme");
        Main main = new Main();
        main.readPayrollData();
        main.checkIfFileExists(fileName);
        main.deleteFile(fileName);
        main.readPayrollDataUsingFile();
    }

    private void readPayrollDataUsingFile() throws FileNotFoundException {
        File myObj = new File("D:\\FileOperations\\src\\resources\\payroll.txt");
        Scanner myReader = new Scanner(myObj);
        int count = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] userArray = data.split(",");
            String id = userArray[0];
            String name = userArray[1];
            String salary = userArray[2];
            System.out.println(id + "," + name + "," + salary);
            count++;
        }
        System.out.println(count==2);
        myReader.close();
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
        addDataToFile();
    }

    private void addDataToFile() {
        File file = new File("D:\\FileOperations\\src\\resources\\payroll.txt");
        FileWriter fr = null;
        for (int i = 0; i < payrollList.size(); i++) {
            String text = payrollList.get(i).getId() + "," + payrollList.get(i).getName() + "," + payrollList.get(i).getSalary();
            try {
                fr = new FileWriter(file, true);
                fr.write(text);
                fr.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
