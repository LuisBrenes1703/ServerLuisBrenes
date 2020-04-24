package tarearedesservidor;

import java.net.*;
import java.io.*;

public class Servidor {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("encendi el server");
        clientSocket = serverSocket.accept();
        System.out.println("Acepte el cliente");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String mensaje = in.readLine();
        if ("hello server".equals(mensaje)) {
            System.out.println("hello server");
            out.println("conexion exitosa");
            stop();
            System.out.println("conexion finalizada");
        } else {
            System.out.println("unrecognised greeting");
            out.println("conexion fallida");
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
