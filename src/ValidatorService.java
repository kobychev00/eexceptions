public class ValidatorService {

    public ValidatorService() {
    }

    public static boolean validate (String login,
                                    String password,
                                    String confirmPassword) {

        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static void check (String login,
                              String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равно 20");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }

        regularWay(login, true);
        regularWay(password, false);

    }

    public static void regularWay(String string, boolean login)
            throws WrongLoginException, WrongPasswordException {
        if (!string.matches("^\\w+$")) {
            throw new WrongLoginException("В логине есть невалидный символ");
        }
        if (!string.matches("^\\w+$")) {
            throw new WrongPasswordException("В пароле есть невалидный символ");
        }
    }
}
