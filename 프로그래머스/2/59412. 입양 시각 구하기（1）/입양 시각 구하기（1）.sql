SELECT hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
group by HOUR
having HOUR>8 and HOUR<20
order by HOUR