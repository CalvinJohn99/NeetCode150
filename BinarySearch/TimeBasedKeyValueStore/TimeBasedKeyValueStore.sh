#!/bin/bash
javac TimeBasedKeyValueStore.java
echo "Test1: "
java TimeMap "set" "["alice", "happy", 1]" "get" "["alice", 1]" "get" "["alice", 2]" "set" "["alice", "sad", 3]" "get" "["alice", 3]"
echo "Test2: "
java TimeMap "set" "["check", "one", 5]" "set" "["check", "two", 10]" "get" "["check", 7]" "get" "["nonexistent", 7]"
