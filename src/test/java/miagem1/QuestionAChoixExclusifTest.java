package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {
    private QuestionAChoixExclusif uneQuestion;

    /**
     *
     * @throws Exception
     */
    //signifie que la méthode va être executer avant chaque test
    @Before
    public void setUp() throws Exception {
        //given : un objet de type QuestionAChoixExclusif
        uneQuestion = new QuestionAChoixExclusif("un enoncé", 2);
    }

    @Test
    public void testGetEnonce() {
        //when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resEnonce);
        //and : l'énoncé est bien celui fournit à la construction
        assertEquals(resEnonce, "un enoncé");
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 2;
        //and : on demande le calcul du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score est bien à 100
        assertEquals(new Float(100f), resScore);
        //when : un étudiant fourni l'indice correspondant à la mauvaise réponse
        indiceEtudiant = 1;
        //and : on demande le calcul du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score est bien à 0
        assertEquals(new Float(0f), resScore);
    }
}