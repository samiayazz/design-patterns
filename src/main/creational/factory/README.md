# Factory Method

Define an interface for creating an object but let subclasses decide which class to instantiate. Factory Method allows a class to delegate the responsibility of creating an object to its subclasses.

Other languages: [Türkçe](docs/tr/README.md)

<hr/>
<br/>

### How to Use?

*EmployeeFactory*
```
public interface EmployeeFactory {
    Employee create(String name, String surname, byte age);
}
```

*EmployeeFactoryImpl*
```
public class EmployeeFactoryImpl implements EmployeeFactory {

    public Employee create(String name, String surname, byte age) {
        int id = 1;
        Employee employee = new Employee(id, name, surname, age);
        return employee;
    }
}
```

*ManagerFactory*
```
public interface ManagerFactory {
    Employee create(String name, String surname, byte age, BigDecimal salary);
}
```

*EmployeeFactoryImpl*
```
public class ManagerFactoryImpl implements ManagerFactory {

    public Employee create(String name, String surname, byte age, BigDecimal salary) {
        int id = 2;
        Manager manager = new Manager(id, name, surname, age, salary);
        return manager;
    }
}
```

<br/>

## Techniques

- ### [Abstract Factory](../../abstract_)
  
  The Abstract Factory Design Pattern is used to create families of dependent objects. It uses an interface or an abstract class to create related object groups and keeps the concrete implementations of these groups separate. Abstract Factory abstracts the classes used to create an object group, allowing the system to transition between different object groups and ensuring their compatibility. <br/>

  The Abstract Factory Design Pattern loosens the relationship between the client and domain objects, handling the model creation process within itself through Factory Methods.

  *GUIFactory*
  ```
  public interface GUIFactory {

      Component createButton();

      Component createList();

      Component createTable();
  }
  ```
  
  *GUIFactoryImpl*
  ```
  public class GUIFactoryImpl implements GUIFactory {

      @Override
	    public Component createButton() {
		    return new Button();
	    }

	    @Override
	    public Component createList() {
		    return new List();
	    }

	    @Override
	    public Component createTable() {
		    return new Table();
	    }
  }
  ```

- ### [Static Factory Method](../../static_)

  The Static Factory Method Design Pattern aims to provide convenience in usage by defining the create() method within the class whose instantiation will be handled, rather than in a separate factory class.

  *Foo*
  ```
  public class Foo {

      private Foo() {
          
      }

      public static Foo createFoo() {
          return new Foo();
      }
  }
  ```
  
<br/>

## Notes

- The `create()` method aims to acquire mandatory fields through parameters and organize other fields internally, so having fewer parameters will provide more advantages in usage.

<br/>
  
- Using the method as `static Employee create(employeeType)` in a simplified way will cause the method to bloat and remain changeable later without adhering to the open-closed principle.
- Grouping `create()` method by breaking it into `createEmployee()`, `createManager()`, etc., within a single class will make the create() method more comfortable and align with the single responsibility and open-closed principles. However, it is still not fully suitable for extension.
- Instead of changing the existing code in logic, creating a separate abstract factory class for each employeeType will allow the addition of innovations through extension and, therefore, adherence to the open-closed principle.

<br/>
<hr/>

<div align="right">
    ⬅️ <a href="../../../../../../">Home</a> ・
    <a href="https://github.com/samiayazz/">Author</a>
</div>
