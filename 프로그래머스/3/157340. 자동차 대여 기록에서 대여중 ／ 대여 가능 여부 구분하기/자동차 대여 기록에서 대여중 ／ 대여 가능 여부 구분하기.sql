-- 코드를 입력하세요
# SELECT *
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where START_DATE <'2022-10-16' and END_DATE >= '2022-10-16'
# order by CAR_ID

# select HISTORY_ID, CAR_ID, START_DATE , MAX(END_DATE) as END_DATE
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# group by CAR_ID
# having START_DATE <'2022-10-16' and END_DATE >= '2022-10-16'
# order by CAR_ID

select CAR_ID, case
    when CAR_ID IN (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where '2022-10-16' between START_DATE AND END_DATE
    ) then '대여중'
    else '대여 가능'
    end as 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by CAR_ID
order by CAR_ID desc

