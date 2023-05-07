# Requirements

Requirements of this demo application are follows:

* Docker
* GraalVM 22.3+
* JDK 17+
* Spring Boot 3
* MyBatis Spring Boot 3.0.1+

# How to build

Start docker container for building native image.

```
docker run -v $(pwd):/work -v $HOME/.m2:/root/.m2 -it -w /work \
  -e JAVA_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e GRAALVM_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e LANG=C.utf8　\
  ghcr.io/graalvm/graalvm-ce:22.3.2 bash
```

```
./mvnw -Pnative clean native:compile
```

# Hot to run

Run the native image.

```
./target/mybatis-native-demo
```

Print as following logs if building was success.

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)

2023-05-07T12:15:41.926Z  INFO 23 --- [           main] c.e.nativedemo.NativeDemoApplication     : Starting AOT-processed NativeDemoApplication using Java 17.0.7 with PID 23 (/work/target/mybatis-native-demo started by root in /work)
2023-05-07T12:15:41.926Z  INFO 23 --- [           main] c.e.nativedemo.NativeDemoApplication     : No active profile set, falling back to 1 default profile: "default"
2023-05-07T12:15:41.936Z  INFO 23 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-07T12:15:41.940Z  INFO 23 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:7873c044-cc2a-4713-b643-573a31021516 user=SA
2023-05-07T12:15:41.940Z  INFO 23 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-07T12:15:41.953Z  INFO 23 --- [           main] c.e.nativedemo.NativeDemoApplication     : Started NativeDemoApplication in 0.067 seconds (process running for 0.072)
Message[id=1, message=Hello World!]
2023-05-07T12:15:41.956Z  INFO 23 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-07T12:15:41.956Z  INFO 23 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
