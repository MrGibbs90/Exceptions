public class Main {
    public static boolean authentication(String login, String password, String confirmPassword) throws WrongPasswordException {
        if (login.length() > 20) {
            try {
                throw new WrongLoginException("Превышена длина логина");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        }
        if (password.length() > 19) {
            try {
                throw new WrongPasswordException("Превышена длина пароля");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }
    public static void main(String[] args) throws WrongPasswordException {
        String login = "jdscjlsdcnsdk_3908490584";
        String password = "kcjvsdkjcksdc;";
        String confirmPassword = "wkvhjjcvkj";

        boolean completeAuthentication = false;
        completeAuthentication = authentication(login, password, confirmPassword);
        System.out.println("Регистрация: " + completeAuthentication);
    }
}