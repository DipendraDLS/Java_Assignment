1. Start your 'Xampp'
2. At first create the database using sql query which is inside 'src' folder in 'script.sql' file.
   or simply You can also import 'JavaJdbc.sql' and 'bank.sql' database.
3. Note:
	a) Inside each source code:
	   If windows:
		String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
        	String username = "root";
       		String password= ""; 
 
	    If Linux:
		String url = "jdbc:MySQL://localhost:3306/JavaJDBC";
        	String username = "db_username"; --> your localhost username.
       		String password= "db_password";  --> your localhost password

4) Extra(Not needed here in my project):
	- I have also attached mariadb connector jar file. If you are creating your own project
	  and want to connect database with your project then you must implement the connection 
	  using mariadb connector jar file. 
	- To implement it follow given link:-
		
		For Netbeans:
		https://www.youtube.com/watch?v=9BqHWF_-Fk0
		
		For Intellij IDEA
		https://www.youtube.com/watch?v=T5Hey0e2Y_g