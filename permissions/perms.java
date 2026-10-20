package permissions;
import services.*;
import java.util.*;
// All the permmissions will go here
// Will distribute the permissions to the different users
// admin perms - will have all the perms
// doctor perms - view own profile, view assigned patients, view appointments 
// member perms - View own doctor profile, view own records, book, view, cancel own appointments, view own medical records, view billing and payments

public class perms {

    static Scanner sc = new Scanner(System.in);

    public static void patient_records() {
        // Admin can view patient records
        // Admin can add patient records
        // Admin can edit patient records
        // Admin can delete patient records
        // Admin can search patient records
        
    }
    public static void doctor_management() {

        System.out.printf("""
            ==================================================%n
                [1] Create Doctor Record
                [2] View Doctor Record
                [3] Edit Doctor Record
                [4] Delete Doctor Record
                [0] Exit%n
            ==================================================
        %n: """);

        int choice = sc.nextInt();
        switch (choice){
            case 1:
                doctor_service.create_doctor();
                break;
            case 2:
                doctor_service.view_doctor();
                break;
            case 3:
                doctor_service.edit_doctor();
                break;
            case 4:
                doctor_service.delete_doctor();
                break;
            case 0:
                System.out.println("Thank you for using the system!");
                break;
            default:
                System.out.println("Invalid Choice, try again");
        }
        sc.close();
    }
    public static void appointments() {
        // Admin can view appointments
        // Admin can add appointments and select doctor availability
        // If admin chooses the doctor, admin can view the doctor's schedule
        // If admin picked the doctor that is not available, admin can choose another doctor
        // Admin can cancel appointments
        // Admin can delete appointments
        // Admin can search appointments
    }
    public static void medical_records() {
        // admin can view medical records
        // admin can add medical records
        // admin can search medical records
        // admin can delete medical records
    }
    public static void billing_payments (){
        // admin can view billing and payments
        // admin can add billing and payments
        // admin can search billing and payments
        // admin can delete billing and payments
    }

    public static void choices() {
        System.out.printf("""
            ==================================================
                    VitalClinic System%n
                [1] Patient records
                [2] Doctor Management
                [3] Appointments
                [4] Medical Records
                [5] Billing and Payments
                [0] Exit%n
            ==================================================
        %n: """);
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                patient_records();
                break;
            case 2:
                doctor_management();
                break;
            case 3:
                appointments();
                break;
            case 4:
                medical_records();
                break;
            case 5:
                billing_payments();
                break;
            case 0:
                System.out.println("Thank you for using the system!");
                break;
            default:
                System.out.println("Invalid Choice, try again");
        }
    }
}
