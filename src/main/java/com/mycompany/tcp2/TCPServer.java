/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcp2;

/**
 *
 * @author nando
 */
import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) {
        int port = 12345; // Porta onde o servidor estará escutando
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escutando na porta " + port);
            
            // Espera por uma conexão de um cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
            
            // Criando streams para leitura e escrita
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Lê a mensagem do cliente
            String messageFromClient = in.readLine();
            System.out.println("Mensagem recebida do cliente: " + messageFromClient);
            
            // Envia resposta de confirmação ao cliente
            out.println("Mensagem recebida com sucesso!");
            
            // Fecha a conexão com o cliente
            clientSocket.close();
            System.out.println("Conexão com o cliente fechada.");
            
        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
