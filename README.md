### Content I used

* https://www.freblogg.com/kafka-storage-internals
* https://www.confluent.io/blog/okay-store-data-apache-kafka/
* https://www.linkedin.com/learning/learn-apache-kafka-for-beginners

### Experiments commands

1. Install and run Kafka https://medium.com/@Ankitthakur/apache-kafka-installation-on-mac-using-homebrew-a367cdefd273
2. Create topic `kafka-topics --create --replication-factor 1 --partitions 1 --topic test --bootstrap-server localhost:9092`
3. Send by key `kafka-console-producer --broker-list localhost:9092 --topic test --property parse.key=true --property key.separator=:` > key1:123

More partitions: `kafka-console-producer --broker-list localhost:9092 --topic test-double-partition --property parse.key=true --property key.separator=:`
Consumers to be like: `kafka-console-consumer --bootstrap-server localhost:9092 --topic test-double-partition --property print.key=true --partition=0`