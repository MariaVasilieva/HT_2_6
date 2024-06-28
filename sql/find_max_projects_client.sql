WITH project_count AS (
    SELECT CLIENT_ID, COUNT(*) AS project_total
    FROM project
    GROUP BY CLIENT_ID
),
     max_project_count AS (
         SELECT MAX(project_total) AS max_total
         FROM project_count
     )
SELECT client.NAME, project_count.project_total
FROM project_count
         JOIN client ON client.ID = project_count.CLIENT_ID
         JOIN max_project_count ON project_count.project_total = max_project_count.max_total;
