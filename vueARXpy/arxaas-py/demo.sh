
## kill any process using spring-boot port
#sudo kill -9 $(sudo lsof -t -i:8080)

java -jar ../arxaas/target/arxaas-0.0.0-RELEASE.jar &

python3 samples/notebooks/example_anonymization_with_k4.py
