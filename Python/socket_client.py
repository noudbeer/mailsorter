import socket


def ouvrirConnexion(ip,port):
  try:
    s = socket.socket() # tentative de connexion au serveur
    s.connect((ip, port))
    return s
  except:
    print("Error: Unable to open connection")



def demanderPersonneCompetente(soc,text):
  try:
    soc.send(text.encode())
    input = soc.recv(1024).decode()
    return input
  except:
    print("Error")




if __name__ == '__main__':
  try:
    soc = ouvrirConnexion('127.0.0.1', 9090)
    text = input()
    result = demanderPersonneCompetente(soc, text)
    print(result)
  except Exception as e:
      print(e)