package services;

import java.io.*;
import java.util.*;

public class appointment_service {

    static Scanner sc = new Scanner(System.in);

    public static boolean doctor_exists(String doctorID) {
        try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] doctor = line.split(",", -1);

                if (doctor.length > 0 && doctor[0].trim().equalsIgnoreCase(doctorID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return false;
    }

    public static void add_appointment() {
        System.out.print("Enter Appointment ID: ");
        String appointmentID = sc.nextLine().trim();

        System.out.print("Enter Patient ID: ");
        String patientID = sc.nextLine().trim();

        System.out.print("Enter Doctor ID: ");
        String doctorID = sc.nextLine().trim();

        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.nextLine().trim();

        System.out.print("Enter Appointment Time (HH:MM): ");
        String time = sc.nextLine().trim();

        System.out.print("Enter Appointment Reason: ");
        String reason = sc.nextLine().trim();

        System.out.print("Enter Appointment Status: ");
        String status = sc.nextLine().trim();

        if (appointmentID.isEmpty() || patientID.isEmpty() || doctorID.isEmpty() || date.isEmpty() || time.isEmpty() || reason.isEmpty() || status.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (!doctor_exists(doctorID)) {
            System.out.println("Doctor ID not found. Please try again.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("appointment.txt", true))) {
            bw.write(appointmentID + "," + patientID + "," + doctorID + "," + date + "," + time + "," + reason + "," + status);
            bw.newLine();

            System.out.println("Appointment added successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void view_appointment(String doctorID) {
        System.out.print("Enter Patient ID: ");
        String patientID = sc.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("appointment.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] appointment = line.split(",", -1);

                if (appointment.length == 7 && appointment[1].trim().equalsIgnoreCase(patientID) && (doctorID == null || doctorID.isEmpty()|| appointment[2].trim().equalsIgnoreCase(doctorID))) {

                    System.out.println("Appointment ID: " + appointment[0]);
                    System.out.println("Patient ID: " + appointment[1]);
                    System.out.println("Doctor ID: " + appointment[2]);
                    System.out.println("Date: " + appointment[3]);
                    System.out.println("Time: " + appointment[4]);
                    System.out.println("Reason: " + appointment[5]);
                    System.out.println("Status: " + appointment[6]);

                    found = true;
                }
            }

            if (!found) {
                System.out.println("No appointments found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void edit_appointment() {
        System.out.print("Enter Appointment ID to edit: ");
        String appointmentID = sc.nextLine().trim();

        ArrayList<String> appointments = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("appointment.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] appointment = line.split(",", -1);

                if (appointment.length == 7
                        && appointment[0].trim().equalsIgnoreCase(appointmentID)) {

                    found = true;

                    System.out.print("Enter new Patient ID: ");
                    String patientID = sc.nextLine().trim();

                    System.out.print("Enter new Doctor ID: ");
                    String doctorID = sc.nextLine().trim();

                    System.out.print("Enter new Appointment Date (YYYY-MM-DD): ");
                    String date = sc.nextLine().trim();

                    System.out.print("Enter new Appointment Time (HH:MM): ");
                    String time = sc.nextLine().trim();

                    System.out.print("Enter new Appointment Reason: ");
                    String reason = sc.nextLine().trim();

                    System.out.print("Enter new Appointment Status: ");
                    String status = sc.nextLine().trim();

                    if (patientID.isEmpty() || doctorID.isEmpty() || date.isEmpty()
                            || time.isEmpty() || reason.isEmpty() || status.isEmpty()) {
                        System.out.println("All fields are required. Edit cancelled.");
                        return;
                    }

                    if (!doctor_exists(doctorID)) {
                        System.out.println("Doctor ID not found. Edit cancelled.");
                        return;
                    }

                    line = appointmentID + "," + patientID + "," + doctorID + ","
                            + date + "," + time + "," + reason + "," + status;
                }

                appointments.add(line);
            }

            if (!found) {
                System.out.println("Appointment ID not found.");
                return;
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("appointment.txt"))) {
            for (String appointment : appointments) {
                bw.write(appointment);
                bw.newLine();
            }

            System.out.println("Appointment updated successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void delete_appointment() {
        System.out.print("Enter Appointment ID to delete: ");
        String appointmentID = sc.nextLine().trim();

        ArrayList<String> appointments = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("appointment.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] appointment = line.split(",", -1);

                if (appointment.length == 7
                        && appointment[0].trim().equalsIgnoreCase(appointmentID)) {
                    found = true;
                } else {
                    appointments.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Appointment ID not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("appointment.txt"))) {
            for (String appointment : appointments) {
                bw.write(appointment);
                bw.newLine();
            }

            System.out.println("Appointment deleted successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}