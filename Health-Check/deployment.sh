#Create the nginx-app pods and expose the service
kubectl apply -f nginx-app.yaml

kubectl expose deployment nginx-app --type=ClusterIP --name=nginx-app-service-cluster-ip
kubectl expose deployment nginx-app --type=NodePort --name=nginx-service-nodeport
kubectl expose deployment nginx-app --type=LoadBalancer --name=nginx-service-loadbalancer

#apply the probe with guide from
#https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/
#found in liveness.yaml
kubectl apply -f liveness.yaml

#check status
kubectl describe pod liveness
