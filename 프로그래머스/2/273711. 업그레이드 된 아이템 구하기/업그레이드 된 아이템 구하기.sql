SELECT
ii.ITEM_ID, ii.ITEM_NAME,ii.RARITY
FROM
    ITEM_INFO AS ii
    JOIN ITEM_TREE AS it
        USING(ITEM_ID)
WHERE it.PARENT_ITEM_ID IN (SELECT ITEM_ID
                              FROM ITEM_INFO
                              WHERE RARITY='RARE')
ORDER BY
    it.ITEM_ID DESC