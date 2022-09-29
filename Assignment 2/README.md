# How to run the project:

1. Download the ZIP 'Camunda Platform 7 Run' (Community Edition) via https://camunda.com/download/
2. Download the ZIP 'Camunda Desktop Modeler' via https://camunda.com/download/modeler/
3. Run the file 'start.bat' (for Windows) or 'start.sh' (for Linux), so that you can see the welcome page of Camunda Platform in your browser (http://localhost:8080/camunda-welcome/index.html)
4. Deploy all three of our Camunda models in the directory HandlingCustomerComplaints/target/classes/camundaModels/ (.bpmn + .dmn + .form) via the Camunda Desktop Modeler preferably together.
5. Run the project in your IDE.
6. Start the process in the tasklist on Camunda Platform and fill out the input fields.
7. After selecting a complain topic and entering your email address, hit the red 'Complete' button.
8. Now the project should respond with a success in the terminal and you should receive a confirmation mail from dummydum0101@outlook.com to the specified email address you entered in step 7!
