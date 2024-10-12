select count(*) as FISH_COUNT, FISH_NAME
from 
    FISH_INFO FI Join FISH_NAME_INFO FN using(FISH_TYPE)
group by FISH_NAME
order by FISH_COUNT desc