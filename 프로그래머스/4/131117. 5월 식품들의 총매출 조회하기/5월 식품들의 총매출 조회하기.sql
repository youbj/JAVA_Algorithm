-- 코드를 입력하세요
# SELECT *
# from FOOD_ORDER 
# where date_format(PRODUCE_DATE,"%Y-%m") = "2022-05"

SELECT fo.PRODUCT_ID as PRODUCT_ID, fp.PRODUCT_NAME as PRODUCT_NAME, SUM(fo.amount * fp.PRICE) as TOTAL_SALES
from FOOD_ORDER fo join FOOD_PRODUCT fp using(PRODUCT_ID)
where PRODUCE_DATE <= "2022-05-31" and PRODUCE_DATE >="2022-05-01"
group by PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID asc