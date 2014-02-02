package de.tudarmstadt.ukp.dkpro.keyphrases.core.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.CONJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.ngrams.NGramAnnotator;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.core.treetagger.TreeTaggerPosLemmaTT4J;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.candidate.CandidateAnnotatorFactory;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.filter.factory.PosSequenceFilterFactory;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;

public class PosSequenceFilterTest
{

    private final static String testDocument = "Mr Smith knows plug and play methodology.";

    @Test
    public void test()
        throws ResourceInitializationException, AnalysisEngineProcessException
    {

        List<String[]> posSequences = new ArrayList<String[]>();
        String[] firstSequence = new String[3];
        firstSequence[0] = N.class.getCanonicalName();
        firstSequence[1] = CONJ.class.getCanonicalName();
        firstSequence[2] = N.class.getCanonicalName();
        String[] secondSequence = new String[2];
        secondSequence[0] = N.class.getCanonicalName();
        secondSequence[1] = N.class.getCanonicalName();
        posSequences.add(firstSequence);
        posSequences.add(secondSequence);
        AnalysisEngine engine = AnalysisEngineFactory.createEngine(
                AnalysisEngineFactory.createEngineDescription(
                    AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                    AnalysisEngineFactory.createEngineDescription(TreeTaggerPosLemmaTT4J.class),
                    AnalysisEngineFactory.createEngineDescription(NGramAnnotator.class,
                            NGramAnnotator.PARAM_N, 3),
                    CandidateAnnotatorFactory.getKeyphraseCandidateAnnotator_ngram(false),
                    PosSequenceFilterFactory.createPosSequenceFilter(posSequences)));
        JCas jcas = engine.newJCas();
        jcas.setDocumentLanguage("en");
        jcas.setDocumentText(testDocument);
        engine.process(jcas);
        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("Mr Smith");
        expectedResults.add("plug and play");
        expectedResults.add("play methodology");

        int i = 0;
        for (Keyphrase kc : JCasUtil.select(jcas, Keyphrase.class)) {
            System.out.println(kc);
            assertTrue(expectedResults.contains(kc.getKeyphrase()));
            i++;
        }
        assertEquals(3, i);
    }

}
