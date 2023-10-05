SELECT distinct a.CAR_ID
from CAR_RENTAL_COMPANY_CAR as a 
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as b on a.car_id = b.car_id 
    and a.CAR_TYPE ='세단'
    and MONTH(b.start_date) = 10
order by car_id desc;