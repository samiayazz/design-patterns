# Factory Method

Bir nesne yaratmak için bir arayüz tanımla fakat hangi sınıfın nesnesinin oluşturulacağına alt sınıflar karar versin. Factory Method, bir sınıfın nesne oluşturmasını, alt sınıflarına ötelenmesine izin verir.

⬅️ [Paketler](../../)

<hr/>
<br/>

### Nasıl kullanılır?

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

## Teknikler

- ### [Abstract Factory](../../abstract_)
  
  Abstract Factory Tasarım Kalıbı, birbirine bağımlı nesne gruplarını oluşturmak için kullanılır. Bir arayüz veya soyut bir sınıf kullanarak ilgili nesne gruplarını oluşturmayı sağlar ve bu grupların somut uygulamalarını ayrı ayrı tutar. Abstract Factory, bir nesne grubunu oluşturmak için kullanılan sınıfları soyutlar, böylece sistem, farklı nesne grupları arasında geçiş yapabilir ve bu grupların uyumlu olmasını sağlar. <br/>

  Abstract Factory Tasarım Kalıbı, client ile domain nesneleri arasındaki ilişkiyi gevşetir ve model oluşturma işlemini client'a bırakmadan kendi içinde ele alan, Factory Method'lardan oluşan bir tasarım kalıbıdır.

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
  
  Static Factory Method Tasarım Kalıbı, `create()` metodunu ayrı bir factory sınıfı yerine, üretimi ele alınacak olan sınıfın içinde tanımlayarak, kullanım açısından kolaylık sağlamayı amaçlayan bir tasarım kalıbıdır.

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

## Notlar

- `create()` metodu, zorunlu alanları parametre yoluyla edinip, diğer alanları kendi içinde organize etmeyi amaçlar, bu sebeple ne kadar az parametre alırsa, kullanımı o kadar avantaj sağlayacaktır.

<br/>

- `static Employee create(employeeType)` şeklinde, daha basite indirgenmiş olan bu yöntem, open-closed prensibine uymayarak, metodun şişmesine ve sonradan değiştirilebilir durumda kalmasına neden olacaktır.
- `create()` metodunu bölerek `createEmployee()`, `createManager()` gibi tek sınıf içinde toplamak, `create()` metodunu rahatlatacak ve single responsibility, open-closed prensiplerine daha uygun hale getirecektir. Fakat yine de tam anlamıyla genişletilmeye uygun değildir.
- Bunun yerine her employeeType için ayrı bir abstract factory sınıfı üretmek, logic'de mevcut kodu değiştirmektense, genişletme yoluyla yenilikler ekleyebilmeyi ve dolayısıyla open-closed prensibine bağlı kalabilmeyi sağlayacaktır.

<br/>
<hr/>

<div align="right">
    ⬅️ <a href="../../../../../../">Anasayfa</a> ・
    <a href="https://github.com/samiayazz/">Yazar</a>
</div>
