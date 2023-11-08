import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPServer1
{
    public static void main(String[] args) throws IOException
    {
        String clientSentence;
        String capitalizedSentence;
        int nPort;

        nPort = 6789;
        ServerSocket welcomeSocket = new ServerSocket(nPort);

        System.out.println("Server start.. (port#=" + nPort + ")\n ");
        while (true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream())
            );
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("clientSentence = " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(clientSentence);
        }
    }
}
