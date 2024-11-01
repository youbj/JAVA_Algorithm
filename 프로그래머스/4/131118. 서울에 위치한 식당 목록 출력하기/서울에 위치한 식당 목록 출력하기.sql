-- 코드를 입력하세요
# SELECT ROUND(AVG(REVIEW_SCORE),2) as REVIEW
# from REST_REVIEW 
# group by REST_ID

# select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, j.REVIEW as SCORE
# from REST_INFO ri left join (
#     SELECT ROUND(AVG(REVIEW_SCORE),2) as REVIEW, REST_ID
#     from REST_REVIEW 
#     group by REST_ID
# ) as j
# using(REST_ID)
# having ADDRESS like "%서울%"
# order by SCORE desc, FAVORITES desc

select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(AVG(rr.REVIEW_SCORE),2) as SCORE
from REST_INFO ri join REST_REVIEW rr using(REST_ID)
group by (REST_ID)
having ADDRESS like "서울%"
order by SCORE desc, FAVORITES desc

