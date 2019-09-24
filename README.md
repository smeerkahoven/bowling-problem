# bowling-problem
this is resolution for jobsity bowling problem

-----------------------
Command Line Arguments
-----------------------

Example : java -jar bowling-1.0.jar /path/to/score.txt

-----------------------
Compiling
-----------------------
To compile project there is a build.sh file that executes
maven command. Give execution permission and type from 
command line

 sh build.sh

-----------------------
Running
-----------------------
To run the program check run.sh file. It contains the 
command line arguments to execute the program.

You must modify /path/to/score.txt to obtain results.
You can type from command line to run program

sh run.sh

-----------------------
Analysis
-----------------------
Please Check BowlingScoreTraditional Class is where the scoring
algorithm is developed.

There are three cases that were evaluated. These are on files
   score.txt
   score_spare.txt
   score_strike.txt

Please modify these files to obtain the results you want and execute
the program
-----------------------
Testing
-----------------------
Please when testing BowlingScoreAppTest class, you should modify path files 
parameters variables with your full path values

fileStrike
fileSpare
fileScore

-----------------------
Author
-----------------------
smeerkahove@gmail.com

