#!/bin/bash
javac TopKFrequentElements.java -Xlint
echo "Test1: "
java Solution 1 2 2 3 3 3 2
echo "Test2: "
java Solution 7 7 1