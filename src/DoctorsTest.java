import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorsTest {

    @Test
    void addSpecialization() {
        // Given
        Specialization initialSpecialization = Specialization.CARDIOLOGIST;
        Specialization newSpecialization = Specialization.ORTHOPEDIST;
        Doctors doctor = new Doctors(
                "John", "Pork", "12345678901", "01.01.2001", 23,
                "123123123", "john@gmail.com", initialSpecialization);

        // When
        doctor.addSpecialization(initialSpecialization);
        doctor.addSpecialization(newSpecialization);


        // Then
        assertTrue(doctor.getSpecializations().contains(initialSpecialization), "Initial specialization should be in the list.");
        assertTrue(doctor.getSpecializations().contains(newSpecialization), "New specialization should be added.");
        assertEquals(2, doctor.getSpecializations().size(), "There should be exactly two specializations.");
    }
}