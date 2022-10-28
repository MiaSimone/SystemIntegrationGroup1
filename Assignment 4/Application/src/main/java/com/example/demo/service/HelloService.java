package com.example.demo.service;

import com.example.demo.grpc.HelloRequest;
import com.example.demo.grpc.HelloResponse;
import com.example.demo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase
{
                  @Override
                  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver)
                  {
                        System.out.println("Request received from client:\n" + request);
                        String greeting = new StringBuilder().append("Hello, ")
                                .append(request.getFirstName())
                                .append(" ")
                                .append(request.getLastName())
                                .toString();
                        HelloResponse response = HelloResponse.newBuilder()
                                .setGreeting(greeting)
                                .build();
                        responseObserver.onNext(response);
                        responseObserver.onCompleted();
                  }
}
