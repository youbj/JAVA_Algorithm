-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ai.name
from ANIMAL_INS ai left join ANIMAL_OUTS ao using(ANIMAL_ID)
where ai.SEX_UPON_INTAKE like "intact%" and ao.SEX_UPON_OUTCOME <> ai.SEX_UPON_INTAKE
order by ai.ANIMAL_ID