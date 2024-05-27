public class InvalidName extends Exception{
    String s;

    public InvalidName() {
        this("Cannot contain Numbers");
    }
    public InvalidName(String message){
        super(message);
    }

    public InvalidName(String message , Exception innerException){
        super(message, innerException);
    }
}
