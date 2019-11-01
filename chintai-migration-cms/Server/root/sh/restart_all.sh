#!/bin/bash

service tomcat7 stop

rm -Rf /var/lib/tomcat7/webapps/sysadmin/
mkdir /var/lib/tomcat7/webapps/sysadmin/
cp -Rp /home/ctadm03/work/chintai-migration-cms.war /var/lib/tomcat7/webapps/sysadmin/
cd /var/lib/tomcat7/webapps/sysadmin/
jar xvf /var/lib/tomcat7/webapps/sysadmin/chintai-migration-cms.war
chown -R tomcat:tomcat /var/lib/tomcat7/webapps/sysadmin/
mv healthcheck.html_offline healthcheck.html

#ŠÂ‹«‚É‡‚í‚¹‚Äİ’è
#cd /var/lib/tomcat7/webapps/sysadmin/WEB-INF/classes/resources/
#mv server_production.properties server.properties
#mv datasource_production.properties datasource.properties

service tomcat7 start

sleep 50

ps -ef|grep java | cut -c-1000
