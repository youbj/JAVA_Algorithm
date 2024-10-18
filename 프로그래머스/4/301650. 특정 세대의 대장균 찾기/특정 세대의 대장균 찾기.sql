SELECT g.ID as ID
FROM ECOLI_DATA g
JOIN ECOLI_DATA p ON g.PARENT_ID = p.ID
JOIN ECOLI_DATA gp ON p.PARENT_ID = gp.ID
WHERE gp.PARENT_ID IS NULL
order by ID