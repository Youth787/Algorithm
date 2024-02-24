SELECT a.MEMBER_NAME, 
        b.REVIEW_TEXT,
        DATE_FORMAT(b.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM MEMBER_PROFILE a
JOIN REST_REVIEW b 
ON a.MEMBER_ID = b.MEMBER_ID
WHERE a.MEMBER_ID = (
                    select MEMBER_ID
                    from REST_REVIEW
                    group by MEMBER_ID
                    order by count(*) desc limit 1
                    )
order by b.REVIEW_DATE, b.REVIEW_TEXT;