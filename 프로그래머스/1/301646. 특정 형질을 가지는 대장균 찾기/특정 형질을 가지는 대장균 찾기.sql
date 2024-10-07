-- 코드를 작성해주세요
select count(*) as COUNT 
from ECOLI_DATA
where 
1=1 AND
(GENOTYPE&2)!=2 AND
 ((GENOTYPE & 4) = 4 OR (GENOTYPE & 1) = 1)