# Singleton

Singleton Tasarım Deseni, bir sınıfın yalnızca bir örneğe sahip olduğunu ve buna genel erişim noktası sağlayan bir yaratım tasarım desenidir.

⬅️ [Paketler](../../)

<hr/>
<br/>

### Nasıl kullanılır?

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

## Teknikler

- ### [Locking](../../locking)

  Multithread ortamlarda bazen, birden fazla task aynı anda `instance == null` koşulunu kontrol edebiliyor ve bu durum birden fazla instance oluşmasına yol açıyor.
  Bu durumda tutarlılığı sağlamak için, null check tanımı veya direkt `getInstance()` metotu `synchronized(lock)` edilmelidir.
  
  ```
  public static synchronized Foo getInstance() {
  
      if (instance == null)
          instance = new Foo();

      return instance;
  }
  ```
  
  - #### [(Double-Checked Locking)](../../locking/doublechecked)
    
    Double-Checked Locking, Singleton tasarım deseninin multithread ortamlarda performansı artırmak ve maliyeti azaltmak amacıyla kullanılan bir optimizasyon tekniğidir.<br/>
    Lock yönteminin kullanıldığı durumlarda, uygulama ayağa kaldırıldığı ilk andan itibaren, `getInstance()` metodu her çağırıldığında gereksiz bir null check kontrolü sağlanıyor. Bu durumu, Double-Checked Locking yöntemini kullanarak optimize edebiliriz.

    > **Not**:
    > Thread yapısındaki bazı durumlardan ötürü `null check` ifadesine rağmen `instance` nesnesinin birden fazla örneğinin oluşturulduğu durumlarla karşılaşabiliriz. Bu durumdan kaçınmak için; Java 1.5 sürümünden sonra fix'lenen `Volatile` ifadesini kullanabiliriz.

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
    
- ### [Bill Pugh](../../billpugh)
  
  Bu tasarımın temel prensibi, iç içe sınıfları kullanarak ve Java dilinin sınıf yüklenme mekanizmasını kullanarak Singleton örneğini güvenli bir şekilde oluşturmaktır. <br/>
  İlk olarak, iç içe sınıf (nested class) kullanarak bir yardımcı sınıf oluşturulur. Bu sınıf, Singleton sınıfının örneğini tutar. Daha sonra, Singleton sınıfında bir örneği oluşturmak için bu nested class kullanılır. Bu sayede lazy initialization (tembel başlatma) sağlanır, yani Singleton örneği sadece ihtiyaç duyulduğunda oluşturulur.

  ```
  private static class SingletonHelper {
      private static final Foo FOO_INSTANCE = new Foo();
  }

  public static Foo getInstance() {
      return SingletonHelper.FOO_INSTANCE;
  }
  ```
  
- ### [Enumeration](../../enumeration)
  
  Enum yoluyla, singleton nesne üreterek hem reflection, serialization vs. gibi yollarla singleton kalıbının kırılmasını engellemiş oluruz hem de enum zaten sadece bir kez örneklenebildiği için thread safe bir singleton sınıf elde etmiş oluruz.

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
    ⬅️ <a href="../../../../../../">Anasayfa</a> ・
    <a href="https://github.com/samiayazz/">Yazar</a>
</div>
