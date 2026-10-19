package services;
import java.util.*;
import java.io.*;
public class doctor_service {
  
    public static void delete_doctor(){
        ArrayList<String> doctors = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {

            String line;

            while((line = br.readLine()) != null){
                doctors.add(line);
            }

        } catch (IOException e) {
            System.out.println(
                "An error occured: "+ e.getMessage()
            );
        }

        boolean found = false; 

        for(int i = 0; i < doctors.size(); i++){
            String[] doctor = doctors.get(i).split(",", -1);

            if(doctor[0].trim().equalsIgnoreCase(search_id)){

                doctors.remove(i);
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("No doctor found with ID: " + search_id);
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("doctors.txt"))) {

            for(int i = 0; i < doctors.size(); i++){

                bw.write(doctors.get(i) + "\n");
                bw.newLine();
            }
            
            System.out.println("Doctor deleted successfully!");

        } catch (Exception e) {
            System.out.println(
                "An error occured: " + e.getMessage()
            );
        }
    }
    public static void edit_doctor(){
        ArrayList<String> doctors = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;

            while((line = br.readLine()) != null){
                doctors.add(line);
            }
        } catch (IOException e) {
            System.out.println(
                "An error occured: "+ e.getMessage()
            );
            return;
        }
        
        boolean found = false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("doctors.txt"))) {

            for(int i = 0; i < doctors.size(); i++){
                String[] doctor = doctors.get(i).split(",", -1);
                // This will take the doctor's record from the Arraylist and split into an array
                if(doctor[0].trim().equalsIgnoreCase(search_id)){
                    System.out.println("Enter new Doctor Name: ");
                    doctor[1] = sc.nextLine().trim();
                    System.out.println("Enter new Doctor Schedule: ");
                    doctor[2] = sc.nextLine().trim();
                    System.out.println("Enter new Doctor Phone Number: ");
                    doctor[3] = sc.nextLine().trim();
                    bw.write(doctor[0] + "," + doctor[1] + "," + doctor[2] + "," + doctor[3] + "\n");
                } else {
                    bw.write(doctors.get(i) + "\n");
                    found = true;
                }
            }

            if(!found){
                System.out.println("No doctor found with ID: " + search_id);
                return;
            }

        } catch (Exception e) {
            System.out.println(
                "An error occured: " + e.getMessage()
            );
        }
    }
    public static void view_doctor(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        boolean found = false;

        try(BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))){

            String line;

            while((line = br.readLine()) != null){
                String[] doctor = line.split(",", -1); 
                // This will split the line into an array (-1 is used to preserve all the elements even if one of the element is empty.)
                if(doctor[0].trim().equalsIgnoreCase(search_id)){
                    System.out.println("Doctor ID: " + doctor[0]);
                    System.out.println("Doctor Name: " + doctor[1]);
                    System.out.println("Doctor Schedule: " + doctor[2]);
                    System.out.println("Doctor Phone Number: " + doctor[3]);
                    found = true;
                    break;
                } 
            }

            if(!found){
                System.out.println("No doctor found with ID: " + search_id);
                return;
            }

        }catch(IOException e){
            System.out.println(
                "An error occured: "+ e.getMessage()
            );
        }
        sc.close();
    }
    public static void create_doctor() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("doctors.txt", true))) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Doctor ID: ");
            String id = sc.nextLine().trim();

            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Doctor Schedule: ");
            String specialization = sc.nextLine();

            System.out.print("Enter Doctor Phone Number: ");
            String phone = sc.nextLine();

            bw.write(id + ", " + name + ", " + specialization + ", " + phone);
            bw.newLine();

            System.out.println("Doctor created successfully!");
            sc.close();
        } catch (IOException e) {
            System.out.println(
                "An error occured: " + e.getMessage()
            );
        }

        
    }
}
