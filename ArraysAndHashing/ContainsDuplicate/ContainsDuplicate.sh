#!/bin/bash
javac ContainsDuplicate.java
echo "Test 1:"
java Solution 1 2 3 4 5
echo "Test 2:"
java Solution 10 20 20
echo "Test 3:"
java Solution -1 -2 -3 0 5
