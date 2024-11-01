select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO r1
where (FAVORITES) in(
    SELECT MAX(FAVORITES)
    from REST_INFO r2
    where r1.FOOD_TYPE = r2.FOOD_TYPE
)
order by FOOD_TYPE desc

# select *
# from REST_INFO
# where FOOD_TYPE = '일식'
# order by FAVORITES desc
