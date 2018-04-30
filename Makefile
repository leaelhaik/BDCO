
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter

# Ensimag 2A BDCO 


all: testSimulator  

testSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestSimulateur.java

testIGEchiquier:
	javac -d bin -classpath bin/ojdbc6.jar -sourcepath src src/TestIGEchiquier.java




# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM


exeSimulator:
	java -classpath bin:bin/gui.jar Simulator

exeIGEchiquier:
	java -classpath bin:bin/ojdbc6.jar TestIGEchiquier

clean:
	rm -rf bin/*.class
	rm -rf bin/**/*.class
	rm -rf bin/**/**/*.class

