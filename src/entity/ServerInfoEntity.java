package entity;

import java.io.Serializable;

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
