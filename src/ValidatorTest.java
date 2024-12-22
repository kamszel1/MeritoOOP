import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void isPeselValid() {
        // Given
        String validPesel = "12345678901";

        // When
        boolean result = Validator.isPeselValid(validPesel);

        // Then
        assertTrue(result, "PESEL with 11 digits should be valid");
    }
    @Test
    void isPeselInvalid() {
        //Given
        String invalidPesel = "1234567890";

        // When
        boolean result = Validator.isPeselValid(invalidPesel);

        // Then
        assertTrue(result, "PESEL with 11 digits should be invalid");
    }
    @Test
    void isPhoneNumberValid() {
        // Given
        String validPhoneNumber = "123123123";

        // When
        boolean result = Validator.isPhoneNumberValid(validPhoneNumber);

        // Then
        assertTrue(result, "Phone number with 9 digits should be valid");
    }

    @Test
    void isPhoneNumberInvalid() {
        // Given
        String validPhoneNumber = "123";

        // When
        boolean result = Validator.isPhoneNumberValid(validPhoneNumber);

        // Then
        assertTrue(result, "Phone number without 9 digits should be invalid");
    }

    @Test
    void isEmailValid() {
        // Given
        String validEmail = "test@example.com";

        // When
        boolean result = Validator.isEmailValid(validEmail);

        // Then
        assertTrue(result, "Email with '@' should be valid");
    }

    @Test
    void isEmailInvalid() {
        // Given
        String validEmail = "test-example.com";

        // When
        boolean result = Validator.isEmailValid(validEmail);

        // Then
        assertTrue(result, "Email without '@' should be invalid");
    }
}