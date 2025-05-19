# Kafka Microservices Example

This project demonstrates a simple Kafka-based microservices setup with two services:

- **Producer Service** (Main Service)  
  - Runs on **port 3000**  
  - Sends string messages to Kafka topic `reqbox`  

- **Reverse Service** (Consumer Service)  
  - Runs on **port 8080**  
  - Listens on Kafka topic `reqbox`  
  - Reverses incoming strings  
  - Sends reversed strings to Kafka topic `ansbox`  

- **Answer Consumer Service** (Optional)  
  - Listens on Kafka topic `ansbox`  
  - Prints reversed strings to console  

## How it works

1. Producer sends a string message to Kafka topic `reqbox`.  
2. Reverse service consumes the message, reverses the string, and sends it to topic `ansbox`.  
3. Answer consumer service consumes the reversed string and logs it.  

## Running the Services

- Start Kafka and Zookeeper locally or connect to a Kafka cluster.  
- Run the **Producer service** on port `3000`.  
- Run the **Reverse service** on port `8080`.  
- Optionally, run the answer consumer service to see reversed strings printed.  

## Example API Call

Send a message from producer service:

