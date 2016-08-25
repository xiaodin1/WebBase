# 创建站台表 t_ticket_station
create table if not exists t_ticket_station(
id bigint not null primary key auto_increment,
number bigint not null,
shuangpin varchar(60) not null comment '双拼',
quanpin varchar(60) not null comment '全拼',
jianpin varchar(60) not null comment '简拼',
wubi varchar(60) not null comment '五笔',
name varchar(50) not null comment '车站名字',
fileMd5 blob comment 'station文件的md5码',
create_date DATE comment '创建时间',
create_user bigint  comment '创建人',
last_update_date date comment '最后更新时间',
last_update_user bigint comment '最后更新人'
)