# Prototype

Prototype Tasarım Deseni, prototip bir nesneyi kullanarak yaratılacak nesneleri belirlemek ve yeni nesneleri, prototipi kopyalayarak oluşturmayı amaçlayan tasarım kalıbıdır. Bir nesnenin tipik olarak karmaşık veya maliyetli bir inşa sürecine sahip olduğu durumlarda kullanışlıdır.

⬅️ [Paketler](../../)

<hr/>
<br/>

### Nasıl kullanılır?

*Account*
```
public class Account implements Cloneable {
    protected String iban;

    private boolean openToWithdraw;
    private boolean openToPayment;
    private boolean openToTransfer;

    public Account(String iban, boolean openToWithdraw, boolean openToPayment, boolean openToTransfer) {
        this.iban = iban;
        this.openToWithdraw = openToWithdraw;
        this.openToPayment = openToPayment;
        this.openToTransfer = openToTransfer;
    }

    @Override
    public Account clone() {
        Account account = null;

        try {
            account = (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
            System.out.println(e);
        }

        return account;
    }
}
```

*Test*
```
public class PrototypeTest {

    public static void main(String[] args) {
        Account normalAccountPrototype = new Account(null, 0, 0, null, true, true, true);
        Account normalAccount = normalAccountPrototype.clone();
        normalAccount.setIban("1");
        normalAccount.setBalance(1000);
        normalAccount.setCredit(1000);
        normalAccount.setOwner(new Customer());

        Account negativeAccountPrototype = new Account(null, 0, 0, null, true, true, false);
        Account negativeAccount = negativeAccountPrototype.clone();
        negativeAccount.setIban("2");
        negativeAccount.setBalance(-500);
        negativeAccount.setCredit(1000);
        negativeAccount.setOwner(new Customer());

        Account frozenAccountPrototype = new Account(null, 0, 0, null, false, false, false);
        Account frozenAccount = frozenAccountPrototype.clone();
        frozenAccount.setIban("3");
        frozenAccount.setBalance(-1000);
        frozenAccount.setCredit(1000);
        frozenAccount.setOwner(new Customer());
    }
}
```

<br/>

## Teknikler

- ### [With Factory Method](../../techniques/factory)

  Prototype Tasarım Kalıbı, Factory Method Tasarım Kalıbı ile beraber kullanılarak daha kullanışlı bir hale getirilebilir.

  *AccountFactory*
  ```
  public interface AccountFactory {

      Account createNormal(String iban, Customer owner, double balance, double credit);

      Account createNegative(String iban, Customer owner, double balance, double credit);

      Account createFrozen(String iban, Customer owner, double balance, double credit);
  }
  ```

  *AccountFactoryImpl*
  ```
  public class AccountFactoryImpl implements AccountFactory {

      /*
      * private final Account normalPrototype; private final Account
      * negativePrototype; private final Account frozenPrototype;
      */

      public AccountFactoryImpl() {
      /*
      * normalPrototype = new Account(null, 0, 0, null, true, true, true);
      *
      * negativePrototype = normalPrototype.clone();
      * negativePrototype.setOpenToTransfer(false);
      *
      * frozenPrototype = normalPrototype.clone();
      * frozenPrototype.setOpenToWithdraw(false);
      * frozenPrototype.setOpenToPayment(false);
      * frozenPrototype.setOpenToTransfer(false);
      */
      }

      @Override
      public Account createNormal(String iban, Customer owner, double balance, double credit) {
          Account account = AccountPrototypes.NORMAL.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      @Override
      public Account createNegative(String iban, Customer owner, double balance, double credit) {
          Account account = AccountPrototypes.NEGATIVE.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      @Override
      public Account createFrozen(String iban, Customer owner, double balance, double credit) {
          Account account = AccountPrototypes.FROZEN.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      private static class AccountPrototypes {
          public static final Account NORMAL = new Account(null, 0, 0, null, true, true, true);
          public static final Account NEGATIVE = new Account(null, 0, 0, null, true, true, false);
          public static final Account FROZEN = new Account(null, 0, 0, null, false, false, false);
      }
  }
  ```

- ### [With Static Factory Method](../../techniques/factory/static_)

  Prototype Tasarım Kalıbı, Static Factory Method Tasarım Kalıbı ile beraber kullanılarak daha kullanışlı bir hale getirilebilir.

  ```
  public class Account implements Cloneable {
      protected String iban;

      private boolean openToWithdraw;
      private boolean openToPayment;
      private boolean openToTransfer;

      private Account(String iban, boolean openToWithdraw, boolean openToPayment, boolean openToTransfer) {
          this.iban = iban;
          this.openToWithdraw = openToWithdraw;
          this.openToPayment = openToPayment;
          this.openToTransfer = openToTransfer;
      }

      @Override
      public Account clone() {
          Account account = null;

          try {
              account = (Account) super.clone();
          } catch (CloneNotSupportedException e) {
              System.out.println("CloneNotSupportedException");
              System.out.println(e);
          }
  
          return account;
      }

      public static Account createNormal(String iban, Customer owner, double balance, double credit) {
          Account account = Prototypes.normal.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      public static Account createNegative(String iban, Customer owner, double balance, double credit) {
          Account account = Prototypes.negative.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      public static Account createFrozen(String iban, Customer owner, double balance, double credit) {
          Account account = Prototypes.frozen.clone();
          account.setIban(iban);
          account.setOwner(owner);
          account.setBalance(balance);
          account.setCredit(credit);
          return account;
      }

      private static class Prototypes {
          public static final Account normal = new Account(null, 0, 0, null, true, true, true);
          public static final Account negative = new Account(null, 0, 0, null, true, true, false);
          public static final Account frozen = new Account(null, 0, 0, null, false, false, false);
      }
  }
  ```

<br/>
<hr/>

<div align="right">
    ⬅️ <a href="../../../../../../">Anasayfa</a> ・
    <a href="https://github.com/samiayazz/">Yazar</a>
</div>