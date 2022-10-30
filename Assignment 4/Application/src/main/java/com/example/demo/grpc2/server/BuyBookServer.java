package com.example.demo.grpc2.server;

import com.example.demo.grpc2.domain.service.BuyBookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuyBookServer {

    private static final Logger logger = Logger.getLogger(BuyBookServer.class.getName());

    public static void main(String[] args)
    {
        // Builder creates a gRPC server on the specified port and adds the ExamService service that we defined to it
        Server server = ServerBuilder.forPort(9091)
                .addService(new BuyBookService())
                .build();

        try
        {
            server.start();
            logger.log(Level.INFO, "EXAM SERVER STARTED ON PORT 9091");
            // awaitTermination() method keeps the server running
            server.awaitTermination();
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "EXAM SERVER DID NOT START " + e);
        }
        catch (InterruptedException e)
        {
            logger.log(Level.SEVERE, "SERVER SHUT DOWN ON INTERRUPTED");
        }
    }

}
