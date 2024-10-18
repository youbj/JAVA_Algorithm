-- 코드를 작성해주세요

select hd.DEPT_ID as DEPT_ID,hd.DEPT_NAME_EN as DEPT_NAME_EN, ROUND(AVG(he.SAL),0) as AVG_SAL
from HR_DEPARTMENT hd join HR_EMPLOYEES he using(DEPT_ID)
group by he.DEPT_ID
order by AVG_SAL desc