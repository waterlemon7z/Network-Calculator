package entity;

import java.io.Serializable;

/*
 * Name        : RequestEntity
 * Date        : 2023-11-08
 * description : this class is used for sending request
 */
public class RequestEntity implements Serializable
{
    private final String calcMessage;

    public RequestEntity(String operator)
    {
        this.calcMessage = operator;
    }

    public String getCalcMessage()
    {
        return calcMessage;
    }

    @Override
    public String toString()
    {
        return "RequestEntity{" +
                "operator='" + calcMessage + '\'' +
                '}';
    }
}
