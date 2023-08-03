package frame;

import java.util.List;

public interface DaoFrame<K, V> {
    // generic 을 사용해 클래스에 관계 없이 받을 수 있다
    // 꼭 모든 메서드를 구현할 필요는 없다

    void insert(V v);

    void update(V v);

    void delete(K k);

    V select(K k);

    List<V> select(); // 오버로딩

}
