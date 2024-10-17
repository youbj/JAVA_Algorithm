-- 코드를 입력하세요
select concat('/home/grep/src/',b.BOARD_ID,'/',b.FILE_ID,b.FILE_NAME,b.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD a join USED_GOODS_FILE b on a.BOARD_ID=b.BOARD_ID
where a.VIEWS = (
    select MAX(VIEWS)
    from USED_GOODS_BOARD
)
order by b.FILE_ID DESC



# SELECT BOARD_ID
# from USED_GOODS_BOARD 
# order by VIEWS desc
