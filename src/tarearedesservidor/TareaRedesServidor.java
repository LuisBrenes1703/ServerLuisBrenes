package tarearedesservidor;

import java.io.IOException;

public class TareaRedesServidor {

    public static void main(String[] args) throws IOException {
        
        Servidor server = new Servidor();
        server.start(6666);
        
    }
    
}
