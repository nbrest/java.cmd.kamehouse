#!/bin/bash
#########################################################
# These are develompment scripts meant to be used while #
# developing, testing and building the application.     #
#########################################################
# parameters: maven options

# This script builds with compiler parameters and runs the application without runtime parameters.
# To compile and run the application with parameters, use the script build-install-run-params.sh

CURRENT_DIR=$(pwd)
SCRIPT_DIR=$(dirname $(echo $(pwd)/$0))

cd ${SCRIPT_DIR}/..

scripts/build-install.sh "$@"
scripts/run.sh

cd ${CURRENT_DIR}
