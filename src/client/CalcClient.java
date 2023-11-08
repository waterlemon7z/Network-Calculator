package client;

import entity.RequestEntity;
import entity.ResponseEntity;
import entity.ServerInfoEntity;
import utils.ObjectManager;
import utils.ServerAddrSetting;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient
{
    /*
     * Name        : main
     * Date        : 2023-11-08
     * argument    : none
     * return      : void
     * description : client code of calculator.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        /*Set Servers*/
        ServerInfoEntity serverInfo = ServerAddrSetting.getServerInfo(); //get server info from server_info.dat
        Socket socket = new Socket(serverInfo.getServerAddr(), serverInfo.getPort()); //open socket to connect host

        RequestEntity inputs = inputs(); //get user inputs

        OutputStream outputStream = socket.getOutputStream(); //open output stream
        byte[] reqArray = ObjectManager.toByteArray(inputs); //object cannot be transfer. So convert it to byte array
        /*Send byte arrays to host*/
        outputStream.write(reqArray);
        outputStream.flush();

        /*Wait until receive results*/
        getResult(socket);

        outputStream.close(); //fine.
    }

    /*
     * Name        : getResult
     * Date        : 2023-11-08
     * argument    : Socket
     * return      : void
     * description : get result from host.
     */
    static private void getResult(Socket socket) throws IOException, ClassNotFoundException
    {
        InputStream inputStream = socket.getInputStream();
        byte[] recvBytes = new byte[1024];
        int size = inputStream.read(recvBytes); //read bytes from stream
        ResponseEntity resultEntity = ObjectManager.toObject(recvBytes, ResponseEntity.class); //byte array to object
        /*Prints result*/
        if(resultEntity.getStatusCode() == 200)
            System.out.println("Result = " + resultEntity.getCalcNum());
        else
        {
            System.out.println("Status Code : " + resultEntity.getStatusCode());
            System.out.println("Server Message : " + resultEntity.getMessage());
        }
        inputStream.close();
    }

    /*
     * Name        : inputs
     * Date        : 2023-11-08
     * argument    : none.
     * return      : RequestEntity
     * description : make object from user input
     */
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
