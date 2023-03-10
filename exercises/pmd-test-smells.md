# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Question 2 : As discussed in class, a test should test one thing (single responsability) and to do so it should have only a few assertions. The maximum number of assertions is obviously not clearly established but it is a bad smell if a dozen of asserts are in the same test case.  Like in "testChainedClosure()" in the commons.collections4.ClosureUtilsTest.java where 13 asserts are made in the same test. It makes it hard to understand why the test fails. It would gain to be cut in 2 or 3 smaller test cases. Here we cut the test case in half and duplicate it :

public class testExample { 
       @Test    
    @SuppressWarnings("unchecked")
       public void testChainedClosure() { 
        MockClosure<Object> a = new MockClosure<>(); 
        MockClosure<Object> b = new MockClosure<>();
        ClosureUtils.chainedClosure(a, b).execute(null);
        assertEquals(1, a.count);
        assertEquals(1, b.count);
        a = new MockClosure<>();
        b = new MockClosure<>();
        ClosureUtils.<Object>chainedClosure(a, b, a).execute(null);
        assertEquals(2, a.count);
        assertEquals(1, b.count);
        a = new MockClosure<>();
        b = new MockClosure<>();
        final Collection<Closure<Object>> coll = new ArrayList<>();
        coll.add(b);
        coll.add(a);
        coll.add(b);
        ClosureUtils.<Object>chainedClosure(coll).execute(null);
        assertEquals(1, a.count);
        assertEquals(2, b.count);
    }    
    @Test
    @SuppressWarnings("unchecked")
    public void testChainedClosure2() {
    MockClosure<Object> a = new MockClosure<>();
        MockClosure<Object> b = new MockClosure<>();
        ClosureUtils.chainedClosure(a, b).execute(null);
        a = new MockClosure<>();
        b = new MockClosure<>();
        ClosureUtils.<Object>chainedClosure(a, b, a).execute(null);
        a = new MockClosure<>();
        b = new MockClosure<>();
        final Collection<Closure<Object>> coll = new ArrayList<>();
        coll.add(b);
        coll.add(a);
        coll.add(b);
        ClosureUtils.<Object>chainedClosure(coll).execute(null);
        assertSame(NOPClosure.INSTANCE, ClosureUtils.<Object>chainedClosure());
        assertSame(NOPClosure.INSTANCE, ClosureUtils.<Object>chainedClosure(Collections.<Closure<Object>>emptyList()));
        assertAll(
            () -> assertThrows(NullPointerException.class,
            () -> ClosureUtils.chainedClosure(null, null)),
            () -> assertThrows(NullPointerException.class,
            () -> ClosureUtils.<Object>chainedClosure((Closure[]) null)),                () -> assertThrows(NullPointerException.class,
            () -> ClosureUtils.<Object>chainedClosure((Collection<Closure<Object>>) null)),
            () -> assertThrows(NullPointerException.class,
            () -> ClosureUtils.<Object>chainedClosure(null, null)),
            () -> {
                final Collection<Closure<Object>> finalColl = new ArrayList<>();
                finalColl.add(null);
                finalColl.add(null);
                assertThrows(NullPointerException.class, () -> ClosureUtils.chainedClosure(finalColl));
                                });
                    }}