-- 코드를 입력하세요

select ugu.USER_ID, ugu.NICKNAME, buf.sum as TOTAL_SALES
from USED_GOODS_USER ugu inner join (
    SELECT WRITER_ID, sum(PRICE) as sum
    from USED_GOODS_BOARD 
    where STATUS='DONE'
    group by WRITER_ID
    having sum>=700000
)buf
on ugu.USER_ID = buf.WRITER_ID
order by TOTAL_SALES asc