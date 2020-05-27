NOTE: You can't run Q01, Q03, Q05, Q06, Q07, Q08 directly using your IDE but you need to run 
      '.jar' from your command prompt. Follow below steps:

	1. At first Server has to be run so for that open your command prompt and go to the 
	   server 'jar' file path which is inside
		=> out->artifacts-> _jar folder (For Intellij IDEA)
		  (if it's netbeans IDE then jar file would be inside 'dist' folder.)

	   E.g:- (For Q01_TCPSocket)
	  	 cd Desktop\Assignment_5\Q01_TCPSocket\ServerSide\out\artifacts\ServerSide_jar
		
	2. After going to that path now we have to run jar file for that:
			java -jar jarfilename.jar

	   E.g:- (For Q01_TCPSocket)
	   cd Desktop\Assignment_5\Q01_TCPSocket\ServerSide\out\artifacts\ServerSide_jar>java -jar ServerSide.jar

	3. Similarly after that you have to run client 'jar' file as well using command prompt.
		