package host;
import entity.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CalcServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(59090);
        System.out.println("Calculator Server is Running!!");
        test t = new test();
        t.setA(10);
        byte[] byteArray = toByteArray(t);

        while(true)
        {
            try(Socket socket = serverSocket.accept())
            {
//                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//                printWriter.println("ok");

                OutputStream os = socket.getOutputStream();
                os.write(byteArray);
                os.flush();
            }
        }
    }
    public static byte[] toByteArray (Object obj)
    {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas))
        {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
