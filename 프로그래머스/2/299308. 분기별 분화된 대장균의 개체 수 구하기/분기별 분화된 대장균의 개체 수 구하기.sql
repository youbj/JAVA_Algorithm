select     
    case 
        WHEN MONTH(DIFFERENTIATION_DATE)<=3 THEN '1Q'
        WHEN MONTH(DIFFERENTIATION_DATE)<=6 THEN '2Q'
        WHEN MONTH(DIFFERENTIATION_DATE)<=9 THEN '3Q'
        ELSE '4Q'
    end as QUARTER
, count(*) as ECOLI_COUNT
from ECOLI_DATA group by QUARTER
order by QUARTER;
