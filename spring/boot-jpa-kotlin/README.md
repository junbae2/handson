# Kotlin 으로 spring jpa 어플리케이션을 작성할때
## 더 알게된 것
### Entity를 작성할 기억하면 좋을것
* @Entity
* @Id
* open class
  * final class 인경우 orm 이 entity class를 조작 하는데 문제가 생긴다.
  * final class 는 확장 할수 없고, orm 이 proxy 를 구현해서, entity class 를 조작하려면 확장가능 해야 한다.
* @Serializable
  * 항상 필요하지는 않다.@Serializable 을 구현하지 않다도, 기본 jpa 기능을 사용하는데는 문제가 없다.
  * 필요한경우가 가끔 있다.
    * 객체를 원격에 전송하려 한다.
    * 객체를 어딘가에 저장하려 한다.
    * PK 가 아닌 column 으로 연관관계를 만드려 한다. (정확한 메커니즘은 아직 잘..)
### 더 알고 싶은것
#### Test
* junit5 의 사용범
  * https://junit.org/junit5/docs/current/user-guide/#overview
* com.ninja-squad:springmockk 의 역할
