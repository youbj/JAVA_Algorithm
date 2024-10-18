-- 코드를 입력하세요
# where DATEDIFF(ao.DATETIME,ai.DATETIME) in (
#     SELECT DATEDIFF(b.DATETIME, a.DATETIME) as DIFF
#     from ANIMAL_INS a join ANIMAL_OUTS b using(ANIMAL_ID)
# )

select ai.ANIMAL_ID, ai.NAME
from ANIMAL_INS ai join ANIMAL_OUTS ao using(ANIMAL_ID)
order by DATEDIFF(ao.DATETIME,ai.DATETIME) desc
limit 2