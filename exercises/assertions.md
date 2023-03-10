# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
Question 1 : The assertions "assertTrue(3 * .4 == 1.2)" fails since we are comparing floats and testing a float equality is always going to be flaky since those number will be rounded. Instead, we should test with a margin of error like assertTrue((3 * .4) - 1.2))<=0.001with the precision of the assert being adjustable depending of our needs. Or we can use the AssertEquals(float,float,precision) already implemented in Junit.

Question 2 : assertEqual is used to compare the values of two objects to determine if they are equal. It compares the content or state of the objects being tested. If the values are not equal, the test will fail.assertSame is used to compare the object references to determine if they refer to the same object in memory. It compares the identity or memory location of the objects being tested. If the object references are not the same, the test will fail. 
example : 
String str1 = "hello";String str2 = new String("hello");String str3 = str1; assertEquals(str1, str2); // this will pass because the contents are equalassertEquals(str1, str3); // this will pass because the contents are equal assertSame(str1, str2); // this will fail because they are different objects in memory assertSame(str1, str3); // this will pass because they are the same object in memory

Question 3 : Fail can be used as a TODO for test cases whe they are not yet implmented : fail("todo")Other use of the fail method :  when the code doesn't return/break when expected like in :@Test
public void returnBefore() {
    int value = randomInteger();
    for (int i = 0; i < 5; i++) {
        // returns when (value + i) is an even number
        if ((i + value) % 2 == 0) {
            return;
        }
    }
    fail("Should have returned before");
}

Question 4 : The '@Test' annotation is already used before every test case. It is clearer if each annotation have one and only one meaning. 