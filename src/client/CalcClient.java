package client;

import entity.RequestEntity;
import utils.ObjectManager;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class CalcClient
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 59090);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        RequestEntity inputs = inputs();
        byte[] reqArray = ObjectManager.toByteArray(inputs);
        outputStream.write(reqArray);
        outputStream.flush();


    }

    public static RequestEntity inputs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== Welcome to Socket Calculator ==========");
        System.out.println("add 2 5 means 2 + 5");
        System.out.print("Type operator(add, sub, mul, div) : ");
        String operator = sc.nextLine();
        System.out.print("Type two operand : ");
        String operands = sc.nextLine();
        return new RequestEntity(operator, operands);
    }

}
