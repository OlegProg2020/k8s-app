# k8s-app
Example of application working with a database in a kubernetes cluster

#### 1) Скопируйте приложение:
```
git clone https://github.com/OlegProg2020/k8s-app.git
```
#### 2) Перейдите в корневую папку проекта.
#### 3) Создайте k8s cluster. В примере для этого используется minikube.
```
minikube start
```
#### 4) Создайте ConfigMap, PersistentVolume, PersistentVolumeClaim, Deployment и Service для базы данных.
```
kubectl apply -f k8s-app-db-deployment.yaml
```
#### 5) Узнайте IP адрес Service базы данных в кластере (CLUSTER-IP в таблице).
```
kubectl get services
```
#### 6) Подставьте значение найденного IP адреса вместо 10.110.188.127 на 8ой строчке файла k8s-app-backend-deployment.yaml.
#### 7) Создайте ConfigMap и Deployment для приложения.
```
kubectl apply -f k8s-app-backend-deployment.yaml
```
#### 8) Узнайте имя pod'а с запущенным приложением.
```
kubectl get pods
```
#### 9) Настройте проброс портов. Замените pod/k8s-app-deployment-86f5b89fc4-v8gl2 на ваше значение.
```
kubectl port-forward pod/k8s-app-deployment-86f5b89fc4-v8gl2 8080:8080
```
#### 10) Попробуйте выполнить GET request localhost:8080/accounts/info. Вы получите значения url, username и password из application.yaml.
