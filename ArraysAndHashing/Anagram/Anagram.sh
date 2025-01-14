#!/bin/bash
javac Anagram.java
echo "Test 1:"
java Solution "racecar" "carrace"
echo "Test 2:"
java Solution "cat" "dog"
