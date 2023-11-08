package host;

import entity.RequestEntity;
import entity.ResponseEntity;
import exception.InvalidCalculationException;
import utils.ObjectManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class CalculatorSystem implements Runnable
{
    private final Socket socket;

    public CalculatorSystem(Socket socket)
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
            int size = is.read(recvBytes);
            RequestEntity receiveEntity = ObjectManager.toObject(recvBytes, RequestEntity.class);

            ResponseEntity resEntity = calculator(receiveEntity);
            send2client(resEntity);
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (InvalidCalculationException e)
        {
            ResponseEntity resEntity = new ResponseEntity(500, null, e.getMessage());
            try
            {
                send2client(resEntity);
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }

    void send2client(Object resEntity) throws IOException
    {
        OutputStream os = socket.getOutputStream();

        os.write(ObjectManager.toByteArray(resEntity));
        os.flush();
        os.close();
    }

    public ResponseEntity calculator(RequestEntity req) throws InvalidCalculationException
    {
        double rst;
        List<Integer> operands = new ArrayList<>();
        String[] splitMsg = req.getCalcMessage().split(" ");
        String operator = splitMsg[0].toUpperCase();
        for(int i = 1; i < splitMsg.length; i++)
        {
            operands.add(Integer.parseInt(splitMsg[i]));
        }

        if (operands.size() != 2)
            throw new InvalidCalculationException("Invalid operand : Has " + operands.size() + " operands");

        switch (operator)
        {
            case "ADD":
                rst = operands.get(0) + operands.get(1);
                break;
            case "SUB":
                rst = operands.get(0) - operands.get(1);
                break;
            case "MUL":
                rst = operands.get(0) * operands.get(1);
                break;
            case "DIV":
                if (operands.get(1) == 0)
                    throw new InvalidCalculationException("Divide by Zero");
                rst = (double) operands.get(0) / operands.get(1);
                break;
            default:
                throw new InvalidCalculationException("Invalid operator : " + operator);
        }

        return new ResponseEntity(200, rst, "All Done.");
    }
}
