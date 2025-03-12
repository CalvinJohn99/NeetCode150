#!/bin/bash
javac ThreeSum.java
echo "Test1: "
java Solution -1 0 1 2 -1 -4
# x -4 -1 -1 0 1 2
echo "Test2: "
java Solution 0 1 1
echo "Test3: "
java Solution 0 0 0