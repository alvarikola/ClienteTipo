package clientetipo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteTipo {

    
    public static void main(String[] args) {
        // IP y puerto del servidor
        String host = "localhost";
        int port = 1234;
        
        try {
            //Conectarse al servidor
            Socket socket = new Socket(host, port);
            System.out.println("Conectado al servidor " + host + " en el puerto " + port + ".");
            
            // Enviarle un mensaje
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            int numeroSaludo = 0;
            while (++numeroSaludo <= 5) {
                System.out.println("Mando este mensaje: 'Saludos " + numeroSaludo + " desde el cliente'.");
                output.println("Saludos " + numeroSaludo + " desde el cliente.");

                String answer = input.readLine();
                System.out.println("La respuesta del servidor es: " + answer);    
            }
            
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
