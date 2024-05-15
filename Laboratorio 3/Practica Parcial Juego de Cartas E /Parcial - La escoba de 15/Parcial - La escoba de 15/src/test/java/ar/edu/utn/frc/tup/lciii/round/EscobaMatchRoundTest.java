package ar.edu.utn.frc.tup.lciii.round;

import ar.edu.utn.frc.tup.lciii.Card;
import ar.edu.utn.frc.tup.lciii.CardSuit;
import ar.edu.utn.frc.tup.lciii.Deck;
import ar.edu.utn.frc.tup.lciii.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EscobaMatchRoundTest {

    private static final List<Card> PLAYER_CARDS = List.of(
            new Card(CardSuit.ESPADAS, 11, 9),
            new Card(CardSuit.ESPADAS, 10, 8),
            new Card(CardSuit.OROS, 6, 6),
            new Card(CardSuit.COPAS, 2, 2),
            new Card(CardSuit.BASTOS, 3, 3),
            new Card(CardSuit.COPAS, 3, 3),
            new Card(CardSuit.OROS, 7, 7),
            new Card(CardSuit.BASTOS, 7, 7),
            new Card(CardSuit.ESPADAS, 7, 7)
    );

    private static final List<Card> APP_CARDS = List.of(
            new Card(CardSuit.OROS, 11, 9),
            new Card(CardSuit.OROS, 10, 8),
            new Card(CardSuit.BASTOS, 6, 6),
            new Card(CardSuit.BASTOS, 2, 2),
            new Card(CardSuit.ESPADAS, 3, 3),
            new Card(CardSuit.OROS, 3, 3),
            new Card(CardSuit.COPAS, 7, 7)
    );

    private static final User HUMAN_USER = new User("Human", 0);
    private static final User APP_USER = new User("App", 0);

    @Test
    void startRoundTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Deck deck = new Deck();
        List<Card> cards = List.copyOf(deck.getCards());
        escobaMatchRound.setDeck(deck);
        escobaMatchRound.startRound(false);
        assertEquals(3, escobaMatchRound.getRoundPlayerHuman().getHandCards().size());
        assertEquals(3, escobaMatchRound.getRoundPlayerApp().getHandCards().size());
        assertEquals(cards.get(39), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(0));
        assertEquals(cards.get(37), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(1));
        assertEquals(cards.get(35), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(2));
        assertEquals(cards.get(38), escobaMatchRound.getRoundPlayerApp().getHandCards().get(0));
        assertEquals(cards.get(36), escobaMatchRound.getRoundPlayerApp().getHandCards().get(1));
        assertEquals(cards.get(34), escobaMatchRound.getRoundPlayerApp().getHandCards().get(2));
        assertEquals(cards.get(33), escobaMatchRound.getTableCards().get(0));
        assertEquals(cards.get(32), escobaMatchRound.getTableCards().get(1));
        assertEquals(cards.get(31), escobaMatchRound.getTableCards().get(2));
        assertEquals(cards.get(30), escobaMatchRound.getTableCards().get(3));
    }

    @Test
    void dealCardsTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Deck deck = new Deck();
        List<Card> cards = List.copyOf(deck.getCards());
        escobaMatchRound.setDeck(deck);
        escobaMatchRound.dealCards(false);
        assertEquals(3, escobaMatchRound.getRoundPlayerHuman().getHandCards().size());
        assertEquals(3, escobaMatchRound.getRoundPlayerApp().getHandCards().size());
        assertEquals(cards.get(39), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(0));
        assertEquals(cards.get(37), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(1));
        assertEquals(cards.get(35), escobaMatchRound.getRoundPlayerHuman().getHandCards().get(2));
        assertEquals(cards.get(38), escobaMatchRound.getRoundPlayerApp().getHandCards().get(0));
        assertEquals(cards.get(36), escobaMatchRound.getRoundPlayerApp().getHandCards().get(1));
        assertEquals(cards.get(34), escobaMatchRound.getRoundPlayerApp().getHandCards().get(2));
    }

    @Test
    void checkEscobaEnMesa() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        List<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(CardSuit.OROS, 5, 5));
        tableCards.add(new Card(CardSuit.OROS, 2, 2));
        tableCards.add(new Card(CardSuit.BASTOS, 3, 3));
        tableCards.add(new Card(CardSuit.COPAS, 5, 5));
        escobaMatchRound.setTableCards(tableCards);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "checkEscobaEnMesa", Boolean.class);
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, false);
        } else {
            fail("Method checkEscobaEnMesa not found");
        }
        assertEquals(0, escobaMatchRound.getRoundPlayerHuman().getEscobasQuantity());
        assertEquals(1, escobaMatchRound.getRoundPlayerApp().getEscobasQuantity());
        assertTrue(escobaMatchRound.getTableCards().isEmpty());
    }

    @Test
    void playRoundTest() {
        HumanRoundPlayer humanRoundPlayer = Mockito.mock(HumanRoundPlayer.class);
        AppRoundPlayer appRoundPlayer = Mockito.mock(AppRoundPlayer.class);
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.setRoundPlayerHuman(humanRoundPlayer);
        escobaMatchRound.setRoundPlayerApp(appRoundPlayer);
        doNothing().when(humanRoundPlayer).playTurn(Mockito.anyList());
        doNothing().when(appRoundPlayer).playTurn(Mockito.anyList());
        escobaMatchRound.startRound(false);
        escobaMatchRound.playRound(false);
        verify(humanRoundPlayer, times(3)).playTurn(Mockito.anyList());
        verify(appRoundPlayer, times(2)).playTurn(Mockito.anyList());
    }

    @Test
    void calculateRoundScoreTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(PLAYER_CARDS);
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(APP_CARDS);
        escobaMatchRound.getRoundPlayerHuman().setEscobasQuantity(2);
        escobaMatchRound.getRoundPlayerApp().setEscobasQuantity(3);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "calculateRoundScore");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method calculateRoundScore not found");
        }
        assertEquals(5, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(4, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }

    @Test
    void solveSevenWinnerTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(PLAYER_CARDS);
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(APP_CARDS);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveSevenWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveSevenWinner not found");
        }
        assertEquals(1, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(0, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }
    @Test
    void solveSevenWinnerTest_ExtraPoint() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(new ArrayList<>(PLAYER_CARDS));
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(new ArrayList<>(APP_CARDS));
        escobaMatchRound.getRoundPlayerHuman().getPersonalDeck().add(new Card(CardSuit.COPAS, 7, 7));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().remove(new Card(CardSuit.COPAS, 7, 7));
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveSevenWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveSevenWinner not found");
        }
        assertEquals(2, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(0, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }


    @Test
    void solveSevenOroWinnerTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(PLAYER_CARDS);
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(APP_CARDS);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveSevenOroWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveSevenOroWinner not found");
        }
        assertEquals(1, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(0, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }

    @Test
    void solveOrosWinnerTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(PLAYER_CARDS);
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(APP_CARDS);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveOrosWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveOrosWinner not found");
        }
        assertEquals(0, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(1, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }

    @Test
    void solveOrosWinnerTest_ExtraPoint() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(new ArrayList<>(PLAYER_CARDS));
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(new ArrayList<>(APP_CARDS));
        escobaMatchRound.getRoundPlayerHuman().getPersonalDeck().remove(new Card(CardSuit.OROS, 6, 6));
        escobaMatchRound.getRoundPlayerHuman().getPersonalDeck().remove(new Card(CardSuit.OROS, 7, 7));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 1, 1));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 2, 2));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 4, 4));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 5, 5));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 6, 6));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 7, 7));
        escobaMatchRound.getRoundPlayerApp().getPersonalDeck().add(new Card(CardSuit.OROS, 12, 10));
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveOrosWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveOrosWinner not found");
        }
        assertEquals(0, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(2, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }

    @Test
    void solveQuantityCardsWinnerTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().setPersonalDeck(PLAYER_CARDS);
        escobaMatchRound.getRoundPlayerApp().setPersonalDeck(APP_CARDS);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "solveQuantityCardsWinner");
        if(optionalMethod.isPresent()) {
            ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method solveQuantityCardsWinner not found");
        }
        assertEquals(1, escobaMatchRound.getRoundPlayerHuman().getRoundPoints());
        assertEquals(0, escobaMatchRound.getRoundPlayerApp().getRoundPoints());
    }

    @Test
    void isHandFinishTest_Positive() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().getHandCards().clear();
        escobaMatchRound.getRoundPlayerApp().getHandCards().clear();
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "isHandFinish");
        Boolean result = null;
        if(optionalMethod.isPresent()) {
            result = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method isHandFinish not found");
        }
        assertTrue(result);
    }

    @Test
    void isHandFinishTest_Negative() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().getHandCards().add(new Card(CardSuit.OROS, 7, 7));
        escobaMatchRound.getRoundPlayerApp().getHandCards().clear();
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "isHandFinish");
        Boolean result = null;
        if(optionalMethod.isPresent()) {
            result = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method isHandFinish not found");
        }
        assertFalse(result);
    }

    @Test
    void isRoundFinishTest_Positive() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Deck mockDeck = Mockito.mock(Deck.class);
        escobaMatchRound.getRoundPlayerHuman().getHandCards().clear();
        escobaMatchRound.getRoundPlayerApp().getHandCards().clear();
        escobaMatchRound.setDeck(mockDeck);
        when(mockDeck.isEmpty()).thenReturn(true);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "isRoundFinish");
        Boolean result = null;
        if(optionalMethod.isPresent()) {
            result = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method isRoundFinish not found");
        }
        assertTrue(result);
    }

    @Test
    void isRoundFinishTest_Negative() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        escobaMatchRound.getRoundPlayerHuman().getHandCards().clear();
        escobaMatchRound.getRoundPlayerApp().getHandCards().clear();
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "isRoundFinish");
        Boolean result = null;
        if(optionalMethod.isPresent()) {
            result = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound);
        } else {
            fail("Method isRoundFinish not found");
        }
        assertFalse(result);
    }

    @Test
    void orosQuantityTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "orosQuantity", List.class);
        Integer resultUser = 0;
        Integer resultApp = 0;
        if(optionalMethod.isPresent()) {
            resultUser = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, PLAYER_CARDS);
            resultApp = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, APP_CARDS);
        } else {
            fail("Method orosQuantity not found");
        }
        assertEquals(2, resultUser);
        assertEquals(3, resultApp);
    }

    @Test
    void sevenQuantityTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "sevenQuantity", List.class);
        Integer resultUser = 0;
        Integer resultApp = 0;
        if(optionalMethod.isPresent()) {
            resultUser = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, PLAYER_CARDS);
            resultApp = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, APP_CARDS);
        } else {
            fail("Method sevenQuantity not found");
        }
        assertEquals(3, resultUser);
        assertEquals(1, resultApp);
    }

    @Test
    void sevenOroCheckTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "sevenOroCheck", List.class);
        Boolean resultUser = null;
        Boolean resultApp = null;
        if(optionalMethod.isPresent()) {
            resultUser = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, PLAYER_CARDS);
            resultApp = (Boolean) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, APP_CARDS);
        } else {
            fail("Method sevenOroCheck not found");
        }
        assertTrue(resultUser);
        assertFalse(resultApp);
    }

    @Test
    void quantityCardsTest() {
        EscobaMatchRound escobaMatchRound = new EscobaMatchRound(HUMAN_USER, APP_USER);
        Optional<Method> optionalMethod = ReflectionUtils.findMethod(EscobaMatchRound.class, "quantityCards", List.class);
        Integer resultUser = 0;
        Integer resultApp = 0;
        if(optionalMethod.isPresent()) {
            resultUser = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, PLAYER_CARDS);
            resultApp = (Integer) ReflectionUtils.invokeMethod(optionalMethod.get(), escobaMatchRound, APP_CARDS);
        } else {
            fail("Method quantityCards not found");
        }
        assertEquals(9, resultUser);
        assertEquals(7, resultApp);
    }
}