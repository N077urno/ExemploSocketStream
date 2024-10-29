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
public class TCPClient {
     public static void main(String[] args) {
        String serverAddress = "localhost"; // Endereço do servidor
        int port = 12345; // Porta do servidor
        
        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado ao servidor " + serverAddress + " na porta " + port);
            
            // Criando streams para leitura e escrita
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Envia uma mensagem ao servidor
            String message = "Olá, servidor!";
            out.println(message);
            System.out.println("Mensagem enviada ao servidor: " + message);
            
            // Recebe a resposta do servidor
            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);
            
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
