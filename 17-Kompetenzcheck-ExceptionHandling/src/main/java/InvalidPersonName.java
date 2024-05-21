public class InvalidPersonName extends Exception {
    String s;

    public InvalidPersonName() {
        this("Cannot contain Numbers");
    }
    public InvalidPersonName(String message){
        super(message);
    }

    public InvalidPersonName(String message , Exception innerException){
        super(message, innerException);
    }
}
