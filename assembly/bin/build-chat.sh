#!/usr/bin/env bash

sbinDir=$(cd "$(dirname "$0")"; pwd)
baseDir=$(cd "$sbinDir/.." && pwd -P)
runtimeDir=$baseDir/runtime
buildDir=$baseDir/build

cd $baseDir

#1. move package to build
cp $baseDir/../launchers/chat/target/*.tar.gz ${buildDir}/supersonic-chat.tar.gz

