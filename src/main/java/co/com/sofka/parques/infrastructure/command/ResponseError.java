package co.com.sofka.parques.infrastructure.command;

public class ResponseError {
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }


    public ResponseError(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}