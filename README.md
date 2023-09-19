# AWS cloud services with Spring Boot 

## Introduction
The aim of this workshop is to get an overview of some of the most important AWS services, how to use them and how to integrate the with Spring Boot.

## Requirements

- IntelliJ IDEA Ultimate
- Docker
- Java 17
- redis-cli or a Redis GUI

## Preparation

Resources:  

AWS free tier offerings
- https://aws.amazon.com/free/

AWS SDK
- https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html
- https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/credentials-temporary.html
- https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/usecases/creating_sns_sample_app

AWS with Spring
- https://spring.io/projects/spring-cloud-aws
- https://awspring.io/
- https://github.com/awspring/spring-cloud-aws
- https://docs.awspring.io/spring-cloud-aws/docs/3.0.2/reference/html/index.html
- https://github.com/lokeshgupta1981/Spring-Boot-Examples/tree/master

AWS deployment options
- https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html#deployment.cloud
- https://docs.aws.amazon.com/whitepapers/latest/overview-deployment-options/aws-deployment-services.html
- https://arnoldgalovics.com/spring-boot-aws-lambda/ (Lambda)
- https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/ (Beanstalk)
- https://towardsaws.com/spring-boot-app-on-eks-from-scratch-8c173737f1a (EKS)

## Services

### 1. Configuration
**We'll use the `configuration` project.**

AWS Parameter Store
- https://docs.spring.io/spring-cloud-config/docs/current/reference/html/
- https://soshace.com/spring-cloud-config-refresh-strategies/
- https://saturncloud.io/blog/spring-cloud-config-client-reloading-config-every-30-seconds/
- https://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-parameter-store.html

AWS Secrets Manager
- https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html
- https://levelup.gitconnected.com/using-aws-parameter-store-and-secret-manager-with-spring-boot-b8344bd49305 (Se)

### 2. SQL
**We'll use the `sql` project.**

AWS RDS:
- https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_GettingStarted.html
- https://blackninjasoft.com/blog/adding-a-database-to-your-rails-application-on-elastic-beanstalk-using-rds
- https://repost.aws/questions/QUf7DbNMKFQmWiRg8oMB0obA/why-must-an-rds-always-have-two-subnets

Environment variables to use for Elastic Beanstalk deployment: 
```
SERVER_PORT=5000
SPRING_DATASOURCE_URL=jdbc:postgresql://<url>/customer
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=test1234
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
```

### 3. NoSQL
**We'll use the `nosql` project.**

AWS DynamoDB
- https://dynobase.dev/dynamodb-vs-documentdb/
- https://reflectoring.io/spring-dynamodb/
- https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Query.Pagination.html
- https://howtodoinjava.com/spring-boot/spring-cloud-aws-dynamodbtemplate/
- https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/transaction-example.html

### 4. Observability
**We'll use the `observability` project.**

AWS CloudWatch
- https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html
- https://mehmetozkaya.medium.com/monitor-spring-boot-custom-metrics-with-micrometer-and-prometheus-using-docker-62798123c714
- https://reflectoring.io/spring-aws-cloudwatch/

AWS X-Ray
- https://docs.aws.amazon.com/xray/latest/devguide/aws-xray.html
- https://github.com/anthunt/spring-boot-aws-xray-sample
- https://docs.aws.amazon.com/xray/latest/devguide/xray-sdk-java-aop-spring.html

### 5. Caching
**We'll use the `cache` project.**

AWS Elasticache
- https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/related-services-choose-between-memorydb-and-redis.html
- https://blog.devgenius.io/aws-elastic-redis-cache-with-springboot-98c3ebcc6036

### 6. Object storage
**We'll use the `blob` project.**

AWS S3
- https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html
- https://medium.com/javarevisited/spring-boot-with-aws-s3-bucket-from-zero-to-useful-c0895ab26aaa

### 7. OAuth2 
**We'll use the `oauth2/client` and `oauth2/resourceserver` projects.**

AWS Cognito
- https://howtodoinjava.com/spring-security/spring-boot-role-based-authentication-with-aws-cognito/
- https://repost.aws/knowledge-center/cognito-user-pools-identity-pools
- https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-verifying-a-jwt.html
- https://docs.aws.amazon.com/cognito/latest/developerguide/logout-endpoint.html

### 8. Messaging
**We'll use the `messaging/producer` and `messaging/consumer` projects.**

AWS SQS/SNS
- https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html
- https://docs.aws.amazon.com/sns/latest/dg/welcome.html
- https://spring.io/projects/spring-cloud-stream
- https://ably.com/topic/aws-sns-vs-sqs
