package com.camunda;

import org.camunda.bpm.client.ExternalTaskClient;

import java.io.IOException;
import java.util.logging.Logger;

public class WriteToCustomer {

    private final static Logger LOGGER = Logger.getLogger(WriteToCustomer.class.getName());

    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        // subscribe to an external task topic as specified in the process
        client.subscribe("ReplyTopic")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    // Put your business logic here

                    // Get a process variable
                    int reply = externalTask.getVariable("reply");

                    String email = externalTask.getVariable("email");
                    String content = "";
                    try {
                        content = new ReadFromFile().ReadFromFile(reply);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    new SendEmail().Send_Email(email, content);

                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }

}
