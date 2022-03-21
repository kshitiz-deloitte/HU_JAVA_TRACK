package Exception_handling_assigment;

public class PasswordException extends Exception{
    PasswordException(String ex){
        super(ex);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
