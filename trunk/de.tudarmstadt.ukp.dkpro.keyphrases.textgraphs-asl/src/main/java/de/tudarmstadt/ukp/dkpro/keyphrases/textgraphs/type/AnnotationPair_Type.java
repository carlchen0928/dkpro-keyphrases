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
package de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed May 22 14:44:24 CEST 2013
 * @generated */
public class AnnotationPair_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AnnotationPair_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AnnotationPair_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AnnotationPair(addr, AnnotationPair_Type.this);
  			   AnnotationPair_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AnnotationPair(addr, AnnotationPair_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnnotationPair.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
 
  /** @generated */
  final Feature casFeat_Annotation1;
  /** @generated */
  final int     casFeatCode_Annotation1;
  /** @generated */ 
  public int getAnnotation1(int addr) {
        if (featOkTst && casFeat_Annotation1 == null)
      jcas.throwFeatMissing("Annotation1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Annotation1);
  }
  /** @generated */    
  public void setAnnotation1(int addr, int v) {
        if (featOkTst && casFeat_Annotation1 == null)
      jcas.throwFeatMissing("Annotation1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    ll_cas.ll_setRefValue(addr, casFeatCode_Annotation1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Annotation2;
  /** @generated */
  final int     casFeatCode_Annotation2;
  /** @generated */ 
  public int getAnnotation2(int addr) {
        if (featOkTst && casFeat_Annotation2 == null)
      jcas.throwFeatMissing("Annotation2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Annotation2);
  }
  /** @generated */    
  public void setAnnotation2(int addr, int v) {
        if (featOkTst && casFeat_Annotation2 == null)
      jcas.throwFeatMissing("Annotation2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    ll_cas.ll_setRefValue(addr, casFeatCode_Annotation2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_StringRepresentation1;
  /** @generated */
  final int     casFeatCode_StringRepresentation1;
  /** @generated */ 
  public String getStringRepresentation1(int addr) {
        if (featOkTst && casFeat_StringRepresentation1 == null)
      jcas.throwFeatMissing("StringRepresentation1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    return ll_cas.ll_getStringValue(addr, casFeatCode_StringRepresentation1);
  }
  /** @generated */    
  public void setStringRepresentation1(int addr, String v) {
        if (featOkTst && casFeat_StringRepresentation1 == null)
      jcas.throwFeatMissing("StringRepresentation1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    ll_cas.ll_setStringValue(addr, casFeatCode_StringRepresentation1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_StringRepresentation2;
  /** @generated */
  final int     casFeatCode_StringRepresentation2;
  /** @generated */ 
  public String getStringRepresentation2(int addr) {
        if (featOkTst && casFeat_StringRepresentation2 == null)
      jcas.throwFeatMissing("StringRepresentation2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    return ll_cas.ll_getStringValue(addr, casFeatCode_StringRepresentation2);
  }
  /** @generated */    
  public void setStringRepresentation2(int addr, String v) {
        if (featOkTst && casFeat_StringRepresentation2 == null)
      jcas.throwFeatMissing("StringRepresentation2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.AnnotationPair");
    ll_cas.ll_setStringValue(addr, casFeatCode_StringRepresentation2, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AnnotationPair_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Annotation1 = jcas.getRequiredFeatureDE(casType, "Annotation1", "uima.tcas.Annotation", featOkTst);
    casFeatCode_Annotation1  = (null == casFeat_Annotation1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Annotation1).getCode();

 
    casFeat_Annotation2 = jcas.getRequiredFeatureDE(casType, "Annotation2", "uima.tcas.Annotation", featOkTst);
    casFeatCode_Annotation2  = (null == casFeat_Annotation2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Annotation2).getCode();

 
    casFeat_StringRepresentation1 = jcas.getRequiredFeatureDE(casType, "StringRepresentation1", "uima.cas.String", featOkTst);
    casFeatCode_StringRepresentation1  = (null == casFeat_StringRepresentation1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_StringRepresentation1).getCode();

 
    casFeat_StringRepresentation2 = jcas.getRequiredFeatureDE(casType, "StringRepresentation2", "uima.cas.String", featOkTst);
    casFeatCode_StringRepresentation2  = (null == casFeat_StringRepresentation2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_StringRepresentation2).getCode();

  }
}



    