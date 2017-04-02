#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################
# parameters: maven options

CURRENT_DIR=$(pwd)
SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))
source ${SCRIPT_DIR}/functions.sh

function main() {

  cd ${SCRIPT_DIR}/..

  createExecScript
  updateLogConfigFile
  MAVEN_OPTIONS="$@"
  
  echo "Compiling the project with the parameters: ${MAVEN_OPTIONS}"
  mvn clean package ${MAVEN_OPTIONS}

  cd ${CURRENT_DIR}
}

main "$@"
