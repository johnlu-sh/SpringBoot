## DB config
Schema: sampledb  
Table: t_user
```
create table sampledb.t_user
(
    user_id    int auto_increment comment '用户Id'
        primary key,
    user_name  varchar(30)            not null comment '用户名',
    password   varchar(30) default '' not null comment '密码',
    user_type  tinyint     default 1  not null comment '1:普通用户 2:管理员',
    locked     tinyint     default 0  not null comment '0:未锁定 1:锁定',
    credit     int                    null comment '积分',
    last_visit datetime               null comment '最后登陆时间',
    last_ip    varchar(20)            null comment '最后登陆IP'
);

create index AK_AK_USER_USER_NAME
    on sampledb.t_user (user_name);
```

Table: t_login_log
```
create table sampledb.t_login_log
(
    login_log_id   int auto_increment
        primary key,
    user_id        int                    null,
    ip             varchar(30) default '' not null,
    login_datetime varchar(30)            not null
);
```

## Run the application
localhost:8080