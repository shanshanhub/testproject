###effective java
对effective java 的看书和代码的编写
####2,创建和销毁对象
createanddistoryobject
第一条:考虑用静态工厂方法代替构造器

###quyuqumo--取余取模

##fileoperator --对文件的操作

##cache --cache 的并发操作
缓存并发问题
1,解决
缓存过期后将尝试从后端数据库获取数据，这是一个看似合理的流程。但是，在高并发场景下，有可能多个请求并发的去从数据库获取数据，对后端数据库造成极大的冲击，甚至导致 “雪崩”现象。此外，当某个缓存key在被更新时，同时也可能被大量请求在获取，这也会导致一致性的问题。那如何避免类似问题呢？我们会想到类似“锁”的机制，在缓存更新或者过期的情况下，先尝试获取到锁，当更新或者从数据库获取完成后再释放锁，其他的请求只需要牺牲一定的等待时间，即可直接从缓存中继续获取数据

##datatest-- 日期格式转换

## messagedispatch 消息调度接口


