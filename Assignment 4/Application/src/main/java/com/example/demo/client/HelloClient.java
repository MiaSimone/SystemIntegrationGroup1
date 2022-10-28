package com.example.demo.client;

import com.example.demo.grpc.HelloRequest;
import com.example.demo.grpc.HelloResponse;
import com.example.demo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloClient
{
      public static void main(String[] args)
      {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                    .usePlaintext()
                    .build();
            
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            
            HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                    .setFirstName(args[0])
                    .setLastName(args[1])
                    .build());
            
            System.out.println("Response received from server:\n" + helloResponse);
            
            channel.shutdown();
      }
}
