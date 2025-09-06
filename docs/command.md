## H2 数据库访问地址

http://localhost:8081/h2-console


## Nacos Server 访问地址

http://localhost:8848/nacos

默认账户名/密码：nacos/nacos

## 调用示例

```bash
# 调用 service-provider
curl -s http://localhost:8081/users/1 | jq
{
  "id": 1,
  "name": "张三",
  "age": 18,
  "balance": 1000.0
}
# 调用 service-consumer
curl -s http://localhost:8082/users/1 | jq
{
  "id": 1,
  "name": "张三",
  "age": 18,
  "balance": 1000.0
}
```
