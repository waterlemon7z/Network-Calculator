package entity;

import java.io.Serializable;

public class RequestEntity implements Serializable
{
    private final String operator;
    private final String operands;

    public RequestEntity(String operator, String operands)
    {
        this.operator = operator;
        this.operands = operands;
    }

    public String getOperator()
    {
        return operator;
    }

    public String getOperands()
    {
        return operands;
    }

    @Override
    public String toString()
    {
        return "RequestEntity{" +
                "operator='" + operator + '\'' +
                ", operands='" + operands + '\'' +
                '}';
    }
}
