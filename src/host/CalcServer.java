package host;
import entity.RequestEntity;
import utils.ObjectManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalcServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(59090);
        System.out.println("Calculator Server is Running!!");
        ExecutorService pool = Executors.newFixedThreadPool(20);
        while(true)
        {
            Socket sock = serverSocket.accept();
            try
            {
                pool.execute(new CalculatorSystem(sock));
            }catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

