package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket connection = serverSocket.accept();
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String name = in.readLine();
            Todos todos = gson.fromJson(name, Todos.class);
            if (todos.type.equals("ADD")) {
                todos.addTask(todos.task);
            } else if (todos.type.equals("REMOVE")) {
                todos.removeTask(todos.task);
            }
            out.println(todos.getAllTasks());
            serverSocket.close();
        }
    }
}
