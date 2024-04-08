## If a method throws NullPointerException in the superclass, can we override it with a method that throws RuntimeException?

Yes, you can override a method in a subclass to throw a superclass of the exception thrown by the overridden method. Since `RuntimeException` is a superclass of `NullPointerException`, you can override a method that throws `NullPointerException` in the superclass with a method that throws `RuntimeException` in the subclass.

Here's an example:

```java
class Superclass {
    // Method in superclass throwing NullPointerException
    void method() throws NullPointerException {
        // Code that may throw NullPointerException
    }
}

class Subclass extends Superclass {
    // Overriding method in subclass throwing RuntimeException
    @Override
    void method() throws RuntimeException {
        // Code that may throw RuntimeException
    }
}
```

In this example, the `method()` in the `Superclass` throws `NullPointerException`, but it is overridden in the `Subclass` to throw `RuntimeException`. This is allowed because `RuntimeException` is a superclass of `NullPointerException`. Therefore, the overridden method in the subclass does not introduce additional checked exceptions compared to the method it overrides, which is allowed by Java's exception handling rules.


## Will the same above concept application for checked exception in java?

No, the same concept does not apply for checked exceptions in Java. Unlike unchecked exceptions (such as `RuntimeException`), checked exceptions must be handled explicitly by the caller or declared in the method's throws clause.

In Java, if a method in the superclass throws a checked exception, then the overridden method in the subclass can only throw the same checked exception or its subclass (i.e., an exception that is more specific).

Here's an example to illustrate this:

```java
import java.io.IOException;

class Superclass {
    // Method in superclass throwing IOException (checked exception)
    void method() throws IOException {
        // Code that may throw IOException
    }
}

class Subclass extends Superclass {
    // Attempting to override method in subclass with a different checked exception
    // This will result in a compilation error
    @Override
    void method() throws RuntimeException {
        // Code that may throw RuntimeException
    }
}
```

In this example, the `method()` in the `Superclass` throws `IOException`, which is a checked exception. If you attempt to override it in the `Subclass` with a method that throws a different checked exception (such as `RuntimeException`), it will result in a compilation error. This is because the overridden method in the subclass must not introduce new checked exceptions that are not declared in the superclass method's throws clause.