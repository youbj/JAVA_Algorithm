-- 코드를 작성해주세요

select ID, 
    case
        when SIZE_OF_COLONY <=100 THEN 'LOW'
        WHEN SIZE_OF_COLONY <=1000 THEN 'MEDIUM'
        ELSE 'HIGH'
    end as SIZE
from ECOLI_DATA
order by ID