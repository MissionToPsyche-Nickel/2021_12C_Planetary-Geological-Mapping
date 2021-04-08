package planetarymapping.exceptions;

//Creating the FileStorageException, this gets thrown with any issue related to the file uploader
public class FileStorageException extends RuntimeException {

    private String msg;

    public FileStorageException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
