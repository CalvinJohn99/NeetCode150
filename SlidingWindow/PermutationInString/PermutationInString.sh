#/bin/bash
javac PermutationInString.java
echo "Test1: "
java Solution "abc" "lecabee"
echo "Test2: "
java Solution "abc" "lecaabee"
echo "Test3: "
java Solution "ab" "ab"