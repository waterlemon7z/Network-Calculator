package entity;

import java.io.Serializable;

public class test implements Serializable
{
    int a;

    public void setA(int a)
    {
        this.a = a;
    }

    public int getA()
    {
        return a;
    }

    @Override
    public String toString()
    {
        return "test{" +
                "a=" + a +
                '}';
    }
}
