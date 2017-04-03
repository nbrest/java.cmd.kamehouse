#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################
# parameters: maven options

CURRENT_DIR=$(pwd)
if [[ $0 == /* ]]; then 
  SCRIPT_DIR=$(dirname $0)
else 
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))
fi
source ${SCRIPT_DIR}/functions.sh
APP_NAME=$(getAppName)

cd ${SCRIPT_DIR}/..

scripts/build.sh "$@"

unzip target/${APP_NAME}-bundle.zip -d target/ 

cd ${CURRENT_DIR}

