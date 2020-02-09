# WikipediaSearchExample
Example automated tests

## Building and running the tests

This is  a Maven project. Tests can be built with Maven and run in your IDE or
from the directory containing the pom file run the following command

```
mvn clean test
```

The above command will run in the default browser, Mozilla Firefox. 
To specify Google Chrome, run the following command:
```
mvn clean test -Dbrowser=chrome
```

No other browsers are configured to run with these tests.

## Dependencies

This test suite is configured to run in on the following operating systems:
* Mac OS X (verified on Catalina)
* MS Windows (verified on Windows 10)

And on the following browsers:

* Google Chrome v79
* Mozilla Firefox v72

### Note: The tests may not run correctly on older versions of these browsers.
