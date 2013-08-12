/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.keyphrases.core.filter;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createPrimitiveDescription;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.resource.ResourceInitializationException;

public class StopwordFilterFactory {

    public static AnalysisEngineDescription getStopwordFilter_english()
    throws ResourceInitializationException
    {
        return createPrimitiveDescription(
                StopwordFilter.class,
                StopwordFilter.PARAM_STOPWORD_LIST, "classpath:/stopwords/english_stopwords.txt");
    }
}
