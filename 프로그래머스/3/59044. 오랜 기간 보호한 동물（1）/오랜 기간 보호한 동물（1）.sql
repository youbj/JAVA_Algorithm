select a.NAME as NAME, a.DATETIME as DATETIME
from ANIMAL_INS a left join ANIMAL_OUTS b using(ANIMAL_ID)
where b.NAME is null and a.NAME is not null
order by a.DATETIME
limit 3