# jug-louvain
Java User Group of Louvain-La-Neuve (Belgium)


Spring Tool Suite 
Version: 3.7.0.RELEASE
Build Id: 201506290649
Platform: Eclipse Luna SR2 (4.4.2) 

rudy@m3800:~/bin$ cat dev-starter 
source ~/bin/init-java-8
source ~/bin/init-maven-3

rudy@m3800:~/bin$ cat init-java-8 
export JAVA_HOME="/home/rudy/softwares/jdk/jdk1.8.0_65"
export PATH=$JAVA_HOME/bin:$PATH:$JAVA_HOME/bin

rudy@m3800:~/bin$ cat init-maven-3 
export MAVEN_HOME="/home/rudy/softwares/apache-maven-3.2.5"
export PATH=$MAVEN_HOME/bin:$PATH

rudy@m3800:~/bin$ ping M3800
PING m3800 (127.0.1.1) 56(84) bytes of data.
64 bytes from m3800 (127.0.1.1): icmp_seq=1 ttl=64 time=0.014 ms

https://www.getpostman.com/docs/

First example : spring boot + controller
mvn clean + package
run com.rudyvissers.example1.Application.main()

from postman:
GET localhost:8080/
Greetings from Spring Boot!

from postman:
GET localhost:8080/env
{
  "profiles": [],
  "server.ports": {
    "local.server.port": 8080
  },
  "servletContextInitParams": {},
  "systemProperties": {
    "java.runtime.name": "Java(TM) SE Runtime Environment",
    "sun.boot.library.path": "/home/rudy/softwares/jdk/jdk1.8.0_65/jre/lib/amd64",
    "java.vm.version": "25.65-b01",
    "java.vm.vendor": "Oracle Corporation",
    "java.vendor.url": "http://java.oracle.com/",
    "path.separator": ":",
    "java.vm.name": "Java HotSpot(TM) 64-Bit Server VM",
    "file.encoding.pkg": "sun.io",
    "user.country": "US",
    "sun.java.launcher": "SUN_STANDARD",
    "sun.os.patch.level": "unknown"
    ...
    
from postman:
GET localhost:8080/health
{
  "status": "UP",
  "diskSpace": {
    "status": "UP",
    "total": 455299137536,
    "free": 25626398720,
    "threshold": 10485760
  }
}

2nd example : spring boot + controller + model
mvn clean + package
run com.rudyvissers.example2.HelloWorldConfiguration.main()

from postman:
GET localhost:9000//hello-world
{
  "id": 1,
  "content": "Hello, Stranger!"
}

3rd example : spring boot + spring cloud (service registry/eureka)
mvn clean + package
run com.rudyvissers.example2.HelloWorldConfiguration.main()

start eureka
in eureka-service
run registry.Application.main
from browser:
GET localhost:8761/
no servers are registered

start first eureka client
in example1_eureka
run com.rudyvissers.example1.Application.main()

start second eureka client
in example2_eureka
run com.rudyvissers.example2.HelloWorldConfiguration.main()

check now that the 2 servers are registered in eureka
from browser:
GET localhost:8761/

now from postman:
GET m3800:9000/
Greetings from Spring Boot! id:7 content:Hello, Stranger!
example1 does call example2 using RestTemplate and Ribbon

from postman:
GET m3800:9010/hello-world
{
  "id": 9,
  "content": "Hello, Stranger!"
}
This was a call to the second controller

That's all folks !

rudy@rudyvissers.com





