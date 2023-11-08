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
    /*
     * Name        : main
     * Date        : 2023-11-08
     * argument    : none
     * return      : void
     * description : host code for calculator
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ServerInfoEntity serverInfo = ServerAddrSetting.getServerInfo(); //get server info from server_info.dat
        ServerSocket serverSocket = new ServerSocket(serverInfo.getPort());//open socket
        System.out.println("Calculator Server is Running!!");
        ExecutorService pool = Executors.newFixedThreadPool(20); //Defines threads.
        while (true)
        {
            Socket socket = serverSocket.accept(); // when clients connected
            try
            {
                pool.execute(new CalculatorSystem(socket)); //execute it
            } catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

