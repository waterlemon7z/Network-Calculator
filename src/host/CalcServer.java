package host;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(59090);
        System.out.println("Calculator Server is Running!!");
        while(true)
        {
            try(Socket socket = serverSocket.accept())
            {
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("ok");
                System.out.println(printWriter.toString());
            }
        }
    }
}
