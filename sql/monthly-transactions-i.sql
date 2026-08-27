
select DATE_FORMAT(t.trans_date,'%Y-%m') as month,t.country , 
count(id) as trans_count ,
sum(if(t.state="approved",1,0)) as approved_count,
sum(t.amount) as trans_total_amount, 
sum(if(t.state="approved",amount,0)) as approved_total_amount 
from Transactions t
 group by month,t.country;
