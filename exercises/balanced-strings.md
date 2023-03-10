# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

question 1 : For the input of type String, the caracteristics are : Length,Vocabulary,Balanced,number of pairsFor each of them we can describe the domains that could trigger a diferent response from our system. Length = 0 ; length != 0; The presence of characters which are not in our alphabet : True or FalseIs our String balanced : true or false The number of pairs : 0, [1,100],[100,1000],[1000, 10 000] ...we will try to run tests with inputs reaching every of the blocs.

Question 2 : by running the tests on our code, we got 100% class coverage (1/1) 100% method coverage (3/3) and 92% line coverage (22/24) this can be improved by adding new cases to reach unused code (here, some return false scenarios). But all the blocs were tested at least once. 
Question 3 : Error in the question, we already applied Base choice Coverage. 

Question 4: as adviced by Oscar, we rewrote our code to remove the recursive aspect. By doing so, our mutation score went down from 95% to 80%. we then found mistakes in our code and added some test cases : Only one opening tag and only one closing tag. To achieve 100% mutation score we implemented one more test case : the balanced with a mismatch (one closing tag replace by another one) 