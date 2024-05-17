package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.round.EscobaMatchRound;
import ar.edu.utn.frc.tup.lciii.round.RoundPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscobaMatchTest {

    @Test
    void isFinishTest_Tie() {
        EscobaMatch escobaMatch = new EscobaMatch(new User("user", 0), new User("APP", 0));
        escobaMatch.setAppUserPoints(17);
        escobaMatch.setHumanUserPoints(17);
        assertFalse(escobaMatch.isFinish());
    }

    @Test
    void isFinishTest_LassThanFifteen() {
        EscobaMatch escobaMatch = new EscobaMatch(new User("user", 0), new User("APP", 0));
        escobaMatch.setAppUserPoints(14);
        escobaMatch.setHumanUserPoints(10);
        assertFalse(escobaMatch.isFinish());
    }

    @Test
    void isFinishTest_Winner() {
        EscobaMatch escobaMatch = new EscobaMatch(new User("user", 0), new User("APP", 0));
        escobaMatch.setAppUserPoints(14);
        escobaMatch.setHumanUserPoints(16);
        assertTrue(escobaMatch.isFinish());
        assertEquals(escobaMatch.getWinner(), escobaMatch.getHumanUser());
    }

    @Test
    void calculateScore() {
        User humanUser = new User("user", 0);
        User appUser = new User("APP", 0);
        EscobaMatch escobaMatch = new EscobaMatch(humanUser, appUser);
        EscobaMatchRound round = new EscobaMatchRound(humanUser, appUser);
        round.getRoundPlayerHuman().setRoundPoints(7);
        round.getRoundPlayerApp().setRoundPoints(8);
        escobaMatch.setAppUserPoints(4);
        escobaMatch.setHumanUserPoints(3);
        escobaMatch.calculateScore(round);
        assertEquals(10, escobaMatch.getHumanUserPoints());
        assertEquals(12, escobaMatch.getAppUserPoints());
    }
}