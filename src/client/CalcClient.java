package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 59090);
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("Server response : " + in.nextLine());
    }
}
