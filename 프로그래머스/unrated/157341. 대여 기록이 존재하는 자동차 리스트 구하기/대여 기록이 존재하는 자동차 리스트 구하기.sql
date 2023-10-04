SELECT a.CAR_ID
from CAR_RENTAL_COMPANY_CAR as a, 
CAR_RENTAL_COMPANY_RENTAL_HISTORY as b
where a.car_id = b.car_id 
and a.CAR_TYPE ='세단'
and MONTH(b.start_date) = 10
group by a.car_id
order by a.CAR_ID desc;
