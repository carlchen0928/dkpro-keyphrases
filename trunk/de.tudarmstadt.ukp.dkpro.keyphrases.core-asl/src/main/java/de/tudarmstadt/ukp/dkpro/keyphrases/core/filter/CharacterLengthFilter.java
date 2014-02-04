package de.tudarmstadt.ukp.dkpro.keyphrases.core.filter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.uima.fit.descriptor.ConfigurationParameter;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;

public class CharacterLengthFilter
    extends AbstractCandidateFilter
{

    public static final String MIN_KEYPHRASE_LENGTH = "MinKeyphraseLength";
    @ConfigurationParameter(name = MIN_KEYPHRASE_LENGTH)
    private int minLength;

    public static final String MAX_KEYPHRASE_LENGTH = "MaxKeyphraseLength";
    @ConfigurationParameter(name = MAX_KEYPHRASE_LENGTH)
    private int maxLength;

    @Override
    public List<Keyphrase> filterCandidates(Collection<Keyphrase> keyphrases)
    {
        List<Keyphrase> keyphrasesToBeRemoved = new LinkedList<Keyphrase>();
        for (Keyphrase keyphrase : keyphrases) {
            if (keyphrase.getKeyphrase().length() < minLength || keyphrase.getKeyphrase().length() > maxLength) {
                keyphrasesToBeRemoved.add(keyphrase);
            }
        }
        return keyphrasesToBeRemoved;
    }
}