FROM python:3.10

WORKDIR /src/python

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY . .

CMD ["python3", "/src/python/socket_serveur.py"]