# Skim.py
Skimpy is a web application with which you can shorten URLs and view some statistics on the shortened URL, such us clicks, origin of clicks, top 10 shortened URLs clicked.

It's builded with:

- Spark Java (back-end API)
- AngularJS (web client)
- MongoDB running with docker

### Installation





```sh
git clone https://github.com/gioelegentile/Skim.py
cd  Skim.py
docker build -t skim.py . 
docker run -d -p 8080:8080 -p 27017:27017 --name=skim.py skim.py
docker exec -it skim.py bash
./start
```

### Port Forwarding
Host IP-----Port-----Guest IP----Port 
  
127.0.0.1--8080----0.0.0.0-----8080

### Run Service
* Go [localhost:8080](localhost:8080)
* Fun

### Test Check.js
* Go [http://localhost:8080/test/testCheck](http://localhost:8080/test/testCheck)
