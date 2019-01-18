#!/usr/bin/env bash


# see also dir dirname basename
project=$(pwd)

echo ${project}


init-minikube() {
    minikube version
    minikube start --memory 8192 --cpus=4
#    minikube config set memory 8192
#    minikube config set cpus 4
}


init-kubernetes() {
    kubectl apply -f ${project}/infrastructure/cassandra.yml
    kubectl apply -f ${project}/infrastructure/redis.yml
}

