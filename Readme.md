# 🚀 Spring Kafka Working Test

A simple **Spring Boot + Apache Kafka** project demonstrating **Producer and Consumer communication using JSON messages**.

---

## 📌 Features

* ✅ Kafka Producer (Send JSON messages)
* ✅ Kafka Consumer (Receive JSON messages)
* ✅ Spring Boot Integration
* ✅ REST API to publish messages
* ✅ JSON Serialization & Deserialization
* ✅ Logging with SLF4J

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Spring Kafka
* Apache Kafka
* Maven

---

## ⚙️ Project Structure

```
src/main/java/com/spring_kafka/workingTest
│
├── config          # Kafka Configuration
├── controller      # REST API Controller
├── kafka           # Producer & Consumer
├── payload         # DTO (User class)
└── WorkingTestApplication.java
```

---

## ⚡ Kafka Setup (Local)

### Step 1: Start Zookeeper

```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

### Step 2: Start Kafka

```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

---

## 📨 API Endpoint

### Send JSON Message

```http
POST /api/v1/kafka/publish/json
```

### Sample Request Body

```json
{
  "id": 1,
  "firstName": "firstname",
  "lastName": "lastname"
}
```

---

## 🔄 Kafka Flow

```
REST API → Producer → Kafka Topic → Consumer → Console Log
```

---

## 📄 Configuration (`application.properties`)

```properties
# Consumer
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=myGroup
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*

# Producer
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
```

---

## 📥 Consumer Example

```java
@KafkaListener(topics = "javaTopic_json", groupId = "myGroup")
public void consume(User user){
    LOGGER.info("Json message received -> {}", user);
}
```

---

## 📤 Producer Example

```java
kafkaTemplate.send("javaTopic_json", user);
```

---

## ⚠️ Common Issues & Fixes

| Issue                  | Fix                              |
| ---------------------- | -------------------------------- |
| Kafka not starting     | Clear `kafka-logs` & restart     |
| NodeExistsException    | Clear Zookeeper data             |
| JsonDeserializer error | Add `jackson-databind`           |
| Serializer error       | Use `JsonSerializer` in producer |
| Message not consumed   | Check topic name                 |

---

## 📦 Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🧠 Learning Outcome

* Kafka Producer/Consumer basics
* JSON message handling
* Spring Kafka configuration
* Debugging Kafka issues on Windows

---

## 🙌 Author

**Satyajit Bhosale**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!

---