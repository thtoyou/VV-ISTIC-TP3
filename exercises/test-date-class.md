# Test the Date class

Implement a class `Date` with the interface shown below:

```java
//class Date implements Comparable<Date> {
//
//    public Date(int day, int month, int year) { ... }
//
//    public static boolean isValidDate(int day, int month, int year) { ... }
//
//    public static boolean isLeapYear(int year) { ... }
//
//    public Date nextDate() { ... }
//
//    public Date previousDate { ... }
//
//    public int compareTo(Date other) { ... }
//
//}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.


    Method isValidDate : 
        caracteristic : Day value ; blocs : <0, 0, >=1 et <=max(mois, année), >max(mois, année)

                        month value ; blocs : <=0, 1, 2,biggerThan2AndLessThan12, >12 
 
                        year value ; blocs :  <=0 ,année bissextile valide, année "normale" valide
            

    Method isLeapYear : 
        caracteristic : IsYearValueDividedBy4 ; blocs : True , false 
                        isYearValueNotDividedBy100 ; blocs : True , false 
                        isDividedBY400 ; blocs : True , false 


    Method nextDate :
        caracteristic : IsLastDayOfMonth ; blocs : True , false 


    Method previousDate : 
        caracteristic : IsFirstDayOfMonth ; blocs : True , false 


    Method compareTo : 
        caracteristic : IsDate1EqualToDate2 ; blocs : True , false 

 There is no common caracteristics for differents methods in our case. 

2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer


2. On a commencé par tester les happy path 'happyPath', au début la couverture initiale était 100% des méthodes
   et 59% des lignes de code. on a créer d'autres cas de tests, qui nous ont permis de couvrir plus de lignes
   en rajoutant des nouveaux input qui n'appartient pas au happy path, et aussi qui nous a conduit a corriger nos méthodes
   à cause de l'échec de certains tests.
   ![](/home/raouf/Pictures/Screenshots/question2ClassDateCoverage.png)

3. Une méthode comporte un prédicat qui utilise plus de 2 opérateurs booléens:
   isLeapYear() Elle doit tenir compte de toute combinaison de valeurs de vérité de toutes les clauses et garantir
   toutes les valeurs possibles pour le prédicat. En réalisant l'analyse de chaque expression et des combinaisons possibles,
   il est ressorti qu'il faut tester absolument 3 cas: a) une année multiple de 4, non multiple de 100 ,
   non multiple de 400.(exemple: 1992) b) une année multiple de 4, multiple de 100, multiple de 400.(exemple: 2000) c)
   une année non multiple de 4, non multiple de 100 non multiple de 400.(exemple: 2021) Les cas de test de a)
   (isLeapYearLogicCoverage) et b) (isLeapYearLogicCoverage2) ont été ajoutés.
   Par contre le cas c était déjà testé initialement donc pas besoin d'ajouter un test ici.

4. Au début on avait les résultats suivant: couverture des lignes = 72% mutants générés = 54,
   mutation killed = 59%.
   En rajoutant des méthodes dans notre code on a pu augmenter les chiffres, couverture des lignes = 93% 
mutants générés = 89, mutation killed = 83%.