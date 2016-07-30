# 创建日志表
create table if not exists sys_log(
id bigint not null primary key auto_increment,
title varchar(25) not null comment '日志标题',
req_data blob comment '请求参数',
content varchar(255) default '' comment '内容',
exception_data blob  comment '异常信息',
req_ip varchar(50) default '' comment '操作的IP',
create_date DATE comment '创建时间',
create_user bigint  comment '创建人',
last_update_date date comment '最后更新时间',
last_update_user bigint comment '最后更新人',
status smallint comment '状态'
);

#创建资源表
create table if not exists sys_resource()


# 创建人员表
create table if not exists sys_user(
	
)

#创建角色表
create table if not exists sys_role(

)

#创建权限表
