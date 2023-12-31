package entity;

import java.io.Serializable;

/*
 * Name        : ResponseEntity
 * Date        : 2023-11-08
 * description : this class is used for sending response
 */
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
