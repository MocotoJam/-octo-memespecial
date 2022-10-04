
// html// Fonte: https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
import java.io.*;
import java.net.*;

public class EchoClient {
        public static void main(String[] args) throws IOException {
                if (args.length != 2) {
                        System.err.println("Forma de uso: java EchoClient <IP Servidor> <número da porta>");
                        System.exit(1);
                }
                String hostName = args[0];
                int portNumber = Integer.parseInt(args[1]);
                System.out.println("Cliente ECHO iniciado...");
                String userInput;
                Socket echoSocket = null;
                BufferedReader in;
                BufferedReader in2;
                String inputLine;
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                try {
                        echoSocket = new Socket(hostName, portNumber);
                        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                        System.out.println("Conectado ao Servidor.");
                        System.out.println("Aguardando mensagem...");
                        while ((userInput = in.readLine()) != null) {
                                System.out.println("Mensagem recebida: " + userInput);
                                if(((inputLine = in.readLine()) != null)) {
                                	System.out.println("Mensagem enviada: " + inputLine);
                    				out.println(inputLine);
                    				 echoSocket = new Socket(hostName, portNumber);
                                     in2 = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                                     System.out.println("Mensagem enviada: " + inputLine);
                                }
                                }
                        
                } catch (UnknownHostException e) {
                        System.err.println("Ocorreu um erro ao tentar conectar ao servidor " + hostName);
                        System.exit(1);
                } catch (IOException e) {
                        System.err.println("Não foi possível conectar ao Servidor " + hostName);
                        System.exit(1);
                }
        }
}