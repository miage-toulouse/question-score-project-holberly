package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {
    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void setUp() throws Exception {
        //given : un objet du type QuestionAChoixMultiple
        List<Integer> bonneReponses = new ArrayList<Integer>();
        bonneReponses.add(1);
        bonneReponses.add(3);
        uneQuestion = new QuestionAChoixMultiple("un énoncé", bonneReponses);
    }

    @Test
    public void testGetEnonce() {
        //when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resEnonce);
        //and : l'énoncé est bien celui fournit à la construction
        assertEquals(resEnonce, "un énoncé");
    }

    @Test
    public void testGetScoreForIndice() {
        //when : on fourni une bonne réponse
        int indice = 1;
        //and : on demande le calcul du score
        Float resScore = uneQuestion.getScoreForIndice(indice);
        //then : le score est bien à 50
        assertEquals(new Float(50f), resScore);
        //when : on fourni une mauvaise réponse
        indice = 2;
        //and : on demande le calcul du score
        resScore = uneQuestion.getScoreForIndice(indice);
        //then : le score est bien à 0
        assertEquals(new Float(0f), resScore);
    }
}