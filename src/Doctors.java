import java.util.ArrayList;
import java.util.List;

public class Doctors extends Patient {
    private List<Specialization> specializations = new ArrayList<>();
    private static int _id = 0;
    private int _personalId;

    public Doctors(String name, String lastName, String pesel, String dateOfBirth, int age, String phoneNumber, String email, Specialization initialSpecialization) {
        super(name, lastName, pesel, dateOfBirth, age, phoneNumber, email);
        this.specializations.add(initialSpecialization);
        _personalId = _id++;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void addSpecialization(Specialization specialization) {
        if (!specializations.contains(specialization)) {
            specializations.add(specialization);
        } else {
            System.out.println("This specialization is already assigned to the doctor.");
        }
    }

    public int get_personalId() {
        return _personalId;
    }
}
