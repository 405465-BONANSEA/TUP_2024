package ar.edu.utn.frc.tup.lciii.round;

import ar.edu.utn.frc.tup.lciii.Card;
import ar.edu.utn.frc.tup.lciii.CardSuit;
import ar.edu.utn.frc.tup.lciii.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AppRoundPlayerTest {

    @Test
    void playTurnTest_PositiveAnswer() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(new User("Hernán", 0));
        roundPlayer.setHandCards(new ArrayList<>());
        roundPlayer.getHandCards().add(new Card(CardSuit.ESPADAS, 11, 9));
        roundPlayer.getHandCards().add(new Card(CardSuit.OROS, 6, 6));
        roundPlayer.getHandCards().add(new Card(CardSuit.COPAS, 2, 2));
        List<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(CardSuit.ESPADAS, 10, 8));
        tableCards.add(new Card(CardSuit.BASTOS, 3, 3));
        tableCards.add(new Card(CardSuit.COPAS, 3, 3));
        List<Card> expectedTableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8)
        );
        List<Card> expectedHandCards = List.of(
                new Card(CardSuit.OROS, 6, 6),
                new Card(CardSuit.COPAS, 2, 2)
        );
        roundPlayer.playTurn(tableCards);
        assertEquals(expectedHandCards, roundPlayer.getHandCards());
        assertEquals(expectedTableCards, tableCards);
    }

    @Test
    void playTurnTest_NegativeAnswer() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(new User("Hernán", 0));
        roundPlayer.setHandCards(new ArrayList<>());
        roundPlayer.getHandCards().add(new Card(CardSuit.ESPADAS, 10, 8));
        roundPlayer.getHandCards().add(new Card(CardSuit.OROS, 6, 6));
        roundPlayer.getHandCards().add(new Card(CardSuit.COPAS, 2, 2));
        List<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(CardSuit.ESPADAS, 10, 8));
        tableCards.add(new Card(CardSuit.BASTOS, 3, 3));
        tableCards.add(new Card(CardSuit.COPAS, 3, 3));
        List<Card> expectedTableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3),
                new Card(CardSuit.COPAS, 2, 2)
        );
        List<Card> expectedHandCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.OROS, 6, 6)
        );
        roundPlayer.playTurn(tableCards);
        assertEquals(expectedHandCards, roundPlayer.getHandCards());
        assertEquals(expectedTableCards, tableCards);
    }

    @Test
    void getCardToDiscardTest() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 12, 10),
                new Card(CardSuit.OROS, 6, 6),
                new Card(CardSuit.COPAS, 2, 2)));
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "getCardToDiscard");
        Card expectedCard = new Card(CardSuit.COPAS, 2, 2);
        Card result = null;
        if(optionalMethod.isPresent()) {
            result = (Card) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCard, result);
    }

    @Test
    void selectCardsAppTest_NoCombination() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 12, 10),
                new Card(CardSuit.OROS, 6, 6),
                new Card(CardSuit.COPAS, 2, 2)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertNull(result);
    }

    @Test
    void selectCardsAppTest_OneCombination() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 11, 9),
                new Card(CardSuit.OROS, 6, 6),
                new Card(CardSuit.COPAS, 2, 2)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3),
                new Card(CardSuit.ESPADAS, 11, 9)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void selectCardsAppTest_EscobaScenario() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.OROS, 7, 7),
                new Card(CardSuit.COPAS, 4, 4)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 3, 3),
                new Card(CardSuit.ESPADAS, 1, 1)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void selectCardsAppTest_SevenOroScenario() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.OROS, 7, 7),
                new Card(CardSuit.COPAS, 4, 4)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.BASTOS, 3, 3),
                new Card(CardSuit.COPAS, 6, 6)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.OROS, 7, 7)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void selectCardsAppTest_MoreOrosScenario() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.OROS, 6, 6),
                new Card(CardSuit.COPAS, 4, 4)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.COPAS, 6, 6)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.COPAS, 6, 6),
                new Card(CardSuit.OROS, 6, 6)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void selectCardsAppTest_CardsWithSevenScenario() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 7, 7),
                new Card(CardSuit.ESPADAS, 6, 6),
                new Card(CardSuit.COPAS, 4, 4)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 10, 8),
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.COPAS, 7, 7)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.COPAS, 7, 7),
                new Card(CardSuit.ESPADAS, 7, 7)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void selectCardsAppTest_MoreCardsScenario() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        roundPlayer.setHandCards(List.of(
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.ESPADAS, 6, 6),
                new Card(CardSuit.COPAS, 4, 4)));
        List<Card> tableCards = List.of(
                new Card(CardSuit.ESPADAS, 4, 4),
                new Card(CardSuit.COPAS, 4, 4),
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.COPAS, 10, 8)
        );
        List<Card> expectedCards = List.of(
                new Card(CardSuit.ESPADAS, 4, 4),
                new Card(CardSuit.COPAS, 4, 4),
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.ESPADAS, 6, 6)
        );
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "selectCardsApp", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, tableCards);
        } else {
            fail("Method selectCardsApp not found");
        }
        assertEquals(expectedCards, result);
    }

    @Test
    void getCardsWithSevenTest() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        List<Card> cardsWithSeven = List.of(
                new Card(CardSuit.BASTOS, 7, 7),
                new Card(CardSuit.OROS, 10, 8)
        );
        List<Card> cardsWithTwoSeven = List.of(
                new Card(CardSuit.BASTOS, 7, 7),
                new Card(CardSuit.OROS, 7, 7),
                new Card(CardSuit.COPAS, 1, 1)
        );
        List<Card> cardsWithoutSeven = List.of(
                new Card(CardSuit.BASTOS, 12, 10),
                new Card(CardSuit.OROS, 5, 5)
        );
        List<List<Card>> subconjuntos = List.of(cardsWithSeven, cardsWithTwoSeven, cardsWithoutSeven);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "getCardsWithSeven", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, subconjuntos);
        } else {
            fail("Method getCardsWithSeven not found");
        }
        assertEquals(cardsWithTwoSeven, result);
    }

    @Test
    void getCardsWithEscobaTest() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        List<Card> cardsWithoutEscoba = List.of(
                new Card(CardSuit.BASTOS, 2, 2),
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.OROS, 5, 5),
                new Card(CardSuit.COPAS, 5, 5)
        );
        List<Card> cardsWithEscoba = List.of(
                new Card(CardSuit.BASTOS, 2, 2),
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.OROS, 5, 5),
                new Card(CardSuit.COPAS, 3, 3),
                new Card(CardSuit.COPAS, 2, 2)
        );
        List<List<Card>> subconjuntos = List.of(cardsWithEscoba, cardsWithoutEscoba);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "getCardsWithEscoba", List.class, Integer.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, subconjuntos, 5);
        } else {
            fail("Method getCardsWithEscoba not found");
        }
        assertEquals(cardsWithEscoba, result);
    }

    @Test
    void getCardsWithSevenOroTest() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        List<Card> cardsWithSevenOro = List.of(
                new Card(CardSuit.BASTOS, 2, 2),
                new Card(CardSuit.OROS, 2, 2),
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.COPAS, 1, 1),
                new Card(CardSuit.OROS, 7, 7)
        );
        List<Card> cardsWithoutSevenOro = List.of(
                new Card(CardSuit.BASTOS, 2, 2),
                new Card(CardSuit.OROS, 2, 2),
                new Card(CardSuit.OROS, 3, 3),
                new Card(CardSuit.COPAS, 1, 1),
                new Card(CardSuit.BASTOS, 7, 7)
        );
        List<List<Card>> subconjuntos = List.of(cardsWithSevenOro, cardsWithoutSevenOro);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "getCardsWithSevenOro", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, subconjuntos);
        } else {
            fail("Method getCardsWithSevenOro not found");
        }
        assertEquals(cardsWithSevenOro, result);
    }

    @Test
    void getCardsWithMoreOrosTest() {
        AppRoundPlayer roundPlayer = new AppRoundPlayer(Mockito.any());
        List<Card> cardsWithLessOros = List.of(
                new Card(CardSuit.BASTOS, 1, 1),
                new Card(CardSuit.OROS, 1, 1),
                new Card(CardSuit.ESPADAS, 2, 2),
                new Card(CardSuit.OROS, 4, 4),
                new Card(CardSuit.ESPADAS, 7, 7)
        );
        List<Card> cardsWithMoreOros = List.of(
                new Card(CardSuit.OROS, 1, 1),
                new Card(CardSuit.OROS, 1, 1),
                new Card(CardSuit.ESPADAS, 2, 2),
                new Card(CardSuit.OROS, 4, 4),
                new Card(CardSuit.COPAS, 7, 7)
        );
        List<Card> cardsWithoutOros = List.of(
                new Card(CardSuit.BASTOS, 1, 1),
                new Card(CardSuit.ESPADAS, 1, 1),
                new Card(CardSuit.ESPADAS, 2, 2),
                new Card(CardSuit.COPAS, 4, 4),
                new Card(CardSuit.BASTOS, 7, 7)
        );
        List<List<Card>> subconjuntos = List.of(cardsWithLessOros, cardsWithMoreOros, cardsWithoutOros);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(AppRoundPlayer.class, "getCardsWithMoreOros", List.class);
        List<Card> result = new ArrayList<>();
        if(optionalMethod.isPresent()) {
            result = (List<Card>) ReflectionUtils.invokeMethod(optionalMethod.get(), roundPlayer, subconjuntos);
        } else {
            fail("Method getCardsWithMoreOros not found");
        }
        assertEquals(cardsWithMoreOros, result);
    }
}