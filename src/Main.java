import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>(); // Dodajemy listę pacjentów
        List<Doctors> doctors = new ArrayList<>(); // Lista doktorów


        while (true) {
            System.out.println("Would you like to add a new patient, doctor or search for attributes? \n" +
                    "Enter 'add 1' to add a Patient, 'add 2' to add Doctor \n" +
                    "'search 1' to search via pesel, 'search 2' to search via last name,\n" +
                    "'search 3' to search via doctor's ID, 'search 4' to search via doctor's specialization. \n" +
                    "'update specialization' add specialization to a doctor via ID \n" +
                    "" +
                    "Type 'exit' to quit");
            String choice = input.nextLine();


            if (choice.equalsIgnoreCase("exit")) {
                break;
            } else if (choice.equalsIgnoreCase("add 2")) {

                //podawanie imienia doktora
                System.out.println("Please enter the name of the doctor: ");
                String name = input.nextLine();

                //podawanie nazwiska doktora
                System.out.println("Please enter the last name of the doctor: ");
                String lastName = input.nextLine();

                //podawanie peselu doktora
                //System.out.println("Please enter the pesel of the doctor: ");
                String pesel = input.nextLine();
                // sprawdzanie czy pesel ma 11 cyfr
                do {
                System.out.println("Please enter the pesel of the doctor:            ");
                    pesel = input.nextLine();
                } while (!Validator.isPeselValid(pesel));


                //podawanie daty urodzenia doktora
                System.out.println("Please enter the date of birth of the doctor: ");
                String dateOfBirth = input.nextLine();

                //podawanie wieku doktora
                System.out.println("Please enter the age of the doctor: ");
                int age = input.nextInt();

                //podawanie numeru doktora
                System.out.println("Please enter the phone number of the doctor: ");
                String phoneNumber = input.nextLine();

                //podawanie maila doktora
                System.out.println("Please enter the email of the doctor: ");
                String email = input.nextLine();

                // Wybór specjalizacji z enum
                System.out.println("Available specializations: ");
                for (Specialization spec : Specialization.values()) {
                    System.out.println("- " + spec.info());
                }
                Specialization specialization;
                while (true) {
                    try {
                        System.out.println("Enter the specialization: ");
                        specialization = Specialization.valueOf(input.nextLine().toUpperCase());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid specialization. Please choose one from the list.");
                    }
                }
                //String specialization = input.nextLine();

                Doctors newDoctor = new Doctors(name, lastName, pesel, dateOfBirth, age, phoneNumber, email, specialization);
                doctors.add(newDoctor);
                System.out.println("Doctor added successfully!");


            } else if (choice.equalsIgnoreCase("add 1")) {
                // recepcjonista dodaje dane pacjenta
                System.out.println("Enter first name: ");
                String firstName = input.nextLine();
                firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1); // formatuje na wielką literę

                System.out.println("Enter last name: ");
                String lastName = input.nextLine();
                lastName = lastName.toUpperCase().charAt(0) + lastName.substring(1); // formatuje na wielką literę

                System.out.println("Enter age: ");
                int age = input.nextInt();
                input.nextLine(); // Czyszczenie bufora jeśli ktoś poda coś więcej niż int

                String pesel;
                // sprawdzanie czy pesel ma 11 cyfr
                do {
                    System.out.println("Enter pesel: ");
                    pesel = input.nextLine();
                } while (!Validator.isPeselValid(pesel));

                System.out.println("Enter date of birth: ");
                String dateOfBirth = input.nextLine();

                String phoneNumber;
                // sprawdza czy telefon ma 9 cyfr i zamienia na format xxxxxxxxx
                do {
                    System.out.println("Enter phone number: ");
                    phoneNumber = input.nextLine();
                    phoneNumber = phoneNumber.replaceAll("-", "").replaceAll("\\s", "");
                } while (!Validator.isPhoneNumberValid(phoneNumber));


                String email;
                // sprawdza czy email ma "@"
                do {
                    System.out.println("Enter email: ");
                    email = input.nextLine();
                } while (!Validator.isEmailValid(email));

                // Tworzymy instancję Patient i dodajemy ją do listy
                Patient newPatient = new Patient(firstName, lastName, pesel, dateOfBirth, age, phoneNumber, email);
                patients.add(newPatient); // Dodawanie pacjenta do listy
                System.out.println("Patient added successfully!");

            } else if (choice.equalsIgnoreCase("search 1")) {
                System.out.println("Enter patient's PESEL to print info: ");
                String PESELtoSearch = input.nextLine();
                boolean found = false;
                for (Patient patient : patients) {
                    if (patient.getPesel().equals(PESELtoSearch)) {
                        System.out.println(patient.getfullPatientInfo());
                        found = true;
                        break;
                    }
                    if (!found) {
                        System.out.println("Patient not found!");
                    }
                }
            } else if (choice.equalsIgnoreCase("search 2")) {
                System.out.println("Enter patient's last name to print info: ");
                String lastNametoSearch = input.nextLine();
                boolean found = false;
                for (Patient patient : patients) {
                    if (patient.getLastName().equalsIgnoreCase(lastNametoSearch)) {
                        System.out.println(patient.getfullPatientInfo());
                        found = true;
                        break;
                    }
                    if (!found) {
                        System.out.println("Patient not found!");
                    }
                }
            } else if (choice.equalsIgnoreCase("update specialization")) {
                System.out.println("Enter the ID of the doctor to update their specialization: ");
                int doctorId = input.nextInt();
                input.nextLine(); // Czyszczenie bufora

                boolean doctorFound = false;
                for (Doctors doctor : doctors) {
                    if (doctor.get_personalId() == doctorId) {
                        doctorFound = true;

                        System.out.println("Available specializations: ");
                        for (Specialization spec : Specialization.values()) {
                            System.out.println("- " + spec.info());
                        }

                        System.out.println("Enter the new specialization to add: ");
                        try {
                            Specialization newSpecialization = Specialization.valueOf(input.nextLine().toUpperCase());
                            doctor.addSpecialization(newSpecialization);
                            System.out.println("Specialization added successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid specialization entered!");
                        }

                        break;
                    }
                }
                if (!doctorFound) {
                    System.out.println("Doctor with ID " + doctorId + " not found.");
                }
            } else if (choice.equalsIgnoreCase("search 3")) {
                System.out.println("Enter doctor's ID to print info: ");
                int idToSearch = input.nextInt();
                boolean found = false;
                for (Doctors doctor : doctors) {
                    if (doctor.get_personalId() == idToSearch) {
                        System.out.println("Doctor found: ");
                        System.out.println("Name: " + doctor.getFirstName());
                        System.out.println("Last name: " + doctor.getLastName());
                        System.out.println("Specialization: " + doctor.getSpecializations());
                        found = true;
                        break;
                    }
                    if (!found) {
                        System.out.println("Doctor not found!");
                    }
                }

            } else if (choice.equalsIgnoreCase("search 4")) {
                // Wyszukiwanie lekarzy po specjalizacji
                System.out.println("Available specializations: ");
                for (Specialization spec : Specialization.values()) {
                    System.out.println("- " + spec.info());
                }
                System.out.println("Enter specialization to search: ");
                String specializationInput = input.nextLine().toUpperCase();

                try {
                    Specialization specializationToSearch = Specialization.valueOf(specializationInput);
                    boolean found = false;
                    for (Doctors doctor : doctors) {
                        if (doctor.getSpecializations().contains(specializationToSearch)) {
                            System.out.println("Doctor ID: " + doctor.get_personalId());
                            System.out.println("Name: " + doctor.getFirstName());
                            System.out.println("Last Name: " + doctor.getLastName());
                            System.out.println("Specialization: " + doctor.getSpecializations());
                            System.out.println("------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No doctors found with the specialization: " + specializationToSearch.info());
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid specialization entered!");
                }
            }
        }
    }
}