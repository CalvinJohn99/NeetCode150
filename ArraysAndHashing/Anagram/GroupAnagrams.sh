#!/bin/bash
javac GroupAnagrams.java
echo "Test1: "
java Solution "act", "pots", "tops", "cat", "stop", "hat"
echo "Test2: "
java Solution "x"
echo "Test3: "
java Solution ""
