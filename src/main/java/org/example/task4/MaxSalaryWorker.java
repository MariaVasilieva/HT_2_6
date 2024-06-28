package org.example.task4;

public class MaxSalaryWorker {
    private String name;
    private int salary;

    public MaxSalaryWorker(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
