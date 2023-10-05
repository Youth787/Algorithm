SELECT c.APNT_NO, a.PT_NAME, a.PT_NO, b.MCDP_CD, b.DR_NAME, c.APNT_YMD
FROM PATIENT as a 
join APPOINTMENT as c on a.PT_NO = c.PT_NO
join DOCTOR as b on b.DR_ID = c.MDDR_ID
    and Date_format(c.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
    and c.MCDP_CD = 'CS'
    and c.APNT_CNCL_YN = 'N'
order by c.APNT_YMD;