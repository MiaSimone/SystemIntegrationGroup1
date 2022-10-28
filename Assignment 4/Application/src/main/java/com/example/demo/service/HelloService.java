package com.example.demo.service;

import dk.dd.newgrpctest.gen.HelloRequest;
import dk.dd.newgrpctest.gen.HelloResponse;
import dk.dd.newgrpctest.gen.HelloServiceGrpc;
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
