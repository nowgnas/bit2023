package frame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface DaoFrame<K, V> {
    // generic 을 사용해 클래스에 관계 없이 받을 수 있다
    // 꼭 모든 메서드를 구현할 필요는 없다

    int insert(V v) throws Exception;

    int update(V v) throws Exception;

    int delete(K k) throws Exception;

    V select(K k) throws Exception;

    List<V> select() throws Exception; // 오버로딩

    public static void closePstmt(PreparedStatement pstmt) throws Exception {
        if (pstmt != null) pstmt.close(); // 반드시 존재하는지 확인하고 종료 시키기
    }

    public static void closeRset(ResultSet rset) throws Exception {
        if (rset != null) {
            rset.close();
        }
    }

}
