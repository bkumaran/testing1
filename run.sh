#!/usr/bin/env bash
set -e

./deploy-local.sh

pushd /usr/local/flipkart/fk-poseidon-testsomething
JAR=$(ls api-*.jar | tail -n1)
ln -s $JAR "api.jar" || true
popd

APP_ARGS="-Xloggc:$LOGS/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=3 -XX:GCLogFileSize=100M -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -XX:MaxPermSize=1024m -XX:+UseG1GC -Xms4096m -Xmx4096m -Dcom.sun.management.jmxremote.port=3335 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -XX:-OmitStackTraceInFastThrow -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

java ${APP_ARGS} -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -cp "/usr/local/flipkart/fk-poseidon-testsomething/api.jar:/usr/local/flipkart/fk-poseidon-testsomething/lib/*:/usr/local/flipkart/fk-poseidon-testsomething/resources" -Dlogback.configurationFile=/usr/local/flipkart/fk-poseidon-testsomething/resources/external/logback.xml com.flipkart.poseidon.Poseidon /usr/local/flipkart/fk-poseidon-testsomething/resources/external/bootstrap.xml
