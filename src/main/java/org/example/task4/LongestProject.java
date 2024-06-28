package org.example.task4;

public class LongestProject {
    private int projectId;
    private int durationMonths;

    public LongestProject(int projectId, int durationMonths) {
        this.projectId = projectId;
        this.durationMonths = durationMonths;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "projectId=" + projectId +
                ", durationMonths=" + durationMonths +
                '}';
    }
}
