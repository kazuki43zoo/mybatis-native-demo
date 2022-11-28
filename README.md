# Requirements

Requirements of this demo application are follows:

* Docker
* GraalVM 22.3+
* JDK 17+
* Spring Boot 3
* MyBatis Spring Boot 3.0.1-SNAPSHOT + (Not release yet)

# How to build

Start docker container for building native image.

```
docker run -v $(pwd):/work -v $HOME/.m2:/root/.m2 -it -w /work \
  -e JAVA_HOME=/opt/graalvm-ce-java17-22.3.0 \
  -e GRAALVM_HOME=/opt/graalvm-ce-java17-22.3.0 \
  -e LANG=C.utf8　\
  ghcr.io/graalvm/graalvm-ce:22.3.0 bash
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
 :: Spring Boot ::                (v3.0.0)

2022-11-28T00:28:25.613Z  INFO 1066 --- [           main] c.e.nativedemo.NativeDemoApplication     : Starting AOT-processed NativeDemoApplication using Java 17.0.5 with PID 1066 (/work/target/mybatis-native-demo started by root in /work)
2022-11-28T00:28:25.613Z  INFO 1066 --- [           main] c.e.nativedemo.NativeDemoApplication     : No active profile set, falling back to 1 default profile: "default"
2022-11-28T00:28:25.624Z  INFO 1066 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-11-28T00:28:25.627Z  INFO 1066 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:6071f201-b520-4724-a5af-4909be2349fc user=SA
2022-11-28T00:28:25.627Z  INFO 1066 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-11-28T00:28:25.637Z  INFO 1066 --- [           main] c.e.nativedemo.NativeDemoApplication     : Started NativeDemoApplication in 0.058 seconds (process running for 0.062)
Message[id=1, message=Hello World!]
2022-11-28T00:28:25.639Z  INFO 1066 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-11-28T00:28:25.639Z  INFO 1066 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```