SELECT 
    YEAR(A.DIFFERENTIATION_DATE) as YEAR,
    ABS(B.MAX_SIZE_OF_COLONY-A.SIZE_OF_COLONY) as YEAR_DEV,
    ID
FROM 
    ECOLI_DATA A
Join
    (select 
        YEAR(DIFFERENTIATION_DATE) as YEAR,
        MAX(SIZE_OF_COLONY) as MAX_SIZE_OF_COLONY
    from 
        ECOLI_DATA 
    group by
        YEAR(DIFFERENTIATION_DATE)
     ) B
    on YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY 
    YEAR, YEAR_DEV