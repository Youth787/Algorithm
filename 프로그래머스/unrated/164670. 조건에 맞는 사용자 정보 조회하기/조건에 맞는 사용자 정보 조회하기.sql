SELECT b.USER_ID, b.NICKNAME, concat(b.CITY,' ',b.STREET_ADDRESS1,' ',b.STREET_ADDRESS2) as '전체주소', 
concat(left(b.tlno,3),'-',mid(b.tlno,4,4),'-',right(b.tlno,4)) as '전화번호'
from USED_GOODS_BOARD as a,
USED_GOODS_USER as b 
where a.WRITER_ID = b.USER_ID
and a.WRITER_ID in
(select a.WRITER_ID 
from USED_GOODS_BOARD as a
group by a.WRITER_ID
having count(a.WRITER_ID) >=3)
group by b.USER_ID
order by b.USER_ID desc;