# Experiment 12 – Selenium Testing of a Containerized Application

## 1. Check Software Installations

```powershell
docker --version
docker ps
java -version
mvn -version
kubectl version --client
kubectl get nodes
```

## 2. Check Kubernetes Resources

```powershell
kubectl get pods
kubectl get deployments
kubectl get services
```

Check that these resources are available:
- kubernetes-docker-deployment
- kubernetes-docker-service

## 3. Start Application Connection – Terminal 1

```powershell
kubectl port-forward service/kubernetes-docker-service 8081:80
```

Keep this terminal open.

## 4. Open Application in Chrome

```text
http://localhost:8081
```

Expected output:

**Hello from Docker and Kubernetes!**

This application is running inside a Kubernetes pod.

## 5. Execute Selenium Tests – Terminal 2

Open a second terminal in the project folder containing pom.xml.

```powershell
mvn clean test
```

## 6. Expected Test Results

```text
Tests run: 2
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## 7. View Test Reports

```powershell
Get-Content .\target\surefire-reports\*.txt
```

## Important Notes

1. Docker Desktop must be running.
2. Java 21 and Maven must be installed.
3. Kubernetes cluster must be running.
4. The required application deployment and service must exist.
5. Keep Terminal 1 running while executing Maven in Terminal 2.
6. Open this guide whenever you need the execution commands.
