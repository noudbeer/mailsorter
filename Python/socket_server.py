import socket
from IA.nlp import getTopicByText

def donnerPersonneCompetente(listenSocket):
    print("Le serveur est prêt à donner la personne. " + "Il est en attente de demandes de client(s) sur le port . \n" + str(listenSocket.getsockname()[0]) + str(listenSocket.getsockname()[1]))
    try:
        while True:
            (clientsocket, address) = listenSocket.accept()
            try:
                messageDuServeur = clientsocket.recv(1024).decode()
                topic = getTopicByText(messageDuServeur)
                clientsocket.send(topic.encode())
            finally:
                clientsocket.close()
    finally:
        listenSocket.close()



if __name__ == '__main__':
    serverSocket = socket.socket()
    # Bind and listen
    serverSocket.bind(("127.0.0.1",9090))
    serverSocket.listen()
    try:
        #ouvrirConnexion(serverSocket)
        donnerPersonneCompetente(serverSocket)
    except Exception as e:
        print(e)