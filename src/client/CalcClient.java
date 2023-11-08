package client;

import entity.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Socket socket = new Socket("localhost", 59090);
        InputStream inputStream = socket.getInputStream();
        Scanner in = new Scanner(inputStream);
        byte[] recvBuffer = new byte[1024];
        int inputSize = inputStream.read(recvBuffer);
        test object = (test) toObject(recvBuffer);
        assert object != null;
        System.out.println("object.getA() = " + object.getA());
//        System.out.println("Server response : " + in.nextLine());
//        String jsonByte =
    }


    public static Object toObject(byte[] bytes)
            throws IOException, ClassNotFoundException {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }
}
