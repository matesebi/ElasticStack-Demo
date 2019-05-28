# ElasticStack-Demo
Repository For Elastic Stack demo

# ElasticSearch launch

`sudo sysctl -w vm.max_map_count=262144`

add ingest pipeline

`curl -H 'Content-Type: application/json' -XPUT 'http://localhost:9200/_ingest/pipeline/mol-ingest-pipeline' -d@mol-ingest-pipeline.json`


# Filebeat

`chmod go-w filebeat.yml`

`chmod go-w filebeat-config/java-default.yml`

# apm server

`chmod go-w apm-server.yml`
