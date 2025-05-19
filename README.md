# Kafka Microservices Example

## Main Service (Producer)

- Runs on **http://localhost:3000**  
- Endpoint: `POST /kafka`  
- Sends messages to Kafka topic `reqbox` via query parameter

**Example API call:**

POST http://localhost:3000/kafka?message=blahblah4


This sends the `message` parameter to the Kafka topic `reqbox`.

---

## Microservice Flow

1. The **Main Service** receives an HTTP request with a message parameter and sends it to Kafka topic `reqbox`.  
2. The **Reverse Service** (consumer running on port 8080) listens to `reqbox`, reverses the string, and publishes it to `ansbox`.  
3. The **Main Service** listens on `ansbox` and prints the reversed message.

---

This setup demonstrates a simple Kafka-based message processing pipeline with a clear producer-consumer flow.
