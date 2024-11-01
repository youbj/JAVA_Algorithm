select b.CATEGORY, SUM(bs.SUM) as TOTAL_SALES
from BOOK b left join (
    select BOOK_ID, sum(SALES) as 'SUM'
    from BOOK_SALES 
    where SALES_DATE BETWEEN '2022-01-01' and '2022-01-31'
    group by BOOK_ID
)bs
using(BOOK_ID)
group by CATEGORY
order by CATEGORY