package services;
import java.util.*;
import java.io.*;
public class doctor_service {
    // Admin can view doctor records
    // Admin can add doctor records
    // Admin can edit doctor records
    // Admin can delete doctor records
    public static void create_doctor() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("doctors.txt"))) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Doctor ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Doctor Schedule: ");
            String specialization = sc.nextLine();

            System.out.print("Enter Doctor Phone Number: ");
            String phone = sc.nextLine();

            bw.write(id + ",\n" + name + ",\n" + specialization + ",\n" + phone + "\n");

            System.out.println("Doctor created successfully!");
            sc.close();
        } catch (IOException e) {
            System.out.println();
        }

        
    }
}
