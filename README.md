# liquibase-spring
More control over spring-liquibase

How to run

Connect to oracle DB, I am using docker image locally.

Build jar using `./gradlew bootJar`

Run this jar normally to start web application

## Run with special args to skip web application and run liquibase

`java -jar -Dspring.main.web-application-type=NONE build/libs/liquibase-0.0.1-SNAPSHOT.jar <command>`

command here is `updateSQL`, `update` and `dropAll`
