WITH project_duration AS (
    SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE,
           (EXTRACT(YEAR FROM FINISH_DATE) - EXTRACT(YEAR FROM START_DATE)) * 12 +
           (EXTRACT(MONTH FROM FINISH_DATE) - EXTRACT(MONTH FROM START_DATE)) AS duration_months
    FROM project
)
SELECT project.ID, project_duration.duration_months AS MONTH_COUNT
FROM project_duration
         JOIN project ON project.ID = project_duration.ID
WHERE project_duration.duration_months = (
    SELECT MAX(duration_months)
    FROM project_duration
    );






