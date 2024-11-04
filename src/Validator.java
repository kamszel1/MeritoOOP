public class Validator {

    //sprawdza czy pesel ma 11 cyfr
    public static boolean isPeselValid(String pesel) {
        return pesel.length() == 11;
    }

    //sprawdza czy numer ma 9 cyfr i zamienia np 123-123-123; 123 123 123 na 123123123
    public static boolean isPhoneNumberValid(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("-", "").replaceAll("\\s", "");
        return phoneNumber.length() == 9;
    }

    // sprawdza czy email ma "@"
    public static boolean isEmailValid(String email) {
        String regex = ".*[@]*.";
        return email.matches(regex);
    }
}
