-- 코드를 입력하세요
# SELECT HOST_ID, count(*) as CNT
# from PLACES
# group by HOST_ID
# having CNT>=2

select *
from PLACES
where HOST_ID in (
    SELECT HOST_ID
    from PLACES
    group by HOST_ID
    having count(*)>=2
)
order by ID asc