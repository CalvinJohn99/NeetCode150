#/bin/bash
javac ValidParentheses.java
echo "Test1: "
java Solution "[]"
echo "Test2: "
java Solution "([{}])"
echo "Test3: "
Java Solution "[(])"