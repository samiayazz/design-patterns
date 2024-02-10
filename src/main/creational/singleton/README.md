# Singleton

The Singleton Design Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to it.

Other languages: [Türkçe](docs/tr/README.md)

<hr/>
<br>

### How to Use?

```
public class Foo {

    private Foo() {

    }

    private static Foo instance;

    public static Foo getInstance() {
        if (instance == null)
            instance = new Foo();

        return instance;
    }
}
```

<br/>

## Techniques

- ### [Locking](techniques/locking)
  
  In multithreaded environments, sometimes multiple tasks may check the `instance == null` condition simultaneously, leading to the creation of multiple instances. To ensure consistency in such cases, the null check definition or the `getInstance()` method itself should be synchronized using locking method.

  ```
  public static synchronized Foo getInstance() {
  
      if (instance == null)
          instance = new Foo();

      return instance;
  }
  ```

  - #### [Double-Checked Locking](techniques/locking/doublechecked)

    Double-Checked Locking is an optimization technique used to improve the performance and reduce the cost of the Singleton design pattern in multithreaded environments. When using the locking method, unnecessary null checks are performed every time the getInstance() method is called, starting from the application launch. This situation can be optimized using the Double-Checked Locking method.

    > **Note**:
    > Due to certain aspects of the thread structure, even with the null check expression, we may encounter situations where multiple instances of the instance object are created. To avoid this, we can use the volatile keyword, fixed in Java version 1.5.

    ```
    private static volatile Foo instance;

    public static Foo getInstance() {

        if (instance == null) {
            synchronized (Foo.class) {
                if (instance == null) {
                    instance = new Foo();
                }
            }
        }

        return instance;
    }
    ```

- ### [Bill Pugh](techniques/billpugh)

  The fundamental principle of this design is to safely create a Singleton instance using nested classes and the class loading mechanism of the Java language. Firstly, a helper class is created using a nested class, which holds the instance of the Singleton class. Later, this nested class is used to create an instance in the Singleton class. This ensures lazy initialization, meaning the Singleton instance is created only when needed.

  ```
  private static class SingletonHelper {
      private static final Foo FOO_INSTANCE = new Foo();
  }

  public static Foo getInstance() {
      return SingletonHelper.FOO_INSTANCE;
  }
  ```

- ### [Enumeration](techniques/enumeration)

  By using enum, we prevent breaking the singleton pattern through ways like reflection, serialization, etc. Additionally, since enums can only be instantiated once, we obtain a thread-safe singleton class.

  ```
  public enum Foo {
      INSTANCE();

      private Foo() {

      }

      Foo getInstance() {
          return INSTANCE;
      }
  }
  ```
  
<br/>
<hr/>

<div align="right">
    ⬅️ <a href="../../../../">Home</a> ・
    <a href="https://github.com/samiayazz/">Author</a>
</div>
