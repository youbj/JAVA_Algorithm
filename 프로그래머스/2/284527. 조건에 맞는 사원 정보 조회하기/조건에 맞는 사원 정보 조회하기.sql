SELECT hg.total_score as SCORE, 
       he.EMP_NO, 
       he.EMP_NAME, 
       he.POSITION, 
       he.EMAIL
FROM HR_EMPLOYEES he
INNER JOIN (
    SELECT EMP_NO, 
           SUM(SCORE) as total_score
    FROM HR_GRADE 
    GROUP BY EMP_NO
    ORDER BY SUM(SCORE) DESC
    LIMIT 1    
) hg ON he.EMP_NO = hg.EMP_NO;