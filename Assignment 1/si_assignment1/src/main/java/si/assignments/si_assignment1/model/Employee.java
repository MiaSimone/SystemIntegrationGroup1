package si.assignments.si_assignment1.model;

public class Employee {
    private String name;
    private String email;
    private String IP;

    public Employee(String name, String email, String IP) {
        this.name = name;
        this.email = email;
        this.IP = IP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
