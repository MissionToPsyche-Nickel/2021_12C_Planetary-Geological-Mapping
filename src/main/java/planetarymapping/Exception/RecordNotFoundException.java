package planetarymapping.Exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException() {
        super("Could not find record");
    }
}
