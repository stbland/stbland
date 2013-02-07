set WEBAPP_NAME=testvaadintouckit68
set WEBAPP_VERSION=0.0.1-SNAPSHOT
set WEBAPP_DIRECTORY=target/${WEBAPP_NAME}-${WEBAPP_VERSION}
set GAE_HOME=/opt/gae
clear
mvn clean package
rm -r -f $WEBAPP_DIRECTORY/VAADIN/gwt-unitCache
$GAE_HOME/bin/appcfg.sh update $WEBAPP_DIRECTORY
echo http://testvaadintouchkit.stbland.appspot.com/
