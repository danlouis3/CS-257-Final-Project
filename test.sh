#!/bin/sh

rm -rf ./bin
mkdir bin
find ./src -name *.java | xargs javac -d ./bin 
cp -r ./src/blockdude/resources ./bin/blockdude
cd ./bin && java blockdude.MainApp
