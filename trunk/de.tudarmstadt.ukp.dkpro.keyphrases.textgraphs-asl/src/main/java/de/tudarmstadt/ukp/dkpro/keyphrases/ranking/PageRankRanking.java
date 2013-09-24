/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.keyphrases.ranking;

import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.util.PageRank;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.util.PageRank.Term;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.util.PageRank.TermRank;

public class PageRankRanking extends JCasAnnotator_ImplBase {
    public static final String PARAM_WEIGHTED = "Weighted";
    @ConfigurationParameter(name=PARAM_WEIGHTED, mandatory=true, defaultValue="true")
    private boolean weighted;

    private PageRank pageRank;

    @Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);

        pageRank = new PageRank();

    }

    @Override
    public void process(JCas jcas) throws AnalysisEngineProcessException {
        getContext().getLogger().log(Level.CONFIG, "Entering " + this.getClass().getSimpleName());

        pageRank.initializeFromAnnotationPairIterator(
                JCasUtil.select(jcas, AnnotationPair.class),
                weighted
        );

        pageRank.run();

        List<TermRank> termRanks = pageRank.getTermRanks();
        getContext().getLogger().log(Level.FINE, termRanks.toString());
        for (TermRank termRank : termRanks) {
            addKeyphrase(jcas, termRank);
        }
    }

    private void addKeyphrase(JCas jcas, TermRank termRank) {
        String termStringRepresentation = termRank.getStringRepresentation();
        double score = termRank.getScore();

        for (Term term : termRank.getTermList()) {
            int[] offset = term.getOffset();

            Keyphrase keyphrase = new Keyphrase(jcas);
            keyphrase.setKeyphrase(termStringRepresentation);
            keyphrase.setScore(score);
            keyphrase.setBegin(offset[0]);
            keyphrase.setEnd(offset[1]);
            keyphrase.addToIndexes();
        }
    }
}