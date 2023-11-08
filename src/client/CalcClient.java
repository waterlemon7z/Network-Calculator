package client;

import entity.RequestEntity;
import entity.ResponseEntity;
import utils.ObjectManager;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class CalcClient
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Socket socket = new Socket("localhost", 59090);

        RequestEntity inputs = inputs();

        OutputStream outputStream = socket.getOutputStream();
        byte[] reqArray = ObjectManager.toByteArray(inputs);
        outputStream.write(reqArray);
        outputStream.flush();
//        outputStream.close();

        InputStream inputStream = socket.getInputStream();
        byte[] recvBytes = new byte[1024];
        int size = inputStream.read(recvBytes);
        ResponseEntity resultEntity = ObjectManager.toObject(recvBytes, ResponseEntity.class);
        System.out.println("resultEntity.toString() = " + resultEntity.toString());
        inputStream.close();
    }

    public static RequestEntity inputs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== Welcome to Socket Calculator ==========");
        System.out.println("Type like : add 2 5");
        System.out.print("Type operator(add, sub, mul, div) and Two operands : ");
        String operator = sc.nextLine();
        return new RequestEntity(operator);
    }

}
