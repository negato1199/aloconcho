#!/bin/bash
LABEL=$(date +'%Y%m%d-%H%M%S')
mvn clean package && docker build -t com.axonactive.training/fusal_management:$LABEL .
docker rm -f fusal_management || true && docker run -it -p 8080:8080 -p 4848:4848 --name fusal_management com.axonactive.training/fusal_management:$LABEL

