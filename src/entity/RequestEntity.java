package entity;

import java.io.Serializable;

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
