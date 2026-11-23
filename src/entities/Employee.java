package entities;
public class Employee {
    private static int nextId = 1;
    private int id;
    private String name;
    private String role;
    private double baseSalary;


    public Employee( String name, String role, double baseSalary) {
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.id = nextId;
        nextId++;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void increaseSalary(double percentage){
        double increase = baseSalary * percentage / 100;
        baseSalary += increase;
    }

    @Override
    public String toString() {
         return String.format(
                "id: %d%n" +
                        "name: '%s'%n" +
                        "role: '%s'%n" +
                        "baseSalary: %.2f",
                id, name, role, baseSalary
        );
    }
}
