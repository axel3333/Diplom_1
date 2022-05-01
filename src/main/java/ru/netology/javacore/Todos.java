package ru.netology.javacore;

import java.util.*;


public class Todos {
    List<String> list = new ArrayList<>();
    String type;
    String task;

    public void addTask(String task) {
        list.add(task);
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public String getAllTasks() {
        //...
        StringBuilder builder = new StringBuilder();
        Collections.sort(list);
        for (String task : list) {
            builder.append(task + " ");
        }
        return builder.toString();
    }


}
