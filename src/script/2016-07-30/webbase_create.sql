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
create table if not exists sys_resource(
  id bigint not null primary key auto_increment,
  create_date DATE comment '创建时间',
  create_user bigint  comment '创建人',
  last_update_date date comment '最后更新时间',
  last_update_user bigint comment '最后更新人',
  status smallint comment '状态',
  name varchar(25) not null comment '名称',
  type int not null default 1 comment '资源类型',
  href varchar(255),
  parent bigint comment '父节点',
  levels int not null default 0 comment '级次'
)


# 创建人员表
create table if not exists sys_user(
  id bigint not null primary key auto_increment,
  create_date DATE comment '创建时间',
  create_user bigint  comment '创建人',
  last_update_date date comment '最后更新时间',
  last_update_user bigint comment '最后更新人',
  status smallint comment '状态',
  name varchar(20) not null comment '用户名',
  account varchar(20) not null comment '账户',
  password varchar(20) not null comment '密码(MD5加密存储)'
)

#创建角色表
create table if not exists sys_role(
  id bigint not null primary key auto_increment,
  create_date DATE comment '创建时间',
  create_user bigint  comment '创建人',
  last_update_date date comment '最后更新时间',
  last_update_user bigint comment '最后更新人',
  status smallint comment '状态',
  name varchar(20) not null comment '角色名',
  isAdmin int not null default 0 comment '是否超级管理员'
)

#创建用户角色表
create table if not exists sys_user_role(
  user_id bigint not null comment '用户ID',
  role_id bigint not null comment '角色ID',
  primary key(user_id, role_id)
)


#创建角色资源表
create table if not exists sys_role_resource(
  role_id bigint not null comment '角色ID',
  resource_id bigint not null comment '资源ID',
  primary key(role_id, resource_id)
)