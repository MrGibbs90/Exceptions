public class Main {
    public static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";
    public static void login(String login)
    throws WrongLoginException {

        if (!login.matches(VALIDATE_PATTERN)) {

            throw new WrongLoginException("Логин содержит недопустимые символы");

        } else if (login.length() > 20) {
            throw new WrongLoginException("Превышена длина логина");
        }
    }

    public static void password(String password, String confirmPassword)
        throws WrongPasswordException{
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void check(String login, String password, String confirmPassword) {
        boolean isValid = true;
        try {
            login(login);
            password(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
            isValid = false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля: " + e.getMessage());
            isValid = false;
        }
        if (isValid) {
            System.out.println("Логин и пароль введены корректно");
            
        }
    }

    public static void main(String[] args) {

    }
}