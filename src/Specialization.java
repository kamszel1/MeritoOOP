public enum Specialization {
    CARDIOLOGIST,
    ORTHOPEDIST,
    DENTIST;


    public String info() {
        // Przykład, aby wyświetlać nazwę specjalizacji w bardziej czytelnej formie
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}