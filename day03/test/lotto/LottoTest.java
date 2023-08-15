package lotto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호 갯수 테스트") // 보여지는 이름
    @Test
    @Order(1)
        //  순서
    void lottoNumberSizeTest() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        int price = 1000;

        // when
        List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then
        assertEquals("Size Error", lottoNumber.size(), 6);
    }


    @DisplayName("로또 번호 범위 테스트")
    @Test
    @Order(2)
    void lottoNumberRangeTest() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        int price = 1000;

        // when
        List<Integer> lotto = lottoNumberGenerator.generate(price);
        // then
        assertTrue("Range Error", lotto.stream().allMatch(v -> v >= 1 && v <= 45));
    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    @Order(3)
    void lottoNumberInvalidMoneyTest() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        int price = 2000;

        // when
        // assertThrows 
        RuntimeException exception = assertThrows(RuntimeException.class, () -> lottoNumberGenerator.generate(price));
        // then
        assertEquals("Input Money Error", exception.getMessage(), "올바른 금액이 아닙니다.");
    }


}