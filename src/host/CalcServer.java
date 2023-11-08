package host;
import entity.RequestEntity;
import entity.ServerInfoEntity;
import utils.ObjectManager;
import utils.ServerAddrSetting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalcServer
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ServerInfoEntity serverInfo = ServerAddrSetting.getServerInfo();
        ServerSocket serverSocket = new ServerSocket(serverInfo.getPort());
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

