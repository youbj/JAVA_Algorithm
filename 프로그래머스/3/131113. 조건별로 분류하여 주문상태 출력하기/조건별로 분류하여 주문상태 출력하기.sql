-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,"%Y-%m-%d") as OUTDATE,
    case
        when OUT_DATE is null then '출고미정'
        when OUT_DATE > DATE('2022-05-01') then '출고대기'
        else '출고완료'
    end as '출고여부'
from FOOD_ORDER
order by ORDER_ID