import java.io.*;
import java.net.*;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Forma de uso: java EchoServer <numero da porta>");
			System.exit(1);
		}
		int portNumber = Integer.parseInt(args[0]);
		System.out.println("Servidor ECHO pronto... Pressione CTRL+C para sair. \nAguardando o Cliente...");
		String inputLine;
		ServerSocket serverSocket;
		Socket clientSocket;
		String userInput;
		try {
			serverSocket = new ServerSocket(portNumber);
			clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Aguardando Mensagem a enviar...");
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Mensagem enviada: " + inputLine);
				out.println(inputLine);
				System.out.println("Digite nova mensagem...");
			    if((userInput = in.readLine()) != null) {
			    break;
			    }
			}
		} catch (IOException e) {
			System.out.println("Erro detectado ao tentar ouvir a porta " + portNumber + " ou escutar a conexão.");
			System.out.println(e.getMessage());
		}
	}
}