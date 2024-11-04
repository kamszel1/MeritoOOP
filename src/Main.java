import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>(); // Dodajemy listę pacjentów

        while (true) {
            System.out.println("Would you like to add a new patient or search by PESEL? (Enter 'add' or 'search'. Type 'exit' to quit):");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            } else if (choice.equalsIgnoreCase("add")) {
                // recepcjonista dodaje dane pacjenta
                System.out.println("Enter first name: ");
                String firstName = input.nextLine();

                System.out.println("Enter last name: ");
                String lastName = input.nextLine();

                System.out.println("Enter age: ");
                int age = input.nextInt();
                input.nextLine(); // Czyszczenie bufora jeśli ktoś poda coś więcej niż int

                System.out.println("Enter pesel: ");
                String pesel = input.nextLine();

                System.out.println("Enter date of birth: ");
                String dateOfBirth = input.nextLine();

                System.out.println("Enter phone number: ");
                String phoneNumber = input.nextLine();

                System.out.println("Enter email: ");
                String email = input.nextLine();

                // Tworzymy instancję Patient i dodajemy ją do listy
                Patient newPatient = new Patient(firstName, lastName, pesel, dateOfBirth, age, phoneNumber, email);
                patients.add(newPatient); // Dodawanie pacjenta do listy
                System.out.println("Patient added successfully!");
            } else if (choice.equalsIgnoreCase("search")) {
                System.out.println("Enter patient's PESEL to print info: ");
                String PESELtoSearch = input.nextLine();
                for (Patient patient : patients) {
                    if (patient.getPesel().equals(PESELtoSearch)) {
                        System.out.println(patient.getfullPatientInfo());
                    } else { //printuje sie nawet jak pesel jest dobry
                        System.out.println("something went wrong!"); // a jak zły to dwa razy xd
                    }
                }

            }


        }

    }
}