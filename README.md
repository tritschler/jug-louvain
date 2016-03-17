# jug-louvain
<br>Java User Group of Louvain-La-Neuve (Belgium)
<br>
<br>Spring Tool Suite 
<br>Version: 3.7.0.RELEASE
<br>Build Id: 201506290649
<br>Platform: Eclipse Luna SR2 (4.4.2) 
<br>
<br>rudy@m3800:~/bin$ cat dev-starter 
<br>source ~/bin/init-java-8
<br>source ~/bin/init-maven-3
<br>
<br>rudy@m3800:~/bin$ cat init-java-8 
<br>export JAVA_HOME="/home/rudy/softwares/jdk/jdk1.8.0_65"
<br>export PATH=$JAVA_HOME/bin:$PATH:$JAVA_HOME/bin
<br>
<br>rudy@m3800:~/bin$ cat init-maven-3 
<br>export MAVEN_HOME="/home/rudy/softwares/apache-maven-3.2.5"
<br>export PATH=$MAVEN_HOME/bin:$PATH
<br>
<br>rudy@m3800:~/bin$ ping M3800
<br>PING m3800 (127.0.1.1) 56(84) bytes of data.
<br>64 bytes from m3800 (127.0.1.1): icmp_seq=1 ttl=64 time=0.014 ms
<br>
<br>https://www.getpostman.com/docs/
<br>
<br>First example : spring boot + controller
<br>mvn clean + package
<br>run com.rudyvissers.example1.Application.main()
<br>
<br>from postman:
<br>GET localhost:8080/
<br>Greetings from Spring Boot!
<br>
<br>from postman:
<br>GET localhost:8080/env
<br>{
<br>  "profiles": [],
<br>  "server.ports": {
<br>    "local.server.port": 8080
<br>  },
<br>  "servletContextInitParams": {},
<br>  "systemProperties": {
<br>    "java.runtime.name": "Java(TM) SE Runtime Environment",
<br>    "sun.boot.library.path": "/home/rudy/softwares/jdk/jdk1.8.0_65/jre/lib/amd64",
<br>    "java.vm.version": "25.65-b01",
<br>    "java.vm.vendor": "Oracle Corporation",
<br>    "java.vendor.url": "http://java.oracle.com/",
<br>    "path.separator": ":",
<br>    "java.vm.name": "Java HotSpot(TM) 64-Bit Server VM",
<br>    "file.encoding.pkg": "sun.io",
<br>    "user.country": "US",
<br>    "sun.java.launcher": "SUN_STANDARD",
<br>    "sun.os.patch.level": "unknown"
<br>    ...
<br>    
<br>from postman:
<br>GET localhost:8080/health
<br>{
<br>  "status": "UP",
<br>  "diskSpace": {
<br>    "status": "UP",
<br>    "total": 455299137536,
<br>    "free": 25626398720,
<br>    "threshold": 10485760
<br>  }
<br>}
<br>
<br>2nd example : spring boot + controller + model
<br>mvn clean + package
<br>run com.rudyvissers.example2.HelloWorldConfiguration.main()
<br>
<br>from postman:
<br>GET localhost:9000//hello-world
<br>{
<br>  "id": 1,
<br>  "content": "Hello, Stranger!"
<br>}
<br>
<br>3rd example : spring boot + spring cloud (service registry/eureka)
<br>mvn clean + package
<br>run com.rudyvissers.example2.HelloWorldConfiguration.main()
<br>
<br>start eureka
<br>in eureka-service
<br>run registry.Application.main
<br>from browser:
<br>GET localhost:8761/
<br>no servers are registered
<br>
<br>start first eureka client
<br>in example1_eureka
<br>run com.rudyvissers.example1.Application.main()
<br>
<br>start second eureka client
<br>in example2_eureka
<br>run com.rudyvissers.example2.HelloWorldConfiguration.main()
<br>
<br>check now that the 2 servers are registered in eureka
<br>from browser:
<br>GET localhost:8761/
<br>
<br>now from postman:
<br>GET m3800:9000/
<br>Greetings from Spring Boot! id:7 content:Hello, Stranger!
<br>example1 does call example2 using RestTemplate and Ribbon
<br>
<br>from postman:
<br>GET m3800:9010/hello-world
<br>{
<br>  "id": 9,
<br>  "content": "Hello, Stranger!"
<br>}
<br>This was a call to the second controller
<br>
<br>That's all folks !
<br>
<br>rudy@rudyvissers.com - vsolutions.be
<br>
<br>
<br>
<br>
<br>
<br>
