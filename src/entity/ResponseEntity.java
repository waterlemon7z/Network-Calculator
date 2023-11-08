package entity;

import java.io.Serializable;

public class ResponseEntity implements Serializable
{
    int statusCode;
    Double calcNum;
    String message;

    public ResponseEntity(int statusCode, Double calcNum, String message)
    {
        this.statusCode = statusCode;
        this.calcNum = calcNum;
        this.message = message;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public Double getCalcNum()
    {
        return calcNum;
    }

    public String getMessage()
    {
        return message;
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
