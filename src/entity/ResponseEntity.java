package entity;

public class ResponseEntity
{
    int statusCode;
    double calcNum;
    String message;

    public ResponseEntity(int statusCode, double calcNum, String message)
    {
        this.statusCode = statusCode;
        this.calcNum = calcNum;
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ResponseEntity{" +
                "statusCode=" + statusCode +
                ", calcNum=" + calcNum +
                ", message='" + message + '\'' +
                '}';
    }
}
