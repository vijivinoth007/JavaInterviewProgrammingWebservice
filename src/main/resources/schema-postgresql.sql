
CREATE TABLE IF NOT EXISTS arraysandstring
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS linkedlist
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS treesandgraph
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS sortingandsearching
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS recursion
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS design
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS dynamicProblem
( 
explanation varchar(3000),
answer varchar(7000),
id int primary key,
question varchar(1000),
output varchar(3000)
);

CREATE TABLE IF NOT EXISTS comment
( 
emailid varchar(40),
name varchar(40),
comment varchar(400),
dateandtime varchar(35)
);
