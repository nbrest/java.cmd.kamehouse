#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################
# parameters: compiler='compiler-parameters' run='runtime-parameters'
# > ./build-install-run.sh compiler='compiler-parameters' run='run-parameters'

# This script builds with compiler parameters and runs the application with run parameters.

CURRENT_DIR=$(pwd)
if [[ $0 == /* ]]; then 
  SCRIPT_DIR=$(dirname $0)
else 
  SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))
fi

COMPILER_PARAMETERS=""
RUN_PARAMETERS=""

function main() {

  cd ${SCRIPT_DIR}/..

  parseParameters "$@"
  scripts/build-install.sh ${COMPILER_PARAMETERS}
  scripts/run.sh ${RUN_PARAMETERS}

  cd ${CURRENT_DIR}
}

function parseParameters() {

  COMPILER_PARAMETERS="$1"
  RUN_PARAMETERS="$2"
  
  COMPILER_PARAMETERS=${COMPILER_PARAMETERS#"compiler="}
  RUN_PARAMETERS=${RUN_PARAMETERS#"run="}
}

main "$@"
