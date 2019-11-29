package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private ScoreCalculateur unScore;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        //given : un objet du type score calculateur, testé à l'aide d'une question à choix multiple
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        unScore = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScore() {
        //when : on fourni deux mauvaises réponses
        //and : on demande le calcul du score
        Float resScore = unScore.calculeScore(new ArrayList<Integer>(Arrays.asList(1,4)), questionAChoixMultiple);
        //then : le score est bien à 0
        assertEquals(new Float(0f), resScore);
        //when : on fourni deux bonnes réponses
        //and : on demande le calcul du score
        resScore = unScore.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3)), questionAChoixMultiple);
        //then : le score est bien à 66
        assertEquals(new Float(66.66f), resScore, 0.01f);
        //when : on fourni trois bonnes réponses
        //and : on demande le calcul du score
        resScore = unScore.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3,5)), questionAChoixMultiple);
        assertEquals(new Float(100f), resScore, 0.01f);
    }
}