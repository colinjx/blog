drop  table user ;
drop  table note ;
drop  table dir ;

create table user(
  id int(20) auto_increment  primary key ,
  username varchar(200),
  password varchar(200)

);
create table note(
 notekey int(20) auto_increment  primary key ,
 title varchar(200),
 content tinyblob,
 dirkey int(20),
 content_html tinyblob

);
create table dir(
     dirkey int(20) auto_increment  primary key ,
     dirname varchar(200),
     updir int(20)

);
