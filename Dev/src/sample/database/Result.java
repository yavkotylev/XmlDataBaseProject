package sample.database;

public class Result {
    public enum Status {
        SUCCESS,
        ERROR,
        EMPTY
    }

    private final Status status;
    private final String result;
    private final String error;

    public Result(Status status, String result, String error) {
        this.status = status;
        this.result = result;
        this.error = error;
    }

    public Result(Status status, String result) {
        this.status = status;
        this.result = result;
        this.error = null;
    }

    public String getError() {
        return error;
    }

    public Status getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }
}
