package entity;

import java.io.Serializable;

/*
 * Name        : ServerInfoEntity
 * Date        : 2023-11-08
 * description : this class is used for saving server info
 */
public class ServerInfoEntity implements Serializable
{
    private final String serverAddr;
    private final int port;

    public ServerInfoEntity(String serverAddr, int port)
    {
        this.serverAddr = serverAddr;
        this.port = port;
    }

    public String getServerAddr()
    {
        return serverAddr;
    }

    public int getPort()
    {
        return port;
    }
}
