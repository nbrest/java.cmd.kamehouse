#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################

CURRENT_DIR=$(pwd)
if [[ $0 == /* ]]; then 
  SCRIPT_DIR=$(dirname $0)
else 
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))
fi
source ${SCRIPT_DIR}/functions.sh
APP_NAME=$(getAppName)

cd ${SCRIPT_DIR}/..

target/${APP_NAME}/bin/${APP_NAME}.sh "$@"

cd ${CURRENT_DIR}