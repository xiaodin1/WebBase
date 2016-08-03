-------用户角色表增加字段
alter table sys_user_role add isMain smallint not null default 0;
comment on column sys_user_role.ismain is '是否主要角色';