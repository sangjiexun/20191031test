#!/bin/bash

TOMCAT_LOG_DIR="/var/log/tomcat7"

i=2
while [ $i -lt 7 ];
do
    find $TOMCAT_LOG_DIR -type f -name "catalina.out.`date -d "$i days ago" +%Y-%m-%d`" | xargs --no-run-if-empty gzip
    i=`expr $i + 1`
done

exit 0
