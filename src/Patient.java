public class Patient {

   private String _firstName;
    private String _lastName;
    private String _pesel;
    private String _dateOfBirth;
    private int _age;
    private String _phoneNumber;
    private String _email;

    public Patient(){}

    public Patient(String firstName, String lastName, String pesel, String dateOfBirth, int age, String phoneNumber, String email) {
        _firstName = firstName;
        _lastName = lastName;
        _pesel = pesel;
        _dateOfBirth = dateOfBirth;
        _age = age;
        _phoneNumber = phoneNumber;
        _email = email;
    }



    //getters
    public String getFirstName() { return _firstName; }
    public String getLastName() { return _lastName; }
    public String getPesel() { return _pesel; }
    public String getDateOfBirth() {
        return _dateOfBirth;
    }
    public int getAge() {
        return _age;
    }
    public String getEmail() {
        return _email;
    }
    public String getPhoneNumber() {
        return _phoneNumber;
    }
    public String getfullPatientInfo() {
        return "First name: " + _firstName + "\n" +
                "Last name: " + _lastName + "\n" +
                "Pesel: " + _pesel + "\n" +
                "Date of birth: " + _dateOfBirth + "\n" +
                "Age: " + _age + "\n" +
                "Phone number: " + _phoneNumber + "\n" +
                "Email: " + _email;
    }
    public String getfullPatientInfoByPesel(String pesel) {
        return "First name: " + _firstName + "\n" +
                "Last name: " + _lastName + "\n" +
                "Pesel: " + _pesel + "\n" +
                "Date of birth: " + _dateOfBirth + "\n" +
                "Age: " + _age + "\n" +
                "Phone number: " + _phoneNumber + "\n" +
                "Email: " + _email;
    }


}
