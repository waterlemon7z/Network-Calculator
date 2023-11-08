package utils;

import entity.ServerInfoEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Name        : ServerAddrSetting
 * Date        : 2023-11-08
 * description : this class manage server settings
 */
public class ServerAddrSetting
{
    public static void main(String[] args) throws IOException
    {
        BufferedOutputStream fileOutput = new BufferedOutputStream(Files.newOutputStream(Paths.get("server_info.dat")));
        ServerInfoEntity serverInfo = new ServerInfoEntity("localhost", 59090);
        byte[] byteArray = ObjectManager.toByteArray(serverInfo);
        fileOutput.write(byteArray);
        fileOutput.flush();
        fileOutput.close();
    }

    public static ServerInfoEntity getServerInfo() throws IOException, ClassNotFoundException
    {
        BufferedInputStream fileInput = new BufferedInputStream(Files.newInputStream(Paths.get("server_info.dat")));
        byte[] input = new byte[1024];
        int size = fileInput.read(input);
        return ObjectManager.toObject(input, ServerInfoEntity.class);
    }

}
