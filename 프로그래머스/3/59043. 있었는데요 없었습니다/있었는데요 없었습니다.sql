-- 코드를 입력하세요
SELECT a.ANIMAL_ID as a, a.NAME as NAME
from ANIMAL_INS a left join ANIMAL_OUTS b using(ANIMAL_ID)
where a.DATETIME > b.DATETIME 
order by a.DATETIME
    
# and 