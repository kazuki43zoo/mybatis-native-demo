# Requirements

Requirements of this demo application are follows:

* Docker
* GraalVM 22.3+
* JDK 17+
* Spring Boot 3
* MyBatis Spring Boot 3.0.1+

# Samples

* Writing SQLs on annotation
* Writing SQLs on XML file

# How to build

Start docker container for building native image.

```
docker run -v $(pwd):/work -v $HOME/.m2:/root/.m2 -it -w /work \
  -e JAVA_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e GRAALVM_HOME=/opt/graalvm-ce-java17-22.3.2 \
  -e LANG=C.utf8　\
  ghcr.io/graalvm/graalvm-ce:22.3.2 bash
```

Build a native image.

```
./mvnw -Pnative clean native:compile
```

# Hot to run

Run the native image.

```
./target/mybatis-native-demo -Djavax.xml.accessExternalDTD=all
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

2023-05-08T18:22:46.044Z  INFO 2383 --- [           main] c.e.nativedemo.NativeDemoApplication     : Starting AOT-processed NativeDemoApplication using Java 17.0.7 with PID 2383 (/work/target/mybatis-native-demo started by root in /work)
2023-05-08T18:22:46.044Z  INFO 2383 --- [           main] c.e.nativedemo.NativeDemoApplication     : No active profile set, falling back to 1 default profile: "default"
2023-05-08T18:22:46.060Z  INFO 2383 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-08T18:22:46.065Z  INFO 2383 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:649c2bb8-f60b-4e7c-9f01-6a1ed37721d1 user=SA
2023-05-08T18:22:46.066Z  INFO 2383 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-08T18:22:46.131Z  INFO 2383 --- [           main] c.e.nativedemo.NativeDemoApplication     : Started NativeDemoApplication in 0.147 seconds (process running for 0.155)
Message[id=1, message=Hello World on run!]
Message[id=2, message=Hello World! on runWithXmlMapper]
2023-05-08T18:22:46.136Z  INFO 2383 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-08T18:22:46.136Z  INFO 2383 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
