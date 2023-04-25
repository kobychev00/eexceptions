public class Main {
    public static void main(String[] args) {

        boolean result = ValidatorService.validate("test_123", "dfghjkiuy23", "dfghjkiuy23");
        if (result) {
            System.out.println("Логин и пароль корректны");
        }
    }
}