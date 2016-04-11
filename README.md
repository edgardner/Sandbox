# Sandbox
Temporary repo for sharing with folks

This repository contains two files:
- pardottest
- Debugging_test

#Pardottest - Java - JRE 1.8.0_66
To use this you will need to bring the package into your working set.  From there enter Main.java and complete the secret(int inputValue) method stub with a function of your choice.  The only caveat is that it must output an integer.  After secret() has been filled out run Main.java.  The console will prompt you to enter an integer, it will then output the primes less than this integer and let you know if secret() is distributive on the prime array. Pardottest contains 3 Java classes Main.java, FindPrimes.java, and TestFindPrimes.java:

- Main.java:
Used to handle simple console input/output and check if secret() is distributive

- FindPrimes.java:
Used to track primes lower than a given input bound.  Implements a prime sieve as its primary function.

- TestFindPrimes.java:
Tests FindPrimes.java sieving engine.

#Debugging_test - Python
TweetBot's problems were that it did no input string validation and didn't respect Twitters duplicate tweet rules.  To correct the exceptions from Twython I implemented logic to check that the first character of the line is alphanumeric and that the string isn't longer than 140 characters.  I implemented an array to hold previous tweets, this way TweetBot can check to see if it already sent those tweet's and thus ignore that status update. 


