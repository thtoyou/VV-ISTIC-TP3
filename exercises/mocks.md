# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

- Propose a solution to this problem in your new Mockito-based test cases.

## Answer

Dans notre Mockito-based test cases, si on vide la méthode prepareSocket, le test typical échoue.
Donc le test est bon, et on a aucun problème
