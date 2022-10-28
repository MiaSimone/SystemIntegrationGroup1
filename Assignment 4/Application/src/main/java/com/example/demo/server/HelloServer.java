package com.example.demo.server;

import com.example.demo.service.HelloService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

// Create grpc server at port 6565 and add the service to it
public class HelloServer
{
      public static void main(String[] args) throws IOException, InterruptedException
      {
            Server server = ServerBuilder.forPort(6565)
                    .addService(new HelloService()).build();
            
            System.out.println("Starting server...");
            server.start();
            System.out.println("HelloServer started!");
            server.awaitTermination();
      }
}
