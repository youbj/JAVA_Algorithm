# select a.ID as ID, b.FISH_NAME as FISH_NAME, a.LENGTH as LENGTH
# from 
#     FISH_INFO a JOIN FISH_NAME_INFO b using(FISH_TYPE)
# where a.ID IN (
#     select ID, MAX(LENGTH)
#     from FISH_INFO 
#     group by FISH_TYPE
#     ) 
# order by a.ID asc

select a.ID as ID, b.FISH_NAME as FISH_NAME, a.LENGTH as LENGTH
from FISH_INFO a 
    join FISH_NAME_INFO b using(FISH_TYPE)
where (a.FISH_TYPE, a.LENGTH) in (
    select FISH_TYPE, MAX(LENGTH)
    from FISH_INFO 
    group by FISH_TYPE
) 
order by a.ID asc