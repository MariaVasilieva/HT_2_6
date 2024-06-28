WITH youngest_oldest AS (
    SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
    FROM worker
    WHERE BIRTHDAY = (
        SELECT MAX(BIRTHDAY)
        FROM worker
        )
    UNION ALL
    SELECT 'ELDEST' AS TYPE, NAME, BIRTHDAY
    FROM worker
    WHERE BIRTHDAY = (
        SELECT MIN(BIRTHDAY)
        FROM worker
        )
)
SELECT * FROM youngest_oldest;
