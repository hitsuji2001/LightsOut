#!/bin/bash

AppRunning=1
SRC_FILE="src/assetloader/*.java src/game/*.java src/mapgen/*.java src/entity/*.java src/window/*.java src/main/*.java"
CLS_FILE="bin/"

while [ $AppRunning == 1 ]; do
  echo "Compiling..."

  #Compile the project
  javac $SRC_FILE -d bin/

  if [ $? -ne 0 ]
  then
    echo "ERROR: Compile failed"
    exit 1
  else
    java -cp $CLS_FILE main.Main
    exit 0
  fi
done
