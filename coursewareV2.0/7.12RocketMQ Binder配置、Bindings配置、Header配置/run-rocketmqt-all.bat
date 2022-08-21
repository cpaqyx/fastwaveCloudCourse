cd D:\java\rocketmq-all-4.6.0-bin-release\bin
start mqnamesrv.cmd -c namesrv.properties
start mqbroker.cmd -n 127.0.0.1:9877 autoCreateTopicEnable=true

timeout /T 3 /NOBREAK

cd D:\java\rocketmq-externals-rocketmq-console-1.0.0\rocketmq-console\target
java -jar rocketmq-console-ng-1.0.0.jar --server.port=12581 --rocketmq.config.namesrvAddr=127.0.0.1:9877
