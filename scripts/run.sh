#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################

CURRENT_DIR=$(pwd)
SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))
source ${SCRIPT_DIR}/functions.sh
APP_NAME=$(getAppName)

cd ${SCRIPT_DIR}/..

target/${APP_NAME}/bin/${APP_NAME}.sh "$@"

cd ${CURRENT_DIR}