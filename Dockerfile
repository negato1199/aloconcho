FROM payara/micro
COPY ./target/fusal_management.war $DEPLOY_DIR
