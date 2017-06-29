# CPSC-320-Quiz
multiple choice and short answer quiz based on CPSC 320

  Manifest has the multiple choice quiz as the main activity. Used buttons for answers and textedit for question. Stored answers in an 
object that holds an array of the answer, double array for other answers and and single array for question. Indexes correlated so that when
 I used getters to pull variables they'd be for the same question. I set the getters to pull a specific index rather than the whole data
structure because I had index set as a global variable, so that way when I passed it to the getters I knew I'd return variables all
correlated to the same question. 
  For the short answer I did multilinetext because the questions were a bit longer, but the answers were short. I wanted the users to be
 able to get partial marks for abbreviated answers, so I implemented a Levenshtein algorithm to check within a threshold of 4. I used also 
passed the score to intent so that it'd be saved when switching activities so I could show the score at the end.
