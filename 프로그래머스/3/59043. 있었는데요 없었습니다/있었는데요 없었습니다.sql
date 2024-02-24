SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a 
join ANIMAL_OUTS b on a.animal_id = b.animal_id
    and a.datetime > b.datetime
order by a.datetime;
    
