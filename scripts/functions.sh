function getAppName() {

  CURRENT_DIR=$(pwd)
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))

  cd ${SCRIPT_DIR}/..

  local APP_NAME=$(cat pom.xml | grep artifactId | head -n 1 | sed 's/<\/\?[^>]\+>//g' | tr -d '[:space:]')

  echo ${APP_NAME}

  cd ${CURRENT_DIR}
}

function getAppVersion() {

  CURRENT_DIR=$(pwd)
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))

  cd ${SCRIPT_DIR}/..

  local APP_VERSION=$(cat pom.xml | grep version | head -n 1 | sed 's/<\/\?[^>]\+>//g' | tr -d '[:space:]')

  echo ${APP_VERSION}

  cd ${CURRENT_DIR}
}

function createExecScript() {
  
  CURRENT_DIR=$(pwd)
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))

  cd ${SCRIPT_DIR}/..
  
  local APP_NAME=$(getAppName)
  local APP_VERSION=$(getAppVersion)
  
  cp ${SCRIPT_DIR}/base-app-template.sh bin/${APP_NAME}.sh
  
  sed -i.bak s/base-app/${APP_NAME}/g bin/${APP_NAME}.sh
  sed -i.bak s/0\.0\.1-SNAPSHOT/${APP_VERSION}/g bin/${APP_NAME}.sh
  
  rm -f bin/${APP_NAME}.sh.bak 
  
  cd ${CURRENT_DIR}
}

function updateLogConfigFile() {
  
  CURRENT_DIR=$(pwd)
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))

  cd ${SCRIPT_DIR}/..
  
  local APP_NAME=$(getAppName)  
  
  sed -i.bak s/base-app/${APP_NAME}/g src/main/resources/logback.xml
  
  rm -f src/main/resources/logback.xml.bak 
  
  cd ${CURRENT_DIR}
}