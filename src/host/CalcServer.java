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
            pool.execute(new Capitalizer(sock));
        }
    }

    private static class Capitalizer implements Runnable
    {
        private final Socket socket;

        public Capitalizer(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            System.out.println("Connected : " + socket);
            try
            {
                InputStream is = socket.getInputStream();
                byte[] recvBytes = new byte[1024];
                int read = is.read(recvBytes);
                RequestEntity recvEntity = ObjectManager.toObject(recvBytes, RequestEntity.class);
                System.out.println(recvEntity.toString());
            } catch (IOException | ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
