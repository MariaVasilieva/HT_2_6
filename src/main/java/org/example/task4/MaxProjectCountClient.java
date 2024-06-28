package org.example.task4;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(int projectCount, String name) {
        this.projectCount = projectCount;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}