# Stack JUnit test

Case                    | Type 0 | Type 1
------------------------|--------|--------:
1.) newStackIsEmpty     |        |
2.) testPushNull        |        |    x
3.) testPopAllElement   |        |
4.) testPeek            |        |    x
5.) testSize            |        |    x
6.) TestStackIsFull     |        |    x
7.) testCapacity        |        |
8.) testOverFlow        |    x   |    x
9.) testPopEmptyStack   |        |

Method                  | Type 0 | Type 1
------------------------|--------|--------:
1.) pop()               |        |
2.) peek()              |        |    x
3.) push()              |    x   |    x
4.) isEmpty()           |        |    
5.) isFull()            |        |    x
6.) capacity()          |        |    
7.) size()              |        |    x


'x' is a marker for checking which type in StackFactory is a failure.

## Author
* **Patinya Yongyai**
