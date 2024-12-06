import javax.print.Doc;

public class Doctors extends Patient{
    public String _specialization;
    public static int _id = 0;
    public int _personalId;


    public Doctors(String name, String lastName, String pesel, String dateOfBirth, int age, String phoneNumber, String email,String specialization){
        this._firstName = name;
        this._lastName = lastName;
        this._pesel = pesel;
        this._dateOfBirth = dateOfBirth;
        this._age = age;
        this._phoneNumber = phoneNumber;
        this._email = email;
        this._specialization = specialization;
        _personalId = _id++;
    }

    public int get_personalId(){
        return _personalId;
    }
}
