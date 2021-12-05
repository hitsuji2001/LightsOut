#!/bin/bash

AppRunning=1
SRC_FILE="src/assetloader/map/*.java src/mapgen/tile/*.java src/mapgen/tile/manager/*.java src/mapgen/tile/interfaces/*.java src/mapgen/tile/tile_lists/*.java src/assetloader/animation/*.java src/assetloader/sprite/*.java src/entity/enemy/*.java src/game/*.java src/mapgen/*.java src/entity/*.java src/window/*.java src/main/*.java"
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
