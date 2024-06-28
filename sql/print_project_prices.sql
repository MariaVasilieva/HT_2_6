WITH project_prices AS (
    SELECT p.ID,
           SUM(w.SALARY * pd.duration_months) AS PRICE
    FROM project p
             JOIN project_worker pw ON p.ID = pw.PROJECT_ID
             JOIN worker w ON pw.WORKER_ID = w.ID
             JOIN (
        SELECT ID,
               (EXTRACT(YEAR FROM FINISH_DATE) - EXTRACT(YEAR FROM START_DATE)) * 12 +
               (EXTRACT(MONTH FROM FINISH_DATE) - EXTRACT(MONTH FROM START_DATE)) AS duration_months
        FROM project
    ) AS pd ON p.ID = pd.ID
    GROUP BY p.ID
)
SELECT * FROM project_prices
ORDER BY PRICE DESC;


