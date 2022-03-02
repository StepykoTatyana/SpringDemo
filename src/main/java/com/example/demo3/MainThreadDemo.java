package com.example.demo3;

public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // main thread

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println(Thread.MIN_PRIORITY + " " + Thread.MAX_PRIORITY);
        System.out.println("Daemon: " + t.isDaemon());

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());
        System.out.println(t.isDaemon() ? "daemon" : "not daemon");
    }
}