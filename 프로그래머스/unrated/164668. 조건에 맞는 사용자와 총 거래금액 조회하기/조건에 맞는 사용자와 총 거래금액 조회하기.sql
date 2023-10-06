SELECT b.USER_ID, b.NICKNAME, SUM(a.PRICE) as 'TOTAL_SALES'
from USED_GOODS_BOARD as a
join USED_GOODS_USER as b on a.WRITER_ID = b.USER_ID
where a.status = 'DONE'
group by a.writer_id
having sum(a.price) >= 700000
order by SUM(a.PRICE);