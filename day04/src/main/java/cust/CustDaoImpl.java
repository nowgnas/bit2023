package cust;

import dto.Cust;
import frame.ConnectionPool;
import frame.DaoFrame;
import frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CustDaoImpl implements DaoFrame<String, Cust> {
    Logger log = Logger.getLogger("CustDaoImpl");
    ConnectionPool cp;

    public CustDaoImpl() {
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(Cust cust) throws Exception {
        int result = 0;
        Connection con = cp.getConnection(); // poll 에서 가져오기
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(SQL.custInsert);

            pstmt.setString(1, cust.getId());
            pstmt.setString(2, cust.getPwd());
            pstmt.setString(3, cust.getName());
            result = pstmt.executeUpdate(); // 쿼리에서 예외가 발생하면 pstmt 와 커넥션이 릴리즈 되지 못한채로 예외가 던져진다

        } catch (Exception e) {
            log.info(e.getMessage()); // 디버깅 용으로 로그를 찍는 건 괜찮다
            throw new Exception("id 중복 에러"); // 예외를 던져줘야 클라이언트까지 예외가 난 것을 알 수 있다.
        } finally {
            DaoFrame.closePstmt(pstmt);
            // 다 사용하면 release 하기
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public int update(Cust cust) throws Exception {
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(SQL.custUpdate);
            pstmt.setString(1, cust.getPwd());
            pstmt.setString(2, cust.getName());
            pstmt.setString(3, cust.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info("update error : [" + e.getMessage() + "]");
            throw new Exception("cust data update error");
        } finally {
            DaoFrame.closePstmt(pstmt);
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public int delete(String s) throws Exception {
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(SQL.custDelete);
            pstmt.setString(1, s);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info("해당 id값을 삭제할 수 없습니다.");
            throw new Exception("삭제 에러 ");
        } finally {
            DaoFrame.closePstmt(pstmt);
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public Optional<Cust> select(String s) throws Exception {
        Cust cust = null;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            pstmt = con.prepareStatement(SQL.custSelect);
            pstmt.setString(1, s);
            rset = pstmt.executeQuery(); // 쿼리에서 예외가 발생하면 pstmt 와 커넥션이 릴리즈 되지 못한채로 예외가 던져진다
            if (rset.next()) {
                cust = Cust.builder().id(rset.getString("id"))
                        .pwd(rset.getString("pwd"))
                        .name(rset.getString("name"))
                        .build();
            }
        } catch (Exception e) {
            log.info(e.getMessage()); // 디버깅 용으로 로그를 찍는 건 괜찮다
            throw new Exception("조회 에러"); // 예외를 던져줘야 클라이언트까지 예외가 난 것을 알 수 있다.
        } finally {
            DaoFrame.closeRset(rset);
            DaoFrame.closePstmt(pstmt);
            // 다 사용하면 release 하기
            cp.releaseConnection(con);
        }
        return Optional.of(cust);
    }

    @Override
    public List<Cust> select() throws Exception {
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Cust> list = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SQL.custSelectAll);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                Cust cust = Cust.builder()
                        .id(rset.getString("id"))
                        .pwd(rset.getString("pwd"))
                        .name(rset.getString("name"))
                        .build();
                list.add(cust);
            }
        } catch (Exception e) {
            log.info("전체 조회 에러 ");
            throw new Exception("전체 조회 에러 ");
        } finally {
            DaoFrame.closeRset(rset);
            DaoFrame.closePstmt(pstmt);
            cp.releaseConnection(con);
        }
        return list;
    }
}
