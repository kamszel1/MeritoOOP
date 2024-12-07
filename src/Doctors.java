import javax.print.Doc;

public class Doctors extends Patient{
    private Specialization _specialization;
    private static int _id = 0;
    private int _personalId;


    public Doctors(String name, String lastName, String pesel, String dateOfBirth, int age, String phoneNumber, String email,Specialization specialization){
        super(name, lastName, pesel, dateOfBirth, age, phoneNumber, email);
        this._specialization = specialization;
        _personalId = _id++;
    }
    public Specialization  getSpecialization() { return _specialization; }
    public int get_personalId(){
        return _personalId;
    }
}
