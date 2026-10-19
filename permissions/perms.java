package permissions;
import services.*;
import java.util.*;
// All the permmissions will go here
// Will distribute the permissions to the different users
// admin perms - will have all the perms
// doctor perms - will have patient records and appointments
// member perms - will have patient records

public class perms {
    public static void patient_records() {
        // Admin can view patient records
        // Admin can add patient records
        // Admin can edit patient records
        // Admin can delete patient records
        // Admin can search patient records
        
    }
    public static void doctor_management() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("""
            ==================================================%n
                [1] Create Doctor Record
                [2] View Doctor Record
                [3] Edit Doctor Record
                [4] delete Doctor Record
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
        // adming can delete billing and payments
    }

}
