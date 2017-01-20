# RMEmulator
CPSC-3740

TODO modify:
To Compile and Run: 
1. Navigate to proj_3780 3. Make a directory called "out" 
2. Run the command: javac -cp resources/commons-cli-1.3.1.jar:. -d out src/client/.java src/com/.java src/server/*.java 
3. To run the client (be in the "out" folder): java -cp ../resources/commons-cli-1.3.1.jar:. client/ClientApplication -s <server ip> 
4. To run the server (be in the "out" folder): java -cp ../resources/commons-cli-1.3.1.jar:. client/ClientApplication -s1 <server i-1 ip> -s2 <server i+1 ip>
I have also included pre-compiled jars within build/client(or server) which can be ran with: java -jar client(server).jar if the above throws an error do: java -cp resources/commons-cli-1.3.1.jar:. -jar client(server).jar
