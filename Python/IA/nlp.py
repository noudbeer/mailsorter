import nltk
import gensim
import re
from nltk.tokenize import word_tokenize
from nltk.stem import WordNetLemmatizer
from nltk.corpus import stopwords
from gensim.corpora import Dictionary
from gensim.models import LdaModel

def getTopicByText(text):
    #retrait des ponctuations
    text = text.lower()
    text = re.sub(r'[^\w\s]','',text)

    text_tk = tokenization(text)
    text_ln = lemmantization(text_tk)
    text_sw = removeStopWords(text_ln)

    #retirer les tokens de moins de 3 lettres (génère du bruit)
    text_min = [word for word in text_sw if len(word) >3]

    return topicModeling(text_min)


def tokenization(text):
    #modèle de tokénisation
    try:
        nltk.find('punkt')
    except LookupError:
        nltk.download('punkt')

    #transorme le texte en list par tokénisation
    return word_tokenize(text)



def lemmantization(text):
    #importation de librairies pour lemmantisation
    try:
        nltk.find('omw-1.4')
    except LookupError:
        nltk.download('omw-1.4')
    
    try:
        nltk.find('wordnet')
    except LookupError:
        nltk.download('wordnet')

    #normalise un texte suivant le context identifé
    # ex (suis,es,est,sommes,êtes,sont ==> être)
    lemmantizer = WordNetLemmatizer()
    return [lemmantizer.lemmatize(word) for word in text]

def removeStopWords(text):
    try:
        nltk.find('stopwords')
    except LookupError:
        nltk.download('stopwords')

    #charger les stopwords, français
    #les stopwords sont des mots qui apporte du bruit à l'analyse, on souhaite les retirer
    stop_words = stopwords.words('french')

    return [word for word in text if not word in stop_words]

def topicModeling(text):
    dico = Dictionary([text[:]])
    
    #Bag of word
    text_bow = [dico.doc2bow(text)]

    #Latent Dirichlet Allocation
    lda = LdaModel(corpus=text_bow, id2word=dico, num_topics=1) #Un seul topic
    return lda.show_topic(0)[0][0]   # [(word,lda)]