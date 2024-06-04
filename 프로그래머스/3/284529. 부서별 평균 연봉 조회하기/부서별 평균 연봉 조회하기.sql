# select b.DEPT_ID , a.DEPT_NAME_EN, round(SAL ,1) as AVG_SAL
# from HR_DEPARTMENT a 
# join HR_EMPLOYEES b on a.DEPT_ID = b.DEPT_ID
# where (b.DEPT_ID, b.SAL) in (select DEPT_ID, avg(SAL)
#                        from HR_EMPLOYEES 
#                        group by DEPT_ID)
# order by AVG_SAL desc;

select b.DEPT_ID, a.DEPT_NAME_EN, round(avg(b.SAL),0) as AVG_SAL
from HR_DEPARTMENT a 
join HR_EMPLOYEES b on a.DEPT_ID = b.DEPT_ID
group by b.DEPT_ID
order by AVG_SAL desc;